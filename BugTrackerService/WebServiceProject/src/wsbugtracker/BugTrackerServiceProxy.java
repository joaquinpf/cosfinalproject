package wsbugtracker;

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
  
  public wsbugtracker.Bug submitBug(java.lang.String description, java.lang.String type) throws java.rmi.RemoteException{
    if (bugTrackerService == null)
      _initBugTrackerServiceProxy();
    return bugTrackerService.submitBug(description, type);
  }
  
  public wsbugtracker.Bug closeBug(int number) throws java.rmi.RemoteException{
    if (bugTrackerService == null)
      _initBugTrackerServiceProxy();
    return bugTrackerService.closeBug(number);
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
  
  
}