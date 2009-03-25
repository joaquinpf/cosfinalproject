package ar.com.cosgui.services;
import java.util.HashMap;

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
				
		services.put(ServicesConstants.BUG_TRACKING_SERVICE, new BugTrackerServiceLocalImp());
		services.put(ServicesConstants.PROJECT_TEAM_SERVICE, new ProjectTeamServiceLocalImp());
		services.put(ServicesConstants.CHAT_SERVICE, new ChatServiceLocalImp());
		services.put(ServicesConstants.MAIL_SERVICE, new MailServiceLocalImp());
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
