package wsprojectteam;

public class ProjectTeamServiceProxy implements wsprojectteam.ProjectTeamService {
  private String _endpoint = null;
  private wsprojectteam.ProjectTeamService projectTeamService = null;
  
  public ProjectTeamServiceProxy() {
    _initProjectTeamServiceProxy();
  }
  
  public ProjectTeamServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initProjectTeamServiceProxy();
  }
  
  private void _initProjectTeamServiceProxy() {
    try {
      projectTeamService = (new wsprojectteam.ProjectTeamServiceFullLocator()).getProjectTeamService();
      if (projectTeamService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)projectTeamService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)projectTeamService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (projectTeamService != null)
      ((javax.xml.rpc.Stub)projectTeamService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wsprojectteam.ProjectTeamService getProjectTeamService() {
    if (projectTeamService == null)
      _initProjectTeamServiceProxy();
    return projectTeamService;
  }
  
  public java.lang.String[] getProjects() throws java.rmi.RemoteException{
    if (projectTeamService == null)
      _initProjectTeamServiceProxy();
    return projectTeamService.getProjects();
  }
  
  public java.lang.String[] getProjectsForUser(wsprojectteam.Auth user) throws java.rmi.RemoteException{
    if (projectTeamService == null)
      _initProjectTeamServiceProxy();
    return projectTeamService.getProjectsForUser(user);
  }
  
  public java.lang.String[] getGroupsForProject(java.lang.String project) throws java.rmi.RemoteException{
    if (projectTeamService == null)
      _initProjectTeamServiceProxy();
    return projectTeamService.getGroupsForProject(project);
  }
  
  public boolean addProject(java.lang.String description, java.lang.String name) throws java.rmi.RemoteException{
    if (projectTeamService == null)
      _initProjectTeamServiceProxy();
    return projectTeamService.addProject(description, name);
  }
  
  public boolean addGroupToProject(java.lang.String description, java.lang.String project, java.lang.String name) throws java.rmi.RemoteException{
    if (projectTeamService == null)
      _initProjectTeamServiceProxy();
    return projectTeamService.addGroupToProject(description, project, name);
  }
  
  public boolean addMemberToProject(java.lang.String description, java.lang.String group, java.lang.String project, wsprojectteam.Auth user) throws java.rmi.RemoteException{
    if (projectTeamService == null)
      _initProjectTeamServiceProxy();
    return projectTeamService.addMemberToProject(description, group, project, user);
  }
  
  public int addUser(wsprojectteam.Auth user) throws java.rmi.RemoteException{
    if (projectTeamService == null)
      _initProjectTeamServiceProxy();
    return projectTeamService.addUser(user);
  }
  
  
}