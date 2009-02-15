/**
 * BugTrackerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsbugtracker;

public interface BugTrackerService extends java.rmi.Remote {
    public wsbugtracker.Bug submitBug(java.lang.String description, java.lang.String type) throws java.rmi.RemoteException;
    public wsbugtracker.Bug closeBug(int number) throws java.rmi.RemoteException;
    public wsbugtracker.Bug getBug(int number) throws java.rmi.RemoteException;
    public int[] getBugsByType(java.lang.String type) throws java.rmi.RemoteException;
}
