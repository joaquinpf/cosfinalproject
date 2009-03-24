package ar.com.cosgui.services;
import java.util.HashMap;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import wsbugtracker.springclient.BugTrackerClient;

import ar.com.cosgui.services.imp.BugTrackerServiceLocalImp;
import ar.com.cosgui.services.imp.ChatServiceLocalImp;
import ar.com.cosgui.services.imp.MailServiceLocalImp;
import ar.com.cosgui.services.imp.ProjectTeamServiceLocalImp;



public class ServicePoint {
	private HashMap<String, IServiceLocalImp> services = new HashMap<String, IServiceLocalImp>();
	public static ServicePoint INSTANCE = new ServicePoint();
	
	protected ServicePoint(){
		

		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/ar/com/cosgui/services/imp/BugTrackerService.xml");
		BugTrackerServiceLocalImp bugtracker = (ar.com.cosgui.services.imp.BugTrackerServiceLocalImp) ctx.getBean("app");
		
		services.put(ServicesConstants.BUG_TRACKING_SERVICE, bugtracker);

		ctx = new FileSystemXmlApplicationContext("src/ar/com/cosgui/services/imp/ProjectTeamService.xml");
		ProjectTeamServiceLocalImp projectteam = (ar.com.cosgui.services.imp.ProjectTeamServiceLocalImp) ctx.getBean("app");
		
		services.put(ServicesConstants.PROJECT_TEAM_SERVICE, projectteam);
		services.put(ServicesConstants.CHAT_SERVICE, new ChatServiceLocalImp());
		services.put(ServicesConstants.MAIL_SERVICE, new MailServiceLocalImp());
	}
	
	public IServiceLocalImp getService(String service){
		return services.get(service);
	}
}
