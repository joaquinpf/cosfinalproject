package wsmail;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;


public class DataBase{
	private static Hashtable<String, Vector<wsmail.Mail>> mails = new Hashtable <String, Vector<wsmail.Mail>>();
	private static Vector<wsmail.Auth> users = new Vector<wsmail.Auth>();
	
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
	
	public static int validUser(wsmail.Auth user){
		int valid = 0;
		if (user != null){
			for(Iterator<wsmail.Auth> it = users.iterator(); (it.hasNext()) && (valid == 0);)
				if (user.equals(it.next()))
					valid = 1;
		}
		return valid;
	}

	public static int addUserMail(wsmail.Auth user) {
		int valid = 0;
		if (validUserName(user.getUsername()) == 0) {
			users.add(user);
			mails.put(user.getUsername(), new Vector<wsmail.Mail>());
			valid = 1;
		}
		return valid;
}
	
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
