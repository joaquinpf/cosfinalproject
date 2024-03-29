/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainChat.java
 *
 * Created on 22/03/2009, 15:24:39
 */

package ar.com.cosgui.guielements;

import java.util.Hashtable;
import java.util.Vector;

import ar.com.cosgui.datamodel.DataModel;
import ar.com.cosgui.datamodel.TextMessage;
import ar.com.cosgui.services.IChatServiceLocalImp;
import ar.com.cosgui.services.IProjectTeamServiceLocalImp;
import ar.com.cosgui.services.ServicePoint;
import ar.com.cosgui.services.ServicesConstants;
import ar.com.cosgui.services.imp.ChatServiceLocalImp;
import ar.com.cosgui.services.imp.ProjectTeamServiceLocalImp;

/**
 * Vista principal del mail (ventana de contactos).
 * @author Marcos Steimbach.
 */
public class MainChat extends javax.swing.JInternalFrame implements Runnable {

	/** Contiene las ventanas activas de chat del usuario. */
    private Hashtable<String, ActiveChat> windows = new Hashtable <String, ActiveChat>();

	/** Referencia a la implementacion del servicio.*/
    private IChatServiceLocalImp service = (IChatServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.CHAT_SERVICE);

	/** Nombre del usuario que ha iniciado la sesion. */
    private String username = DataModel.INSTANCE.getActiveUser();

	/** Contrase�a del usuario que ha iniciado la sesion.*/
	private String password = DataModel.INSTANCE.getActiveUserPass();
	
	/** Se encarga de verificar la llegada de mensajes destinados al usuario y el estado de los contactos. */
    private Thread reader = null;

	/** Dice si el thread reader debe permanecer activo o no. */
    private int activeThread = 1;
    private TaskBarDesktopPane parent = null;

    /** Creates new form MainChat 
	* @param username. Nombre del usuario que inicia la sesion
	* @param password. Contrase�a del usuario que inicia la sesion
	*/
    public MainChat(String username, String password, TaskBarDesktopPane parent) {
        initComponents();
        this.parent = parent;
        this.lblUsername.setText(username);
        refreshContactsStatus();
        this.reader = new Thread (this);
		service.login(username, password);
        reader.start();
        this.setTitle("Chat window");
        this.setLayer(1);
        this.setVisible(true);
        this.setIconifiable(true);
    }

	/** Actualiza las listas de estado de los contactos. */
    public void refreshContactsStatus() {
    	String[] contacts = null;
    	Vector<String> contactsOnline = new Vector<String> ();
    	Vector<String> contactsOffline = new Vector<String> ();
    	contacts = service.getContacts(this.username);
		if (contacts != null) {
			for (int i = 0; i < contacts.length; i++) {
				if (this.service.getStatus(contacts[i]) == 1)
					contactsOnline.add(contacts[i]);
				else
					if (this.service.getStatus(contacts[i]) == 0)
						contactsOffline.add(contacts[i]);
			}
			this.listOnlineUsers.setListData(contactsOnline);
			this.listOfflineUsers.setListData(contactsOffline);
		}
    }

	/** Se encarga de obtener o crear la ventana de chat correspondiente y enviarle el mensaje recibido para que �sta lo muestre */
    private void printMessage (String message, String usernameSrc, String usernameDst) {
        if ((message != null) && (usernameSrc != null) && (usernameDst != null)) {
      		if (!windows.containsKey(usernameSrc)) {
                ActiveChat chat = new ActiveChat(this.username, (String) this.listOnlineUsers.getSelectedValue(), this.parent);
	            windows.put(usernameSrc, chat);
      	    	this.parent.add(chat);
      	    	this.parent.setSelectedFrame(chat);
	            chat.setVisible(true);
	            chat.printMessage(message, usernameSrc, usernameDst);
        	}
        	else {
        		ActiveChat chat = windows.get(usernameSrc);
      	    	this.parent.add(chat);
      	    	this.parent.setSelectedFrame(chat);
        		chat.setVisible(true);
        		chat.printMessage(message, usernameSrc, usernameDst);
        	}
        }
    }

