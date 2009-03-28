package ar.com.cosgui.guielements;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import ar.com.cosgui.datamodel.DataModel;

public class MegaParent {
	public MegaParent(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width,screenSize.height);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		TaskBarDesktopPane tdp = new TaskBarDesktopPane();
		MainBugMailForm main = new MainBugMailForm(tdp);
		GuiUtils.centerOnParent(main, frame);
		main.setLocation(main.getX() - 250, main.getY());
		tdp.add(main);
		MainChat chat = new MainChat(DataModel.INSTANCE.getActiveUser(),DataModel.INSTANCE.getActiveUserPass(),tdp);
		GuiUtils.centerOnParent(chat, frame);
		chat.setLocation(chat.getX() + 250, chat.getY());
		tdp.add(chat);       
		frame.getContentPane().add(tdp);
		frame.setVisible(true);
	}
}
