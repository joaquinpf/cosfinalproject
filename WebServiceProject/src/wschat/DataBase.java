package wschat;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class DataBase{
	private static Hashtable<String, Vector<String>> messages = new Hashtable <String, Vector<String>>();
	private static Hashtable<wschat.Auth, Integer> users = new Hashtable<wschat.Auth, Integer>();
	private static Hashtable<String, Vector<String>> contacts = new Hashtable <String, Vector<String>>();

    public static int login(wschat.Auth user) {
    	Integer status = new Integer(1);
    	if (validUser(user) == 1) {
    		users.remove(user);
    		users.put(user, status);
    		return 1;
    	}
    	return 0;
    }

	private static int validUser(wschat.Auth user){
		if (users.containsKey(user))
			return 1;
		return 0;
	}
	
    public static int logout(wschat.Auth user) {
    	Integer status = new Integer(0);
    	if (validUser(user) == 1) {
    		users.remove(user);
    		users.put(user, status);
    		return 1;
    	}
    	return 0;
    }

    public static int sendMessage(wschat.TextMessage textMessage) {
    	Vector<String> actualMessages = messages.get(textMessage.getUsernameDst());
    	if (actualMessages != null) {
    		actualMessages.add(textMessage.toString());
    		return 1;
    	}
    	return 0;
    }

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

    public static int addContact(java.lang.String username, java.lang.String contact) throws java.rmi.RemoteException {
        if (existUserName(contact) == 1) {
        	contacts.get(username).add(contact);
        	return 1;
        }
    	return 0;
    }

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

    public static int getStatus(java.lang.String username) throws java.rmi.RemoteException {
		wschat.Auth user;
		for (Enumeration<wschat.Auth> e = users.keys(); e.hasMoreElements();) {
			user = e.nextElement();
			if (user.getUsername().equals(username))
				return users.get(user);
		}
		return -1;
    }

    public static int existUserName(java.lang.String username) {
		wschat.Auth user;
		for (Enumeration<wschat.Auth> e = users.keys(); e.hasMoreElements();) {
			user = e.nextElement();
			if (user.getUsername().equals(username))
				return 1;
		}
		return 0;
    }

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
