package ar.com.cosgui.services.imp;

import java.rmi.RemoteException;

import ar.com.cosgui.services.IChatServiceLocalImp;
import wschat.Auth;
import wschat.ChatServiceProxy;
import wschat.TextMessage;

/**
*@Author Marcos Steimbach.
*Esta clase es la encargada de abstraer a la aplicacion de la implementacion en si del servicio de chat.
*/
public class ChatServiceLocalImp implements IChatServiceLocalImp {
	/** Conexion al servicio de chat. */
	private ChatServiceProxy service = new ChatServiceProxy();

	@Override
	public void connect() {

	}

	
	/**
	* Agrega un usuario a la lista de usuarios de chat.
	* @param user. Nombre de usuario del sujeto.
	* @param pass. Contraseña del sujeto.
	* @return int. 0 si el nombre de usuario ya existe y 1 si la operacion se pudo completar con exito.
	*/
	@Override
	public int addUser(String user, String pass) {
    	try {
			if (this.existUserName(user) == 0)
				return service.addUser(new Auth(user, pass));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	* Actualiza el estado de un usuario a "online" (1).
	* @param user. Nombre de usuario del sujeto.
	* @param pass. Contraseña del sujeto.
	* @return int.0 si el usuario es invalido, de lo contrario 1.
	*/
	public int login(String user, String pass) {
    	try {
			return service.login (new Auth(user, pass));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	/**
	* Actualiza el estado del usuario a "offline" (0).
	* @param user. Nombre de usuario del sujeto.
	* @param pass. Contraseña del sujeto.
	* @return int.0 si el usuario es invalido, de lo contrario 1.
	*/
	public int logout(String user, String pass) {
    	try {
			return service.logout (new Auth(user, pass));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	/** 
	* Envia un mensaje a un usuario agregandolo en la entrada correspondiente de la hashtable.
	* @param message. Mensaje de texto a enviar a un usuario.
	* @param usernameSrc. Usuario que envia el mensaje.
	* @param usernameDst. Usuario al cual va dirigido el mensaje.
	* @return int. 0 si no se encontro el destinatario y 1 si la operacion se completo con exito.
	*/
	public int sendMessage(String message, String usernameSrc, String usernameDst) {
    	try {
			return service.sendMessage (new TextMessage(message, usernameSrc, usernameDst));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	/**
	* Obtiene los contactos pertenecientes a un usuario.
	* @param username. Nombre del usuario que realiza el pedido.
	* @return String[]. Array de strings conteniendo en cada posicion el nombre de usuario del contacto.
	*/
	public java.lang.String[] getContacts(String username) {
    	try {
			return service.getContacts (username);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	  
	/**
	* Agrega un contacto a la lista de contactos de un usuario.
	* @param username. nombre de usuario del que solicita la operacion.
	* @param contact. Nombre de usuario del contacto que se quiere agregar.
	* @return int. 0 si el contacto no existe, de lo contrario 1.
	*/
	public int addContact(String username, String contact) {
    	try {
			if (!username.equals(contact))
				return service.addContact (username, contact);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	/**
	* Retorna los mensajes que han llegado para el usuario.
	* @param username. Nombre del usuario que solicita la operacion.
	* @return String[]. Array de strings conteniendo en cada posicion la representacion de un mensaje.
	*/
	public java.lang.String[] receiveMessage(String username) {
    	try {
			return service.receiveMessage (username);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	  
	/**
	* Obtiene el estado de un usuario (online u offline).
	* @param username. Nombre del usuario que se quiere conocer el estado.
	* @return int. -1 si no se encuentra el usuario, 0 si esta offline y 1 si el estado del mismo es online.
	*/
	public int getStatus(String username) {
    	try {
			return service.getStatus (username);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	/**
	* Dice si un nombre de usuario existe o no en la lista de usuarios del sistema.
	* @parameter userName. Nombre de usuario que se quiere verificar.
	* @return int. 0 si el nombre de usuario no existe, de lo contrario 1.
	*/
	public int existUserName(String username) {
    	try {
			return service.existUserName (username);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int removeContact(String username, String contact){
    	try {
			return service.removeContact(username, contact);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
}
