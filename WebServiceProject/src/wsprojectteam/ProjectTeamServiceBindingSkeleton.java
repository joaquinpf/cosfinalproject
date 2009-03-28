/**
 * ProjectTeamServiceBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsprojectteam;

public class ProjectTeamServiceBindingSkeleton implements wsprojectteam.ProjectTeamService, org.apache.axis.wsdl.Skeleton {
    private wsprojectteam.ProjectTeamService impl;
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
        };
        _oper = new org.apache.axis.description.OperationDesc("getProjects", _params, new javax.xml.namespace.QName("http://wsprojectteam", "result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://wsprojectteam", "ArrayOfString"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsprojectteam", "getProjects"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getProjects") == null) {
            _myOperations.put("getProjects", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getProjects")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsprojectteam", "project"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getUsersForProject", _params, new javax.xml.namespace.QName("http://wsprojectteam", "result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://wsprojectteam", "ArrayOfString"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsprojectteam", "getUsersForProject"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getUsersForProject") == null) {
            _myOperations.put("getUsersForProject", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getUsersForProject")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsprojectteam", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsprojectteam", "Auth"), wsprojectteam.Auth.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getProjectsForUser", _params, new javax.xml.namespace.QName("http://wsprojectteam", "result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://wsprojectteam", "ArrayOfString"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsprojectteam", "getProjectsForUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getProjectsForUser") == null) {
            _myOperations.put("getProjectsForUser", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getProjectsForUser")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsprojectteam", "project"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getGroupsForProject", _params, new javax.xml.namespace.QName("http://wsprojectteam", "result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://wsprojectteam", "ArrayOfString"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsprojectteam", "getGroupsForProject"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getGroupsForProject") == null) {
            _myOperations.put("getGroupsForProject", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getGroupsForProject")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsprojectteam", "description"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsprojectteam", "name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("addProject", _params, new javax.xml.namespace.QName("http://wsprojectteam", "result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsprojectteam", "addProject"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("addProject") == null) {
            _myOperations.put("addProject", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("addProject")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsprojectteam", "description"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsprojectteam", "project"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsprojectteam", "name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("addGroupToProject", _params, new javax.xml.namespace.QName("http://wsprojectteam", "result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsprojectteam", "addGroupToProject"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("addGroupToProject") == null) {
            _myOperations.put("addGroupToProject", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("addGroupToProject")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsprojectteam", "description"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsprojectteam", "group"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsprojectteam", "project"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsprojectteam", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsprojectteam", "Auth"), wsprojectteam.Auth.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("addMemberToProject", _params, new javax.xml.namespace.QName("http://wsprojectteam", "result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsprojectteam", "addMemberToProject"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("addMemberToProject") == null) {
            _myOperations.put("addMemberToProject", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("addMemberToProject")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsprojectteam", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsprojectteam", "Auth"), wsprojectteam.Auth.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("addUser", _params, new javax.xml.namespace.QName("http://wsprojectteam", "addUserReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsprojectteam", "addUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("addUser") == null) {
            _myOperations.put("addUser", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("addUser")).add(_oper);
    }

    public ProjectTeamServiceBindingSkeleton() {
        this.impl = new wsprojectteam.ProjectTeamServiceBindingImpl();
    }

    public ProjectTeamServiceBindingSkeleton(wsprojectteam.ProjectTeamService impl) {
        this.impl = impl;
    }
    public java.lang.String[] getProjects() throws java.rmi.RemoteException
    {
        java.lang.String[] ret = impl.getProjects();
        return ret;
    }

    public java.lang.String[] getUsersForProject(java.lang.String project) throws java.rmi.RemoteException
    {
        java.lang.String[] ret = impl.getUsersForProject(project);
        return ret;
    }

    public java.lang.String[] getProjectsForUser(wsprojectteam.Auth user) throws java.rmi.RemoteException
    {
        java.lang.String[] ret = impl.getProjectsForUser(user);
        return ret;
    }

    public java.lang.String[] getGroupsForProject(java.lang.String project) throws java.rmi.RemoteException
    {
        java.lang.String[] ret = impl.getGroupsForProject(project);
        return ret;
    }

    public boolean addProject(java.lang.String description, java.lang.String name) throws java.rmi.RemoteException
    {
        boolean ret = impl.addProject(description, name);
        return ret;
    }

    public boolean addGroupToProject(java.lang.String description, java.lang.String project, java.lang.String name) throws java.rmi.RemoteException
    {
        boolean ret = impl.addGroupToProject(description, project, name);
        return ret;
    }

    public boolean addMemberToProject(java.lang.String description, java.lang.String group, java.lang.String project, wsprojectteam.Auth user) throws java.rmi.RemoteException
    {
        boolean ret = impl.addMemberToProject(description, group, project, user);
        return ret;
    }

    public int addUser(wsprojectteam.Auth user) throws java.rmi.RemoteException
    {
        int ret = impl.addUser(user);
        return ret;
    }

}
