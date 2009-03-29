package ar.com.cosgui.guielements;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import ar.com.cosgui.datamodel.Bug;
import ar.com.cosgui.datamodel.DataModel;
import ar.com.cosgui.datamodel.Notificator;
import ar.com.cosgui.datamodel.TextMessage;
import ar.com.cosgui.services.ServicePoint;
import ar.com.cosgui.services.ServicesConstants;
import ar.com.cosgui.services.imp.BugTrackerServiceLocalImp;
import ar.com.cosgui.services.imp.ProjectTeamServiceLocalImp;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on 21/02/2009, 12:47:51
 */



/**
 * Ventana principal de la aplicacion
 * @author Joaquin Alejandro Perez Fuentes
 */
public class MainFrame extends javax.swing.JFrame implements Runnable {

    private Thread reader = null;
    private int activeThread = 1;
    private boolean filtering = false;
    
    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        initMockDatabase();
        initTable();
        createPopupMenu();
        reader = new Thread(this);
        reader.start();
        GuiUtils.centerOnScreen(this);
        this.toFront();
        jInternalFrame1.setIconifiable(true);
    }

    /**
     * Crea el menu popup a utilizar con el boton derecho del mouse sobre la tabla
     */
    private void createPopupMenu() {
		menu = new PopupMenu();
		MenuItem close = new MenuItem("Close bug");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldstatus = (String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 2);
				BugTrackerServiceLocalImp bug = (BugTrackerServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.BUG_TRACKING_SERVICE);
                Bug b = bug.changeBugStatus(Integer.parseInt((String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0)),"Closed");
                if(b != null){
            		Notificator.notifyStatusChange(b, oldstatus);
                }
            }
		});
		menu.add(close);
		MenuItem mail = new MenuItem("Mail about this");
		mail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bug = Integer.parseInt((String)jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0));
				BugTrackerServiceLocalImp bugtracker = (BugTrackerServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.BUG_TRACKING_SERVICE);
                Bug b = bugtracker.getBug(bug);

                ProjectTeamServiceLocalImp project = (ProjectTeamServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.PROJECT_TEAM_SERVICE);
                String[] users = project.getUsersForProject(b.getProject());
                String to = "";
                if(users != null && users.length >= 1 ){
            		to += users[0];
                	
                	for(int j=1;j<users.length;j++){
                		to += "," + users[j];
                	}
                }
                if(to.equals("") == false){
                	NewMail nm = new NewMail(DataModel.INSTANCE.getActiveUser(), DataModel.INSTANCE.getActiveUserPass(), 
                			"<COMMENT> Comment on " + b.getProject() + ", bug #" + bug, to
                			,"<FILL YOUR COMMENT HERE>");
                    jDesktopPane1.add(nm);
                    jDesktopPane1.setSelectedFrame(nm);
                	nm.setVisible(true);
                }
			}
		});
		menu.add(mail);
		jTable1.add(menu);
	}

    /**
     * Genera datos para el testeo de los servicios.
     */
    private void initMockDatabase() {
    	ProjectTeamServiceLocalImp proj = (ProjectTeamServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.PROJECT_TEAM_SERVICE);
    	proj.addProject("Proyecto final de COS", "Cos Project");
    	proj.addGroupToProject("Developers", "Cos Project", "Developers");
    	proj.addGroupToProject("Testers", "Cos Project", "Testers");
    	proj.addGroupToProject("Management", "Cos Project", "Management");
    	proj.addProject("Proyecto final de Grid", "Grid Project");
    	proj.addGroupToProject("Developers", "Grid Project", "Developers");
    	proj.addGroupToProject("Testers", "Grid Project", "Testers");
    	proj.addGroupToProject("Management", "Grid Project", "Management");
    }

    /**
     * Inicializa la tabla con los bugs provistos por ServicePoint para los proyectos
     * a los que el usuario actual esta suscripto
     */
	private void initTable(){
    	ProjectTeamServiceLocalImp proj = (ProjectTeamServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.PROJECT_TEAM_SERVICE);
    	BugTrackerServiceLocalImp bug = (BugTrackerServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.BUG_TRACKING_SERVICE);
    	
    	String[] projs = proj.getProjectsForUser(DataModel.INSTANCE.getActiveUser(),DataModel.INSTANCE.getActiveUserPass());
    	ArrayList<Bug> bugs = new ArrayList<Bug>();
    	
    	if(projs != null){
    		for(int i=0; i<projs.length;i++){
    			int[] projectBugs = bug.getBugsByProject(projs[i]);
    			if(projectBugs != null){
	    			for(int j=0; j<projectBugs.length;j++){
	    				bugs.add(bug.getBug(projectBugs[j]));
	    			}
    			}
    		}
    	}
    	
    	DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for(Bug b : bugs) {
        	Object row [] = {Integer.toString(b.getNumber()),b.getDescription(),b.getStatus(),b.getOwner(),
        			b.getType(),b.getProject()};
        	model.addRow(row);
        }
        jTable1.setModel(model);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDesktopPane1 = new TaskBarDesktopPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new BugTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(594, 557));
        jInternalFrame1.setVisible(true);

        jTable1.setModel(null);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtering"));

        jLabel1.setText("Filter");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Description", "Status", "Owner", "Type", "Project" }));

        jTextField1.setText("CosFinalProyect");

        jButton1.setText("Set");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));

        jButton2.setText("Suscribe to project");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Submit bug");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Issues", jPanel2);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
        );

        MailPanel mail = new MailPanel(DataModel.INSTANCE.getActiveUser(), DataModel.INSTANCE.getActiveUserPass());
        jTabbedPane1.add("Mail", mail);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 948, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(344, Short.MAX_VALUE)))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            ProjectSubscriptionDialog frame = new ProjectSubscriptionDialog(jDesktopPane1);
            jDesktopPane1.add(frame);
            jDesktopPane1.setSelectedFrame(frame);
            frame.setVisible(true);
            initTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            SubmitBugForm frame = new SubmitBugForm(jDesktopPane1);
            jDesktopPane1.add(frame);
            jDesktopPane1.setSelectedFrame(frame);
            frame.setVisible(true);
            initTable();
            
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Filtra la tabla segun lo ingresado.
     * Para lograr esto se debe reinicializar por si habia algun filtro activo.
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	initTable();
    	if(jTextField1.getText().replaceAll(" ","").equals("") == false){
    		filterRows(jTextField1.getText());    		
    		filtering = true;
    	} else {
    		filtering = false;
    	}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        if((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK)
           menu.show(jTable1, evt.getX(), evt.getY());
    }//GEN-LAST:event_jTable1MousePressed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK)
           menu.show(jTable1, evt.getX(), evt.getY());
    }//GEN-LAST:event_jTable1MouseReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    @Override
    public void run() {    	
    	int refresh = 0;
    	while (activeThread == 1) {

    		try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) { }

    		refresh++;
    		if (refresh == 5) {
    			refresh = 0;
    			initTable();
    			if(filtering == true){
    				filterRows(jTextField1.getText());
    			}
    		}
    	}
    }

    
    private void filterRows(String text) {    		
    	int col = jTable1.getColumnModel().getColumnIndex(jComboBox1.getSelectedItem());
    	DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    	ArrayList<Object[]> filteredRows = new ArrayList<Object[]>();

    	for(int i=0;i<model.getRowCount();i++){
    		if(model.getValueAt(i, col).equals(jTextField1.getText())){
    			Object row [] = {model.getValueAt(i, 0),model.getValueAt(i, 1),
    					model.getValueAt(i, 2),model.getValueAt(i, 3),model.getValueAt(i, 4),
    					model.getValueAt(i, 5),};
    			filteredRows.add(row);
    		}
    	}

    	model.setRowCount(0);

    	for(Object[] i:filteredRows){
    		model.addRow(i);
    	}
    }


	private PopupMenu menu;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
