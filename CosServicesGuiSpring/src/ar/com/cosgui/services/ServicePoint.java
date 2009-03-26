package ar.com.cosgui.services;
import java.util.HashMap;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import ar.com.cosgui.services.imp.BugTrackerServiceLocalImp;
import ar.com.cosgui.services.imp.ChatServiceLocalImp;
import ar.com.cosgui.services.imp.MailServiceLocalImp;
import ar.com.cosgui.services.imp.ProjectTeamServiceLocalImp;


/**
 * Punto de acceso comun a los servicios. Singleton.
 * Se encarga de la construccion de todos los servicios.
 * @author Joaquin Alejandro Perez Fuentes
 */
public class ServicePoint {
	private HashMap<String, IServiceLocalImp> services = new HashMap<String, IServiceLocalImp>();
	public static ServicePoint INSTANCE = new ServicePoint();
	
	/**
	 * Construye los servicios a utilizar
	 */
	protected ServicePoint(){
				
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/ar/com/cosgui/services/imp/BugTrackerService.xml");
        BugTrackerServiceLocalImp bugtracker = (ar.com.cosgui.services.imp.BugTrackerServiceLocalImp) ctx.getBean("app");
        services.put(ServicesConstants.BUG_TRACKING_SERVICE, bugtracker);

        ctx = new FileSystemXmlApplicationContext("src/ar/com/cosgui/services/imp/ProjectTeamService.xml");
        ProjectTeamServiceLocalImp projectteam = (ar.com.cosgui.services.imp.ProjectTeamServiceLocalImp) ctx.getBean("app");
        services.put(ServicesConstants.PROJECT_TEAM_SERVICE, projectteam);

        ctx = new FileSystemXmlApplicationContext("src/ar/com/cosgui/services/imp/ChatService.xml");
        ChatServiceLocalImp chat = (ar.com.cosgui.services.imp.ChatServiceLocalImp) ctx.getBean("app");
        services.put(ServicesConstants.CHAT_SERVICE, chat);

        ctx = new FileSystemXmlApplicationContext("src/ar/com/cosgui/services/imp/MailService.xml");
        MailServiceLocalImp mail = (ar.com.cosgui.services.imp.MailServiceLocalImp) ctx.getBean("app");
        services.put(ServicesConstants.MAIL_SERVICE, mail);
	}
	
	/**
	 * Obtiene de manera generica un servicio por su nombre.
	 * @param service
	 * @return
	 */
	public IServiceLocalImp getService(String service){
		return services.get(service);
	}
}
