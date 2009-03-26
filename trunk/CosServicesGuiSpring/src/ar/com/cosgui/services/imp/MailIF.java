/**
 * MailService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.cosgui.services.imp;

public interface MailIF extends java.rmi.Remote {
    public int sendMail(wsmail.Auth user, wsmail.Mail mail) throws java.rmi.RemoteException;
    public int validUser(wsmail.Auth user) throws java.rmi.RemoteException;
    public int validUserName(java.lang.String user) throws java.rmi.RemoteException;
    public Object getMails(wsmail.Auth user) throws java.rmi.RemoteException;
    public int saveMail(wsmail.Auth user, wsmail.Mail mail) throws java.rmi.RemoteException;
    public int deleteMail(wsmail.Auth user, wsmail.Mail mail) throws java.rmi.RemoteException;
    public int addUserMail(wsmail.Auth user) throws java.rmi.RemoteException;
}
