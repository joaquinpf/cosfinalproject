package ar.com.cosgui.services.imp;

import java.rmi.RemoteException;

import ar.com.cosgui.services.IServiceLocalImp;
import wsmail.MailServiceProxy;
import wsmail.Auth;
import wsmail.Mail;

/**
*@Author Marcos Steimbach.
*Esta clase es la encargada de abstraer a la aplicacion de la implementacion en si del servicio de mail.
*/
public class MailServiceLocalImp implements IServiceLocalImp {
	/** Conexion al servicio de mail */
	private MailServiceProxy service = new MailServiceProxy();

	@Override
	public void connect() {

	}
	
	/**
	* Agrega un usuario a la lista de usuarios de mails.
	* @param user. Nombre de usuario del sujeto.
	* @param pass. Contraseña del sujeto.
	* @return int. 0 si el nombre de usuario ya existe y 1 si la operacion se pudo completar con exito.
	*/
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
	
	/** 
	* Envia un mail a un usuario agregandolo en la entrada correspondiente de la hashtable.
	* @param username. Nombre de usuario del sujeto.
	* @param password. Contraseña del sujeto.
	* @param to. A quien va dirigido el mensaje.
	* @param subject. Asunto del mensaje.
	* @param text. Texto del mensaje.
	* @return int. -2 si el mail es nulo, -1 si es un usuario invalido, 0 si no se encontro el destinatario y 1 si la operacion se completo con exito.
	*/
	public int sendMail(String username, String password, String to, String subject, String text) {
        Mail mail = new Mail(username, to, subject, text, "new");
        try {
			if (this.validUser(username, password) == 1)
				return service.sendMail(new Auth(username, password), mail);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	 
	/** 
	* Dice si un usuario y contraseñas son validas o no.
	* @param username. Nombre de usuario del sujeto.
	* @param password. Contraseña del sujeto.
	* @return int. 0 si el usuario es invalido y 1 si es valido.
	*/
	public int validUser(String username, String password){
        try {
			return service.validUser(new Auth (username, password));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	* Dice si un nombre de usuario existe o no en la lista de usuarios del sistema.
	* @parameter user. Nombre de usuario que se quiere verificar.
	* @return int. 0 si el nombre de usuario no existe, de lo contrario 1.
	*/
	public int validUserName(String user) throws java.rmi.RemoteException{
		try {
			return service.validUserName (user);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/** 
	* Si el usuario es válido retorna un vector de strings representando todos los mails que pertenecen al usuario.
	* @param username. Nombre de usuario del sujeto.
	* @param password. Contraseña del sujeto.
	* @return String[]. Array de strings conteniendo cada posicion una representacion de mail.
	*/
	public java.lang.String[] getMails(String username, String password){
		try {
			if (this.validUser(username, password) == 1)
				return service.getMails (new Auth(username, password));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	  
	/** 
	* Modifica el estado del mail a "saved" para almacenarlo como guardado.
	* @param username. Nombre de usuario del sujeto.
	* @param password. Contraseña del sujeto.
	* @param from. Emisor del mensaje.
	* @param subject. Asunto del mensaje.
	* @param text. Texto del mensaje.
	* @param status. Estado del mensaje.
	* @return int. -1 si es un usuario invalido, 0 si no se encontro el mail y 1 si la operacion se completo con exito.
	*/  
	public int saveMail(String username, String password, String from, String subject, String text, String status){
		try {
			if (this.validUser (username, password) == 1)
				return service.saveMail (new Auth(username, password), new Mail (from, username, subject, text, status));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	/** 
	* Elimina un mail de la lista perteneciente al usuario.
	* @param username. Nombre de usuario del sujeto.
	* @param password. Contraseña del sujeto.
	* @param from. Emisor del mensaje.
	* @param subject. Asunto del mensaje.
	* @param text. Texto del mensaje.
	* @param status. Estado del mensaje.
	* @return int. -1 si es un usuario invalido, 0 si no se encontro el mail y 1 si la operacion se completo con exito.
	*/  
	public int deleteMail(String username, String password, String from, String subject, String text, String status){
		try {
			if (this.validUser (username, password) == 1)
				return service.deleteMail (new Auth(username, password), new Mail (from, username, subject, text, status));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
		
}
