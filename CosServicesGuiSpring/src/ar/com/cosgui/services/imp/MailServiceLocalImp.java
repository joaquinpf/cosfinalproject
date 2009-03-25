package ar.com.cosgui.services.imp;

import java.rmi.RemoteException;

import ar.com.cosgui.services.IServiceLocalImp;
import wsmail.MailServiceProxy;
import wsmail.Auth;
import wsmail.Mail;

public class MailServiceLocalImp implements IServiceLocalImp {
	private MailServiceProxy service = new MailServiceProxy();

	@Override
	public void connect() {

	}

	@Override
	public int addUser(String user, String pass) {
    	try {
			if (this.validUserName(user) == 0)
				return service.addUserMail(new Auth(user, pass));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int sendMail(String username, String password, String to, String subject, String text) throws java.rmi.RemoteException{
        Mail mail = new Mail(username, to, subject, text, "new");
        try {
			if (this.validUser(username, password) == 1)
				return service.sendMail(new Auth(username, password), mail);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	 
	public int validUser(String username, String password) throws java.rmi.RemoteException{
        try {
			return service.validUser(new Auth (username, password));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	public int validUserName(String user) throws java.rmi.RemoteException{
		try {
			return service.validUserName (user);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	public java.lang.String[] getMails(String username, String password) throws java.rmi.RemoteException{
		try {
			if (this.validUser(username, password) == 1)
				return service.getMails (new Auth(username, password));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	  
	public int saveMail(String username, String password, String from, String subject, String text, String status) throws java.rmi.RemoteException{
		try {
			if (this.validUser (username, password) == 1)
				return service.saveMail (new Auth(username, password), new Mail (from, username, subject, text, status));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	public int deleteMail(String username, String password, String from, String subject, String text, String status) throws java.rmi.RemoteException{
		try {
			if (this.validUser (username, password) == 1)
				return service.deleteMail (new Auth(username, password), new Mail (from, username, subject, text, status));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
		
}
