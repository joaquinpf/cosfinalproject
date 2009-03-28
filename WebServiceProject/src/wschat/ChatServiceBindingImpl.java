/**
 * ChatServiceBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wschat;

import javax.xml.crypto.Data;

public class ChatServiceBindingImpl implements wschat.ChatService{
    public int login(wschat.Auth user) throws java.rmi.RemoteException {
        return DataBase.login(user);
    }

    public int logout(wschat.Auth user) throws java.rmi.RemoteException {
        return DataBase.logout(user);
    }

    public int sendMessage(wschat.TextMessage textMessage) throws java.rmi.RemoteException {
        return DataBase.sendMessage(textMessage);
    }

    public java.lang.String[] getContacts(java.lang.String username) throws java.rmi.RemoteException {
        return DataBase.getContacts(username);
    }

    public int addContact(java.lang.String username, java.lang.String contact) throws java.rmi.RemoteException {
        return DataBase.addContact(username, contact);
    }

    public int removeContact(java.lang.String username, java.lang.String contact) throws java.rmi.RemoteException {
        return DataBase.removeContact(username, contact);
    }

    public java.lang.String[] receiveMessage(java.lang.String username) throws java.rmi.RemoteException {
        return DataBase.receiveMessage(username);
    }

    public int getStatus(java.lang.String username) throws java.rmi.RemoteException {
        return DataBase.getStatus(username);
    }

    public int existUserName(java.lang.String username) throws java.rmi.RemoteException {
        return DataBase.existUserName(username);
    }

    public int addUser(wschat.Auth user) throws java.rmi.RemoteException {
        return DataBase.addUser(user);
    }

}