	/** Decodifica un mensaje de texto enviado como una cadena de caracteres.
	* @param messageString. String que representa un mensaje de texto.
	* @return TextMessage. Mensaje de texto formado por los valores de los campos especificados en messageString.
	*/
    private TextMessage getTextMessageFromString(String messageString) {
    	TextMessage textMessage = new TextMessage();
    	char[] texto = messageString.toCharArray();
    	int j = 0;
    	for (int i = 0; i < 3; i++) {
    		String cadena = new String();
    		while (j < texto.length && texto[j] != '|') {
    			cadena += texto[j];
    			j++;
    		}
    		j++;
    		switch (i) {
				case 0: textMessage.setUsernameSrc(cadena); break;
				case 1: textMessage.setUsernameDst(cadena); break;
				case 2: textMessage.setMessage(cadena); break;
    		}
    	}
    	return textMessage;
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsername = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmdAddContact = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOnlineUsers = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listOfflineUsers = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();

        setRequestFocusEnabled(false);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        lblUsername.setFont(new java.awt.Font("Tahoma", 3, 14));
        lblUsername.setText("<username>");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 2, 11));
        jLabel1.setText("Online users");

        cmdAddContact.setText("Add contact");
        cmdAddContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddContactActionPerformed(evt);
            }
        });

        listOnlineUsers.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listOnlineUsers.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        listOnlineUsers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listOnlineUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listOnlineUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listOnlineUsers);

        listOfflineUsers.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listOfflineUsers.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        listOfflineUsers.setForeground(new java.awt.Color(204, 0, 0));
        listOfflineUsers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listOfflineUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listOfflineUsersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listOfflineUsers);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 2, 11));
        jLabel2.setText("Offline users");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                                .addComponent(cmdAddContact))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addComponent(cmdAddContact))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	/** Abre el formulario para agregar un contacto. */
    private void cmdAddContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddContactActionPerformed
    	AddContact ac = new AddContact(this.username,this.parent);
	    this.parent.add(ac);
  	    this.parent.setSelectedFrame(ac);
    	ac.setVisible(true);
    }//GEN-LAST:event_cmdAddContactActionPerformed

	/** Abre una conversacion con el usuario que ha sido seleccionado de la lista de conectados. */
    private void listOnlineUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listOnlineUsersMouseClicked
        if (this.listOnlineUsers.getSelectedValue() != null)
            if (!windows.containsKey(this.listOnlineUsers.getSelectedValue())) {
                ActiveChat chat = new ActiveChat(this.username, (String) this.listOnlineUsers.getSelectedValue(), this.parent);
                windows.put((String) this.listOnlineUsers.getSelectedValue(), chat);
      	    	this.parent.add(chat);
      	    	this.parent.setSelectedFrame(chat);
                chat.setVisible(true);
            } 
			else {
	            ActiveChat chat = windows.get((String) this.listOnlineUsers.getSelectedValue());
                windows.put((String) this.listOnlineUsers.getSelectedValue(), chat);
      	    	this.parent.add(chat);
      	    	this.parent.setSelectedFrame(chat);
	            chat.setVisible(true);
            }
}//GEN-LAST:event_listOnlineUsersMouseClicked

	/** Abre una conversacion con el usuario que ha sido seleccionado de la lista de desconectados. */
    private void listOfflineUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listOfflineUsersMouseClicked
        if (this.listOfflineUsers.getSelectedValue() != null)
            if (!windows.containsKey(this.listOfflineUsers.getSelectedValue())) {
                ActiveChat chat = new ActiveChat(this.username, (String) this.listOnlineUsers.getSelectedValue(), this.parent);
                windows.put((String) this.listOfflineUsers.getSelectedValue(), chat);
      	    	this.parent.add(chat);
      	    	this.parent.setSelectedFrame(chat);
                chat.setVisible(true);
            } 
			else {
	            ActiveChat chat = windows.get((String) this.listOfflineUsers.getSelectedValue());
                windows.put((String) this.listOfflineUsers.getSelectedValue(), chat);
      	    	this.parent.add(chat);
      	    	this.parent.setSelectedFrame(chat);
	            chat.setVisible(true);
            }
}//GEN-LAST:event_listOfflineUsersMouseClicked

	/** Deslogea al usuario actual y mata el thread de lectura de mensajes */
    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        //TODO MIRAME
    	service.logout(username, password);
        this.activeThread = 0;
        reader.notify();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAddContact;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JList listOfflineUsers;
    private javax.swing.JList listOnlineUsers;
    // End of variables declaration//GEN-END:variables

	/** Thread que lee los mensajes destinados al usuario y actualiza la lista de contactos y el estado de los mismos. */
    public void run() {
    	String[] msgs = null;
    	int refresh = 0;
    	while (activeThread == 1) {
    		msgs = this.service.receiveMessage(this.username);
			if (msgs != null) {
				TextMessage message = null;
				for (int i = 0; i < msgs.length; i++) {
					message = this.getTextMessageFromString(msgs[i]);
					this.printMessage(message.getMessage(), message.getUsernameSrc(), message.getUsernameDst());
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { }

			refresh++;
	    	if (refresh == 5) {
	    		refresh = 0;
	    		cleanContacts();
	    		refreshContact();
	    		this.refreshContactsStatus();
	    	}
    	}
    }

	/** Elimina los contactos que posee el usuario en el chat. */
    private void cleanContacts() {
    	String[] contacts = service.getContacts(DataModel.INSTANCE.getActiveUser());
		if(contacts != null){
			for(int i=0;i<contacts.length;i++){
				service.removeContact(DataModel.INSTANCE.getActiveUser(), contacts[i]);
			}
		}
	}

	/** Carga los contactos del usuario pertenecientes a los proyectos a los cuales esta suscripto. */
	private void refreshContact() {
    	IProjectTeamServiceLocalImp project = (IProjectTeamServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.PROJECT_TEAM_SERVICE);
    	String[] projects = project.getProjectsForUser(DataModel.INSTANCE.getActiveUser(), DataModel.INSTANCE.getActiveUserPass());
    	if(projects != null){
    		for(int i=0;i<projects.length;i++){
    			String[] users = project.getUsersForProject(projects[i]);
    			if(users != null){
    				for(int j=0;j<users.length;j++){
    					service.addContact(DataModel.INSTANCE.getActiveUser(), users[j]);
    				}
    			}
    		}
    	}
    }

}
