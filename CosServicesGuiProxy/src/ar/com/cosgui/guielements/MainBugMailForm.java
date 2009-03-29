/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainBugMailForm.java
 *
 * Created on 28/03/2009, 14:11:21
 */

package ar.com.cosgui.guielements;

import ar.com.cosgui.datamodel.Bug;
import ar.com.cosgui.datamodel.DataModel;
import ar.com.cosgui.datamodel.Notificator;
import ar.com.cosgui.services.IBugTrackerServiceLocalImp;
import ar.com.cosgui.services.IProjectTeamServiceLocalImp;
import ar.com.cosgui.services.ServicePoint;
import ar.com.cosgui.services.ServicesConstants;
import ar.com.cosgui.services.imp.BugTrackerServiceLocalImp;
import ar.com.cosgui.services.imp.ProjectTeamServiceLocalImp;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kireta
 */
public class MainBugMailForm extends javax.swing.JInternalFrame implements Runnable {

    private Thread reader = null;
    private int activeThread = 1;
    private boolean filtering = false;
    private TaskBarDesktopPane parent = null;
    
    /** Creates new form MainBugMailForm */
    public MainBugMailForm(TaskBarDesktopPane parent) {
    	this.parent = parent;
        initComponents();
        initTable();
        createPopupMenu();
        reader = new Thread(this);
        reader.start();
        GuiUtils.centerOnScreen(this);
        this.toFront();
        this.setVisible(true);
        this.setIconifiable(true);
        this.setTitle("Main window");
        this.setLayer(1);
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
				IBugTrackerServiceLocalImp bug = (IBugTrackerServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.BUG_TRACKING_SERVICE);
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
				IBugTrackerServiceLocalImp bugtracker = (IBugTrackerServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.BUG_TRACKING_SERVICE);
                Bug b = bugtracker.getBug(bug);

                IProjectTeamServiceLocalImp project = (IProjectTeamServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.PROJECT_TEAM_SERVICE);
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
                	parent.add(nm);
                	parent.setSelectedFrame(nm);
                	nm.setVisible(true);
                }
			}
		});
		menu.add(mail);
		jTable1.add(menu);
	}

    /**
     * Inicializa la tabla con los bugs provistos por ServicePoint para los proyectos
     * a los que el usuario actual esta suscripto
     */
	private void initTable(){
    	IProjectTeamServiceLocalImp proj = (IProjectTeamServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.PROJECT_TEAM_SERVICE);
    	IBugTrackerServiceLocalImp bug = (IBugTrackerServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.BUG_TRACKING_SERVICE);

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
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Issues", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );

        MailPanel mail = new MailPanel(DataModel.INSTANCE.getActiveUser(), DataModel.INSTANCE.getActiveUserPass(), this.parent);
        jTabbedPane1.add("Mail", mail);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        if((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK)
            menu.show(jTable1, evt.getX(), evt.getY());
}//GEN-LAST:event_jTable1MousePressed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK)
            menu.show(jTable1, evt.getX(), evt.getY());
}//GEN-LAST:event_jTable1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        initTable();
        if(jTextField1.getText().replaceAll(" ","").equals("") == false){
            filterRows(jTextField1.getText());
            filtering = true;
        } else {
            filtering = false;
        }
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ProjectSubscriptionDialog frame = new ProjectSubscriptionDialog(parent);
        parent.add(frame);
        parent.setSelectedFrame(frame);
        frame.setVisible(true);
        initTable();
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        SubmitBugForm frame = new SubmitBugForm(parent);
        parent.add(frame);
        parent.setSelectedFrame(frame);
        frame.setVisible(true);
        initTable();
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
