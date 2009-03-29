package ar.com.cosgui.services;


/**
 * Interface que implementara el adapter de BugTracking para adaptarlo a nuestra aplicacion
 * @author Joaquin Alejandro Perez Fuentes
 */
public interface IMailServiceLocalImp extends IServiceLocalImp{

	public int sendMail(String username, String password, String to, String subject, String text);
	public int validUser(String username, String password);
	public int validUserName(String user);
	public java.lang.String[] getMails(String username, String password);
	public int saveMail(String username, String password, String from, String subject, String text, String status);
	public int deleteMail(String username, String password, String from, String subject, String text, String status);
		
}
