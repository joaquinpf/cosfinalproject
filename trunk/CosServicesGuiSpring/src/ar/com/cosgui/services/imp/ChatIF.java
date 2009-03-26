/**
 * ChatService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.cosgui.services.imp;

public interface ChatIF extends java.rmi.Remote {
    public int login(wschat.Auth user) throws java.rmi.RemoteException;
    public int logout(wschat.Auth user) throws java.rmi.RemoteException;
    public int sendMessage(wschat.TextMessage textMessage) throws java.rmi.RemoteException;
    public Object getContacts(java.lang.String username) throws java.rmi.RemoteException;
    public int addContact(java.lang.String username, java.lang.String contact) throws java.rmi.RemoteException;
    public Object receiveMessage(java.lang.String username) throws java.rmi.RemoteException;
    public int getStatus(java.lang.String username) throws java.rmi.RemoteException;
    public int existUserName(java.lang.String username) throws java.rmi.RemoteException;
    public int addUser(wschat.Auth user) throws java.rmi.RemoteException;
}
