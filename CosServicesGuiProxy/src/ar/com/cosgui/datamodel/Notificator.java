package ar.com.cosgui.datamodel;

import ar.com.cosgui.services.IMailServiceLocalImp;
import ar.com.cosgui.services.IProjectTeamServiceLocalImp;
import ar.com.cosgui.services.ServicePoint;
import ar.com.cosgui.services.ServicesConstants;
import ar.com.cosgui.services.imp.MailServiceLocalImp;
import ar.com.cosgui.services.imp.ProjectTeamServiceLocalImp;

public class Notificator {
    public static void notifyNewBug(Bug b) {
    	IProjectTeamServiceLocalImp proj = (IProjectTeamServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.PROJECT_TEAM_SERVICE);
    	String[] users = proj.getUsersForProject(b.getProject());
    	if(users != null){
    		IMailServiceLocalImp mail = (IMailServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.MAIL_SERVICE);
    		String text = "The bug number " + b.getNumber() + " was added to the system by " + b.getOwner() + ". \nDetails follow:\n" +
    				"Number: " + b.getNumber() + "\nType: " + b.getType()  + "\nProject: " + b.getProject()+ "\nDescription: " + b.getDescription() + 
    				"\nOwner: " + b.getOwner();
    		String subject = "<NEW BUG> New bug #" + b.getNumber() + " added to " + b.getProject();
    		for(int i=0;i<users.length;i++){
    			mail.sendMail(DataModel.INSTANCE.getActiveUser(),DataModel.INSTANCE.getActiveUserPass(),users[i],
    					subject,text);		
    		}
    	}
    }
    public static void notifyStatusChange(Bug b, String oldstatus) {
    	IProjectTeamServiceLocalImp proj = (IProjectTeamServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.PROJECT_TEAM_SERVICE);
    	String[] users = proj.getUsersForProject(b.getProject());
    	if(users != null){
    		IMailServiceLocalImp mail = (IMailServiceLocalImp) ServicePoint.INSTANCE.getService(ServicesConstants.MAIL_SERVICE);
    		String text = "The bug number " + b.getNumber() + " changed status from: " + oldstatus + ", to: " + b.getStatus();
    		String subject = "<STATUS UPDATE> Bug #" + b.getNumber() + " changed status";
    		for(int i=0;i<users.length;i++){
    			mail.sendMail(DataModel.INSTANCE.getActiveUser(),DataModel.INSTANCE.getActiveUserPass(),users[i],
    					subject,text);		
    		}
    	}
    }
}
