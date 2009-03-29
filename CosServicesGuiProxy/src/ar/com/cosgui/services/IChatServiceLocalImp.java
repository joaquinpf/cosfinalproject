package ar.com.cosgui.services;


/**
 * Interface que implementara el adapter de ChatService para adaptarlo a nuestra aplicacion
 * @author Joaquin Alejandro Perez Fuentes
 */
public interface IChatServiceLocalImp extends IServiceLocalImp{

	public int login(String user, String pass);
	public int logout(String user, String pass);
	public int sendMessage(String message, String usernameSrc, String usernameDst);
	public java.lang.String[] getContacts(String username);
	public int addContact(String username, String contact);
	public java.lang.String[] receiveMessage(String username);
	public int getStatus(String username);
	public int existUserName(String username);
	public int removeContact(String username, String contact);
	
}
