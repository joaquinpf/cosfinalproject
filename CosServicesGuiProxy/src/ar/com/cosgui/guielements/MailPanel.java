/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanlMail.java
 *
 * Created on 22/03/2009, 17:12:34
 */

package ar.com.cosgui.guielements;

/**
 *
 * @author Administrator
 */
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Vector;

import ar.com.cosgui.services.ServicePoint;
import ar.com.cosgui.services.ServicesConstants;
import ar.com.cosgui.services.imp.MailServiceLocalImp;

import Mail;

public class MailPanel extends javax.swing.JPanel {
	private Vector<Mail> userMails = new Vector<Mail>();
	private Vector<Mail> userSavedMails = new Vector<Mail>();
	private MailServiceLocalImp service = (MailServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.MAIL_SERVICE);
	private String username = null;
	private String password = null;
	
    /** Creates new form PanlMail */
    public MailPanel(String username, String password) {
        initComponents();
        this.username = username;
        this.password = password;
        this.loadMails(username, password);
    }

    private Vector<Mail> getMails(String status, String username, String password) {
    	Vector<Mail> filtred = new Vector<Mail>();
    	String[] mails = null;
    	try {
			mails = service.getMails(username, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (mails != null)
			for (int i = 0; i < mails.length; i++) {
				Mail mail = this.getMailFromString(mails[i]);
				if (mail.getStatus().equalsIgnoreCase(status))
					filtred.addElement(mail);
			}
    	return filtred;
    }

    private void loadMails(String username, String password) {
    	this.userMails = this.getMails("new", username, password);
    	this.userSavedMails = this.getMails("saved", username, password);
        this.printMails();
    }

    private void printMails() {
    	Mail actualMail = null;
    	Iterator<Mail> it = null;
    	Vector<String> addeds = new Vector<String>();
    	for(it = userMails.iterator(); it.hasNext();){
    		actualMail = it.next();
    		addeds.add("From: " + actualMail.getFrom() + "     --     Subject: " + actualMail.getSubject());
    	}
		this.listMails.setListData(addeds);

    	addeds = new Vector<String>();
    	for(it = userSavedMails.iterator(); it.hasNext();){
    		actualMail = it.next();
    		addeds.add("From: " + actualMail.getFrom() + "     --     Subject: " + actualMail.getSubject());
    	}
		this.listSavedMails.setListData(addeds);
}

    private Mail getMailFromString(String mailString) {
    	Mail mail = new Mail();
    	char[] texto = mailString.toCharArray();
    	int j = 0;
    	for (int i = 0; i < 5; i++) {
    		String cadena = new String();
    		while (j < texto.length && texto[j] != '|') {
    			cadena += texto[j];
    			j++;
    		}
    		j++;
    		switch (i) {
				case 0: mail.setStatus(cadena); break;
				case 1: mail.setFrom(cadena); break;
				case 2: mail.setTo(cadena); break;
				case 3: mail.setSubject(cadena); break;
				case 4: mail.setText(cadena); break;
    		}
    	}
    	return mail;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdNewMail = new javax.swing.JButton();
        cmdViewMail = new javax.swing.JButton();
        cmdVerifyNewMails = new javax.swing.JButton();
        cmdDeleteMailSaved = new javax.swing.JButton();
        cmdViewMailSaved = new javax.swing.JButton();
        cmdSave = new javax.swing.JButton();
        cmdDeleteMail = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMails = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listSavedMails = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        cmdNewMail.setText("New mail");
        cmdNewMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNewMailActionPerformed(evt);
            }
        });

