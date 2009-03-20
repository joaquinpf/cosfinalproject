package ar.com.cosgui.services;
import java.util.HashMap;

import ar.com.cosgui.services.imp.BugTrackerServiceLocalImp;
import ar.com.cosgui.services.imp.ProjectTeamServiceLocalImp;



public class ServicePoint {
	private HashMap<String, IServiceLocalImp> services = new HashMap<String, IServiceLocalImp>();
	public static ServicePoint INSTANCE = new ServicePoint();
	
	protected ServicePoint(){
		services.put(ServicesConstants.BUG_TRACKING_SERVICE, new BugTrackerServiceLocalImp());
		services.put(ServicesConstants.PROJECT_TEAM_SERVICE, new ProjectTeamServiceLocalImp());
	}
	
	public IServiceLocalImp getService(String service){
		return services.get(service);
	}
}
