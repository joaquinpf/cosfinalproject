/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ActiveChat.java
 *
 * Created on 22/03/2009, 16:05:18
 */

package ar.com.cosgui.guielements;

//import ar.com.cosgui.datamodel.DataModel;
import java.rmi.RemoteException;

import ar.com.cosgui.services.ServicePoint;
import ar.com.cosgui.services.ServicesConstants;
import ar.com.cosgui.services.imp.ChatServiceLocalImp;
/**
 *
 * @author Administrator
 */
public class ActiveChat extends javax.swing.JFrame {
	private ChatServiceLocalImp service = (ChatServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.CHAT_SERVICE);
	private String username = null;
    private String contactName = null;

    /** Creates new form ActiveChat */
    public ActiveChat(String username, String contactName) {
        initComponents();
        this.username = username;
        this.contactName = contactName;
        this.lblUsername.setText(contactName);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtChatText = new javax.swing.JTextArea();
        cmdSend = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSendText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14));
        jLabel1.setText("Active chat");

        lblUsername.setText("<username>");

        txtChatText.setColumns(20);
        txtChatText.setRows(5);
        txtChatText.setFocusable(false);
        jScrollPane1.setViewportView(txtChatText);

        cmdSend.setText("Send");
        cmdSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSendActionPerformed(evt);
            }
        });

        cmdClose.setText("Close");
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        txtSendText.setColumns(20);
        txtSendText.setRows(5);
        jScrollPane2.setViewportView(txtSendText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(lblUsername, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmdClose, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsername)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdSend, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdClose)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSendActionPerformed
    	try {
			this.service.sendMessage(this.txtSendText.getText(), this.username, this.contactName);
			this.printMessage(this.txtSendText.getText(), this.username, this.contactName);
			this.txtSendText.setText("");
			this.txtSendText.transferFocus();
    	} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}//GEN-LAST:event_cmdSendActionPerformed

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
    	this.dispose();
}//GEN-LAST:event_cmdCloseActionPerformed

    public void printMessage (String message, String usernameSrc, String usernameDst) {
        if ((message != null) && (usernameSrc != null) && (usernameDst != null))
        	this.txtChatText.setText(this.txtChatText.getText() + "\n" + usernameSrc + " to " + usernameDst + ": " + message);
    }

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextArea txtChatText;
    private javax.swing.JTextArea txtSendText;
    // End of variables declaration//GEN-END:variables

}
