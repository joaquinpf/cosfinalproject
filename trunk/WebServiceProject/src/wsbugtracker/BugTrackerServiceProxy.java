package wsbugtracker;

import java.rmi.RemoteException;

public class BugTrackerServiceProxy implements wsbugtracker.BugTrackerService {
  private String _endpoint = null;
  private wsbugtracker.BugTrackerService bugTrackerService = null;
  
  public BugTrackerServiceProxy() {
    _initBugTrackerServiceProxy();
  }
  
  public BugTrackerServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initBugTrackerServiceProxy();
  }
  
  private void _initBugTrackerServiceProxy() {
    try {
      bugTrackerService = (new wsbugtracker.BugTrackerServiceFullLocator()).getBugTrackerService();
      if (bugTrackerService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bugTrackerService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bugTrackerService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bugTrackerService != null)
      ((javax.xml.rpc.Stub)bugTrackerService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wsbugtracker.BugTrackerService getBugTrackerService() {
    if (bugTrackerService == null)
      _initBugTrackerServiceProxy();
    return bugTrackerService;
  }
  
  public wsbugtracker.Bug submitBug(java.lang.String description, java.lang.String type, java.lang.String owner, java.lang.String project, java.lang.String status) throws java.rmi.RemoteException{
    if (bugTrackerService == null)
      _initBugTrackerServiceProxy();
    return bugTrackerService.submitBug(description, type, owner, project, status);
  }
  
  public wsbugtracker.Bug getBug(int number) throws java.rmi.RemoteException{
    if (bugTrackerService == null)
      _initBugTrackerServiceProxy();
    return bugTrackerService.getBug(number);
  }
  
  public int[] getBugsByType(java.lang.String type) throws java.rmi.RemoteException{
    if (bugTrackerService == null)
      _initBugTrackerServiceProxy();
    return bugTrackerService.getBugsByType(type);
  }
  
  public int[] getBugsByProject(java.lang.String project) throws java.rmi.RemoteException{
    if (bugTrackerService == null)
      _initBugTrackerServiceProxy();
    return bugTrackerService.getBugsByProject(project);
  }
  
  public int addUser(wsbugtracker.Auth user) throws java.rmi.RemoteException{
    if (bugTrackerService == null)
      _initBugTrackerServiceProxy();
    return bugTrackerService.addUser(user);
  }

  public Bug changeBugStatus(int number, String status) throws RemoteException {
	if (bugTrackerService == null)
	   _initBugTrackerServiceProxy();
	return bugTrackerService.changeBugStatus(number, status);
  }
  
  
}