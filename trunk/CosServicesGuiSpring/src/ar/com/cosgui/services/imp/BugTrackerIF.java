package ar.com.cosgui.services.imp;



public interface BugTrackerIF {
    public wsbugtracker.Bug submitBug(java.lang.String description, java.lang.String type, java.lang.String owner, java.lang.String project, java.lang.String status) throws java.rmi.RemoteException;
    public wsbugtracker.Bug changeBugStatus(int number, java.lang.String status) throws java.rmi.RemoteException;
    public wsbugtracker.Bug getBug(int number) throws java.rmi.RemoteException;
    public Object getBugsByType(java.lang.String type) throws java.rmi.RemoteException;
    public Object getBugsByProject(java.lang.String project) throws java.rmi.RemoteException;
    public int addUser(wsbugtracker.Auth user) throws java.rmi.RemoteException;
}