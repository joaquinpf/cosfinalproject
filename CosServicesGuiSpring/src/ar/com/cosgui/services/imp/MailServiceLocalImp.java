package ar.com.cosgui.services.imp;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ar.com.cosgui.services.IServiceLocalImp;
import wsmail.Auth;
import wsmail.Mail;

public class MailServiceLocalImp implements IServiceLocalImp {
	private MailIF service = null;

	public MailIF getService() {
		return service;
	}

	public void setService(MailIF service) {
		this.service = service;
	}

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
				return toStringArray(service.getMails (new Auth(username, password)));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	  
	@SuppressWarnings("unchecked")
	private String[] toStringArray(Object array) {
		if(array instanceof String){
			String[] ret = new String[1];
			ret[0] = (String) array; 
			return ret;
		} else if(array instanceof ArrayList){
			if(array!=null)	{
				String[] retStringuized = new String[((ArrayList<String>) array).size()];
				return ((ArrayList<String>) array).toArray(retStringuized);
			}
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
