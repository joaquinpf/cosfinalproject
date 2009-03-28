package wschat;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

/**
*@Author Marcos Steimbach.
*Esta clase es la encargada de mantener los datos en el servidor. En esta se encuentran
* tres hashtables en las cuales se encuentran los mensajes, los contactos y los usuarios con su estado.
*/
public class DataBase{
	/** Contiene un vector de mensajes para cada usuario del sistema. */
	private static Hashtable<String, Vector<String>> messages = new Hashtable <String, Vector<String>>();

	/** Contiene los usuarios del sistema y su estado (1: online u 2: offline) */
	private static Hashtable<wschat.Auth, Integer> users = new Hashtable<wschat.Auth, Integer>();

	/** Contiene un vector de contactos para cada usuario del sistema. */
	private static Hashtable<String, Vector<String>> contacts = new Hashtable <String, Vector<String>>();

	/**
	* Actualiza el estado de un usuario a "online" (1).
	* @param user. Nombre de usuario y contraseña perteneciente a un sujeto.
	* @return int.0 si el usuario es invalido, de lo contrario 1.
	*/
    public static int login(wschat.Auth user) {
    	Integer status = new Integer(1);
    	if (validUser(user) == 1) {
    		users.remove(user);
    		users.put(user, status);
    		return 1;
    	}
    	return 0;
    }

	/** 
	* Dice si un usuario y contraseñas son validas o no.
	* @param user. Nombre de usuario y contraseñas correspondientes a un sujeto.
	* @return int. 0 si el usuario es invalido y 1 si es valido.
	*/
	private static int validUser(wschat.Auth user){
		if (users.containsKey(user))
			return 1;
		return 0;
	}
	
	/**
	* Actualiza el estado del usuario a "offline" (0).
	* @param user. Nombre de usuario y contraseña perteneciente a un sujeto.
	* @return int.0 si el usuario es invalido, de lo contrario 1.
	*/
    public static int logout(wschat.Auth user) {
    	Integer status = new Integer(0);
    	if (validUser(user) == 1) {
    		users.remove(user);
    		users.put(user, status);
    		return 1;
    	}
    	return 0;
    }

	/** 
	* Envia un mensaje a un usuario agregandolo en la entrada correspondiente de la hashtable.
	* @param textMessage. Mensaje enviado al usuario.
	* @return int. 0 si no se encontro el destinatario y 1 si la operacion se completo con exito.
	*/
    public static int sendMessage(wschat.TextMessage textMessage) {
    	Vector<String> actualMessages = messages.get(textMessage.getUsernameDst());
    	if (actualMessages != null) {
    		actualMessages.add(textMessage.toString());
    		return 1;
    	}
    	return 0;
    }

	/**
	* Obtiene los contactos pertenecientes a un usuario.
	* @param username. Nombre del usuario que realiza el pedido.
	* @return String[]. Array de strings conteniendo en cada posicion el nombre de usuario del contacto.
	*/
    public static java.lang.String[] getContacts(String username) throws java.rmi.RemoteException {
		Vector<String> listContacts = contacts.get(username);
		String[] contactsReturned; 
		if (listContacts != null) {
			contactsReturned = new String[listContacts.size()];
			int i = 0;
			for(Iterator<String> it = listContacts.iterator(); it.hasNext(); i++)
				contactsReturned[i] = it.next();
			return contactsReturned;
		}
		else
			return null;
    }

	/**
	* Agrega un contacto a la lista de contactos de un usuario.
	* @param username. nombre de usuario del que solicita la operacion.
	* @param contact. Nombre de usuario del contacto que se quiere agregar.
	* @return int. 0 si el contacto no existe, de lo contrario 1.
	*/
    public static int addContact(java.lang.String username, java.lang.String contact) throws java.rmi.RemoteException {
        if (existUserName(contact) == 1) {
        	contacts.get(username).add(contact);
        	return 1;
        }
    	return 0;
    }

	/**
	* Retorna los mensajes que han llegado para el usuario.
	* @param username. Nombre del usuario que solicita la operacion.
	* @return String[]. Array de strings conteniendo en cada posicion la representacion de un mensaje.
	*/
    public static java.lang.String[] receiveMessage(java.lang.String username) throws java.rmi.RemoteException {
		Vector<String> listMessages = messages.get(username);
		String[] messagesReturned; 
		if (listMessages != null) {
			messagesReturned = new String[listMessages.size()];
			int i = 0;
			for(Iterator<String> it = listMessages.iterator(); it.hasNext(); i++)
				messagesReturned[i] = it.next();
			messages.get(username).clear();
			return messagesReturned;
		}
		else
			return null;
    }

	/**
	* Obtiene el estado de un usuario (online u offline).
	* @param username. Nombre del usuario que se quiere conocer el estado.
	* @return int. -1 si no se encuentra el usuario, 0 si esta offline y 1 si el estado del mismo es online.
	*/
    public static int getStatus(java.lang.String username) throws java.rmi.RemoteException {
		wschat.Auth user;
		for (Enumeration<wschat.Auth> e = users.keys(); e.hasMoreElements();) {
			user = e.nextElement();
			if (user.getUsername().equals(username))
				return users.get(user);
		}
		return -1;
    }

	/**
	* Dice si un nombre de usuario existe o no en la lista de usuarios del sistema.
	* @parameter userName. Nombre de usuario que se quiere verificar.
	* @return int. 0 si el nombre de usuario no existe, de lo contrario 1.
	*/
    public static int existUserName(java.lang.String username) {
		wschat.Auth user;
		for (Enumeration<wschat.Auth> e = users.keys(); e.hasMoreElements();) {
			user = e.nextElement();
			if (user.getUsername().equals(username))
				return 1;
		}
		return 0;
    }

	/**
	* Agrega un usuario a la lista de usuarios de chat.
	* @param user. Nombre de usuario y contraseñas pertenecientes a un sujeto.
	* @return int. 0 si el nombre de usuario ya existe y 1 si la operacion se pudo completar con exito.
	*/
    public static int addUser(wschat.Auth user) throws java.rmi.RemoteException {
        if (existUserName(user.getUsername()) == 0) {
        	users.put(user, new Integer(0));
        	messages.put(user.getUsername(), new Vector<String> ());
        	contacts.put(user.getUsername(), new Vector<String> ());
        	return 1;
        }
        return 0;
    }
}
