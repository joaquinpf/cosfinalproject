package ar.com.cosgui.guielements;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Joaquín Alejandro Pérez Fuentes, based on non-functional code from google.
 */
public class TaskBarDesktopPane extends JPanel
{
	private static final long serialVersionUID = 5611945528468123470L;
	private JPanel taskBar;
	private JPanel invisiblePanel;
	private JDesktopPane desktopPane;
	private HashMap<Component,JButton> componentMap = new HashMap<Component, JButton>();

	/** Creates a new instance of TaskBarDesktopPane */
	public TaskBarDesktopPane() {
		desktopPane = createDesktopPane();   
		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("resources/SSBS.png");
		label.setIcon(icon);
		label.setVisible(true);
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width,screenSize.height-20);
		GuiUtils.centerOnParent(label, this);
		desktopPane.add(label);

		taskBar = createTaskBar();
		invisiblePanel = createInvisiblePanel();
		this.setLayout(new BorderLayout());        
		this.add(new JScrollPane(desktopPane),BorderLayout.CENTER);        
		this.add(taskBar,BorderLayout.SOUTH);   
	}

	private JPanel createTaskBar() {
		JPanel panel = new JPanel() {            
			private static final long serialVersionUID = 8648208622703735645L;
			public Component add(Component c) {
				if (c instanceof JInternalFrame.JDesktopIcon) {
					final JInternalFrame.JDesktopIcon icon = (JInternalFrame.JDesktopIcon) c;
					JInternalFrame f = icon.getInternalFrame();                    
					final JButton button = new JButton(f.getTitle(),f.getFrameIcon());
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev)	{
							try { 
								icon.getInternalFrame().setIcon(false);                  
								taskBar.remove(button);
								invisiblePanel.remove(icon);
								componentMap.remove(icon);
								desktopPane.add(icon.getInternalFrame());
							} catch (PropertyVetoException e) { 
								e.printStackTrace();
							}
						}
					});                    
					super.add(button);
					invisiblePanel.add(c);
					componentMap.put(c,button);
					if (!isVisible()) {
						setVisible(true);
					}                    

					super.revalidate();
					super.repaint();                 
					return button;
				} else {
					return desktopPane.add(c);       
				}                                                 
			}

			public void remove(Component comp) {
				super.remove(comp);
				if (getComponentCount() == 0) {
					setVisible(false);
				}
				invalidate();
				revalidate();
				repaint();
			}
		};
		panel.setVisible(false);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,2,1));        
		panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		return panel;
	}

	/*
	 * This invisible panel is used to hold JDesktopIcons while the TaskBar holds
	 * their imposter JButtons. This panel is needed as the DesktopManager will
	 * try to put the JInternaleFrame on the parent of the JDesktopIcon when
	 * deiconifying. Without this, there would not be a parent.
	 */
	private JPanel createInvisiblePanel() {
		JPanel panel = new JPanel() {
			private static final long serialVersionUID = 2061984393827089490L;
			public Component add(Component c) {
				if (c instanceof JInternalFrame.JDesktopIcon) {
					return super.add(c);        
				}
				else {
					return desktopPane.add(c);
				}
			}
			public void remove(Component comp) {
				if (comp instanceof JInternalFrame.JDesktopIcon) {                
					Component button = (Component)componentMap.remove(comp);
					super.remove(comp);
					taskBar.remove(button);
				}
				else {
					super.remove(comp);
				}
			}            
		};
		panel.setVisible(false);
		return panel;
	}


	private JDesktopPane createDesktopPane() {
		JDesktopPane panel = new JDesktopPane() {

			private static final long serialVersionUID = 5482959432853538055L;
			public Component add(Component c) {     
				if (c instanceof JInternalFrame.JDesktopIcon) {
					return taskBar.add(c);        
				}
				else {
					Component out = super.add(c);
					return out;
				}
			}            
		};
		return panel;
	}

	public Component add(Component c) {
		if (c instanceof JInternalFrame.JDesktopIcon) {             
			return taskBar.add(c);        
		}else {
			return desktopPane.add(c);
		}
	}

	public void setSelectedFrame(JInternalFrame frame) {
		desktopPane.setSelectedFrame(frame);		
	}
}