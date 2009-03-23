/**
 * BugTrackerServiceBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsbugtracker;

public class BugTrackerServiceBindingSkeleton implements wsbugtracker.BugTrackerService, org.apache.axis.wsdl.Skeleton {
    private wsbugtracker.BugTrackerService impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsbugtracker", "description"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsbugtracker", "type"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsbugtracker", "owner"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsbugtracker", "project"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsbugtracker", "status"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("submitBug", _params, new javax.xml.namespace.QName("http://wsbugtracker", "submitBugReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://wsbugtracker", "Bug"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsbugtracker", "submitBug"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("submitBug") == null) {
            _myOperations.put("submitBug", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("submitBug")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsbugtracker", "number"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsbugtracker", "status"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("changeBugStatus", _params, new javax.xml.namespace.QName("http://wsbugtracker", "changeBugStatusReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://wsbugtracker", "Bug"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsbugtracker", "changeBugStatus"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("changeBugStatus") == null) {
            _myOperations.put("changeBugStatus", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("changeBugStatus")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsbugtracker", "number"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getBug", _params, new javax.xml.namespace.QName("http://wsbugtracker", "getBugReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://wsbugtracker", "Bug"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsbugtracker", "getBug"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getBug") == null) {
            _myOperations.put("getBug", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getBug")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsbugtracker", "type"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getBugsByType", _params, new javax.xml.namespace.QName("http://wsbugtracker", "getBugsByTypeReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://wsbugtracker", "ArrayOfInt"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsbugtracker", "getBugsByType"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getBugsByType") == null) {
            _myOperations.put("getBugsByType", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getBugsByType")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsbugtracker", "project"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getBugsByProject", _params, new javax.xml.namespace.QName("http://wsbugtracker", "getBugsByTypeReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://wsbugtracker", "ArrayOfInt"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsbugtracker", "getBugsByProject"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getBugsByProject") == null) {
            _myOperations.put("getBugsByProject", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getBugsByProject")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsbugtracker", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsbugtracker", "Auth"), wsbugtracker.Auth.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("addUser", _params, new javax.xml.namespace.QName("http://wsbugtracker", "addUserReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsbugtracker", "addUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("addUser") == null) {
            _myOperations.put("addUser", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("addUser")).add(_oper);
    }

    public BugTrackerServiceBindingSkeleton() {
        this.impl = new wsbugtracker.BugTrackerServiceBindingImpl();
    }

    public BugTrackerServiceBindingSkeleton(wsbugtracker.BugTrackerService impl) {
        this.impl = impl;
    }
    public wsbugtracker.Bug submitBug(java.lang.String description, java.lang.String type, java.lang.String owner, java.lang.String project, java.lang.String status) throws java.rmi.RemoteException
    {
        wsbugtracker.Bug ret = impl.submitBug(description, type, owner, project, status);
        return ret;
    }

    public wsbugtracker.Bug changeBugStatus(int number, java.lang.String status) throws java.rmi.RemoteException
    {
        wsbugtracker.Bug ret = impl.changeBugStatus(number, status);
        return ret;
    }

    public wsbugtracker.Bug getBug(int number) throws java.rmi.RemoteException
    {
        wsbugtracker.Bug ret = impl.getBug(number);
        return ret;
    }

    public int[] getBugsByType(java.lang.String type) throws java.rmi.RemoteException
    {
        int[] ret = impl.getBugsByType(type);
        return ret;
    }

    public int[] getBugsByProject(java.lang.String project) throws java.rmi.RemoteException
    {
        int[] ret = impl.getBugsByProject(project);
        return ret;
    }

    public int addUser(wsbugtracker.Auth user) throws java.rmi.RemoteException
    {
        int ret = impl.addUser(user);
        return ret;
    }

}
