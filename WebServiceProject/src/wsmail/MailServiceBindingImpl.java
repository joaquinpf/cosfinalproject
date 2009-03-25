/**
 * MailServiceBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsmail;

public class MailServiceBindingImpl implements wsmail.MailService{
    public int sendMail(wsmail.Auth user, wsmail.Mail mail) throws java.rmi.RemoteException {
        return DataBase.sendMail(user, mail);
    }

    public int validUser(wsmail.Auth user) throws java.rmi.RemoteException {
    	return DataBase.validUser(user);
    }

    public int validUserName(java.lang.String user) throws java.rmi.RemoteException {
        return DataBase.validUserName(user);
    }

    public java.lang.String[] getMails(wsmail.Auth user) throws java.rmi.RemoteException {
        return DataBase.getMails(user);
    }

    public int saveMail(wsmail.Auth user, wsmail.Mail mail) throws java.rmi.RemoteException {
        return DataBase.saveMail(user, mail);
    }

    public int deleteMail(wsmail.Auth user, wsmail.Mail mail) throws java.rmi.RemoteException {
        return DataBase.deleteMail(user, mail);
    }

    public int addUserMail(wsmail.Auth user) throws java.rmi.RemoteException {
        return DataBase.addUserMail(user);
    }

}
