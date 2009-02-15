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
        };
        _oper = new org.apache.axis.description.OperationDesc("closeBug", _params, new javax.xml.namespace.QName("http://wsbugtracker", "closeBugReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://wsbugtracker", "Bug"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsbugtracker", "closeBug"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("closeBug") == null) {
            _myOperations.put("closeBug", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("closeBug")).add(_oper);
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
    }

    public BugTrackerServiceBindingSkeleton() {
        this.impl = new wsbugtracker.BugTrackerServiceBindingImpl();
    }

    public BugTrackerServiceBindingSkeleton(wsbugtracker.BugTrackerService impl) {
        this.impl = impl;
    }
    public wsbugtracker.Bug submitBug(java.lang.String description, java.lang.String type) throws java.rmi.RemoteException
    {
        wsbugtracker.Bug ret = impl.submitBug(description, type);
        return ret;
    }

    public wsbugtracker.Bug closeBug(int number) throws java.rmi.RemoteException
    {
        wsbugtracker.Bug ret = impl.closeBug(number);
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

}