        cmdViewMail.setText("View");
        cmdViewMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdViewMailActionPerformed(evt);
            }
        });

        cmdVerifyNewMails.setText("Verify new mails");
        cmdVerifyNewMails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVerifyNewMailsActionPerformed(evt);
            }
        });

        cmdDeleteMailSaved.setText("Delete");
        cmdDeleteMailSaved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteMailSavedActionPerformed(evt);
            }
        });

        cmdViewMailSaved.setText("View");
        cmdViewMailSaved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdViewMailSavedActionPerformed(evt);
            }
        });

        cmdSave.setText("Save");
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });

        cmdDeleteMail.setText("Delete");
        cmdDeleteMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteMailActionPerformed(evt);
            }
        });

        listMails.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listMails);

        listSavedMails.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        listSavedMails.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listSavedMails);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14));
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Mails");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14));
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Mails saved");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Personal mail");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cmdViewMailSaved)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdDeleteMailSaved))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cmdViewMail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdDeleteMail))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54)
                        .addComponent(cmdNewMail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdVerifyNewMails))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmdNewMail)
                    .addComponent(cmdVerifyNewMails))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdViewMail)
                    .addComponent(cmdSave)
                    .addComponent(cmdDeleteMail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdViewMailSaved)
                    .addComponent(cmdDeleteMailSaved))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdNewMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewMailActionPerformed
        NewMail nm = new NewMail(username, password);
        nm.setVisible(true);
    }//GEN-LAST:event_cmdNewMailActionPerformed

    private void cmdVerifyNewMailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVerifyNewMailsActionPerformed
    	this.loadMails(username, password);
    }//GEN-LAST:event_cmdVerifyNewMailsActionPerformed

    private void cmdViewMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdViewMailActionPerformed
    	Mail mail = null;
    	if (this.listMails.getSelectedIndex() <= userMails.size() && this.listMails.getSelectedIndex() >= 0)
    		mail = userMails.elementAt(this.listMails.getSelectedIndex());
    	if (mail != null) {
        	ViewMessage vm = new ViewMessage (mail.getFrom(), mail.getTo(), mail.getSubject(), mail.getText());
    		vm.setVisible(true);
    	}
    }//GEN-LAST:event_cmdViewMailActionPerformed

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
    	Mail mail = null;
    	if (this.listMails.getSelectedIndex() <= userMails.size() && this.listMails.getSelectedIndex() >= 0)
    		mail = userMails.elementAt(this.listMails.getSelectedIndex());
		try {
			service.saveMail(this.username, this.password, mail.getFrom(), mail.getSubject(), mail.getText(), mail.getStatus());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		this.loadMails(this.username, this.password);
    }//GEN-LAST:event_cmdSaveActionPerformed

    private void cmdDeleteMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteMailActionPerformed
    	Mail mail = null;
    	if (this.listMails.getSelectedIndex() <= userMails.size() && this.listMails.getSelectedIndex() >= 0)
    		mail = userMails.elementAt(this.listMails.getSelectedIndex());
		try {
			service.deleteMail(this.username, this.password, mail.getFrom(), mail.getSubject(), mail.getText(), mail.getStatus());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		this.loadMails(this.username, this.password);
    }//GEN-LAST:event_cmdDeleteMailActionPerformed

    private void cmdViewMailSavedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdViewMailSavedActionPerformed
    	Mail mail = null;
    	if (this.listSavedMails.getSelectedIndex() <= userSavedMails.size() && this.listSavedMails.getSelectedIndex() >= 0)
    		mail = userSavedMails.elementAt(this.listSavedMails.getSelectedIndex());
    	if (mail != null) {
        	ViewMessage vm = new ViewMessage (mail.getFrom(), mail.getTo(), mail.getSubject(), mail.getText());
    		vm.setVisible(true);
    	}
    }//GEN-LAST:event_cmdViewMailSavedActionPerformed

    private void cmdDeleteMailSavedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteMailSavedActionPerformed
    	Mail mail = null;
    	if (this.listSavedMails.getSelectedIndex() <= userSavedMails.size() && this.listSavedMails.getSelectedIndex() >= 0)
    		mail = userSavedMails.elementAt(this.listSavedMails.getSelectedIndex());
		try {
			service.deleteMail(this.username, this.password, mail.getFrom(), mail.getSubject(), mail.getText(), mail.getStatus());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		this.loadMails(this.username, this.password);
    }//GEN-LAST:event_cmdDeleteMailSavedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDeleteMail;
    private javax.swing.JButton cmdDeleteMailSaved;
    private javax.swing.JButton cmdNewMail;
    private javax.swing.JButton cmdSave;
    private javax.swing.JButton cmdVerifyNewMails;
    private javax.swing.JButton cmdViewMail;
    private javax.swing.JButton cmdViewMailSaved;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listMails;
    private javax.swing.JList listSavedMails;
    // End of variables declaration//GEN-END:variables

}
