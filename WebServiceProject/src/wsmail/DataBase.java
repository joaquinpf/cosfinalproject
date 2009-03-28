package wsmail;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

/**
*@Author Marcos Steimbach.
*Esta clase es la encargada de mantener los datos en el servidor. En esta se encuentran
* un vector, en el cual se almacenan todos los usuarios con sus respectivas contraseñas, y
* una hashtable en la cual se encuentran todos los mails pertenecientes a cada usuario.
*/
public class DataBase{
	/** Contiene todos los mails correspondientes a cada usuario. */
	private static Hashtable<String, Vector<wsmail.Mail>> mails = new Hashtable <String, Vector<wsmail.Mail>>();

	/** Contiene todos los usuarios y sus contraseñas. */
	private static Vector<wsmail.Auth> users = new Vector<wsmail.Auth>();
	
	/** 
	* Si el usuario es válido retorna un vector de strings representando todos los mails que pertenecen al usuario.
	* @param user. Nombre de usuario y contraseña del sujeto.
	* @return String[]. Array de strings conteniendo cada posicion una representacion de mail.
	*/
	public static String[] getMails(wsmail.Auth user){
		Vector<wsmail.Mail> userMails;
		String[] mailsReturned; 
		if (validUser(user) == 1){
			userMails = mails.get(user.getUsername());
			mailsReturned = new String[userMails.size()];
			int i = 0;
			for(Iterator<wsmail.Mail> it = userMails.iterator(); it.hasNext(); i++)
				mailsReturned[i] = it.next().toString();
			return mailsReturned;
		}
		else
			return null;
	}
	
	/** 
	* Modifica el estado del mail a "saved" para almacenarlo como guardado.
	* @param user. Nombre de usuario y contraseña para autentificar el mismo.
	* @param mail. Mail al cual se le debera cambiar el estado.
	* @return int. -1 si es un usuario invalido, 0 si no se encontro el mail y 1 si la operacion se completo con exito.
	*/
	public static int saveMail(wsmail.Auth user, wsmail.Mail mail){
		int valid = 0;
		wsmail.Mail actualMail = null;
		if (validUser(user) == 1){
			for(Iterator<wsmail.Mail> it = mails.get(user.getUsername()).iterator(); (it.hasNext()) && (valid == 0);)
				actualMail = it.next();
			if (mail.equals(actualMail)){
				valid = 1;
				actualMail.setStatus("saved");
			}
			return valid;
		}
		return -1;
	}

	/** 
	* Elimina un mail de la lista perteneciente al usuario.
	* @param user. Nombre de usuario y contraseña para autentificar el mismo.
	* @param mail. Mail que debera ser borrado de la lista del usuario.
	* @return int. -1 si es un usuario invalido, 0 si no se encontro el mail y 1 si la operacion se completo con exito.
	*/
	public static int deleteMail(wsmail.Auth user, wsmail.Mail mail){
		int valid = 0;
		wsmail.Mail actualMail = null;
		if (validUser(user) == 1){
			Iterator<wsmail.Mail> it;
			for(it = mails.get(user.getUsername()).iterator(); (it.hasNext()) && (valid == 0);)
				actualMail = it.next();
				if (mail.equals(actualMail)){
					valid = 1;
					it.remove();
				}
			return valid;
		}
		return -1;
	}
	
	/** 
	* Envia un mail a un usuario agregandolo en la entrada correspondiente de la hashtable.
	* @param user. Nombre de usuario y contraseña para autentificar el mismo.
	* @param mail. Mail que debera ser enviado al usuario.
	* @return int. -2 si el mail es nulo, -1 si es un usuario invalido, 0 si no se encontro el destinatario y 1 si la operacion se completo con exito.
	*/
	public static int sendMail(wsmail.Auth user, wsmail.Mail mail){
		int complete = -1;
		if (validUser(user) == 1)
			if (mail != null){
				if (mails.containsKey(mail.getTo())){
					mails.get(mail.getTo()).add(mail);
					complete = 1;
				}
				else
					complete = 0;
			}
			else
				complete = -2;
		return complete;
	}
	
	/** 
	* Dice si un usuario y contraseñas son validas o no.
	* @param user. Nombre de usuario y contraseñas correspondientes a un sujeto.
	* @return int. 0 si el usuario es invalido y 1 si es valido.
	*/
	public static int validUser(wsmail.Auth user){
		int valid = 0;
		if (user != null){
			for(Iterator<wsmail.Auth> it = users.iterator(); (it.hasNext()) && (valid == 0);)
				if (user.equals(it.next()))
					valid = 1;
		}
		return valid;
	}

	/**
	* Agrega un usuario a la lista de usuarios de mails.
	* @param user. Nombre de usuario y contraseñas pertenecientes a un sujeto.
	* @return int. 0 si el nombre de usuario ya existe y 1 si la operacion se pudo completar con exito.
	*/
	public static int addUserMail(wsmail.Auth user) {
		int valid = 0;
		if (validUserName(user.getUsername()) == 0) {
			users.add(user);
			mails.put(user.getUsername(), new Vector<wsmail.Mail>());
			valid = 1;
		}
		return valid;
}
	
	/**
	* Dice si un nombre de usuario existe o no en la lista de usuarios del sistema.
	* @parameter userName. Nombre de usuario que se quiere verificar.
	* @return int. 0 si el nombre de usuario no existe, de lo contrario 1.
	*/
	public static int validUserName(String userName){
		int valid = 0;
		if (userName != null){
			for(Iterator<wsmail.Auth> it = users.iterator(); (it.hasNext()) && (valid == 0);)
				if (userName.equals(it.next().getUsername()))
					valid = 1;
		}
		return valid;
	}
}
