/**
 * ChatServiceBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wschat;

public class ChatServiceBindingSkeleton implements wschat.ChatService, org.apache.axis.wsdl.Skeleton {
    private wschat.ChatService impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wschat", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wschat", "Auth"), wschat.Auth.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("login", _params, new javax.xml.namespace.QName("http://wschat", "loginReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wschat", "login"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("login") == null) {
            _myOperations.put("login", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("login")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wschat", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wschat", "Auth"), wschat.Auth.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("logout", _params, new javax.xml.namespace.QName("http://wschat", "logoutReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wschat", "logout"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("logout") == null) {
            _myOperations.put("logout", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("logout")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wschat", "textMessage"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wschat", "TextMessage"), wschat.TextMessage.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("sendMessage", _params, new javax.xml.namespace.QName("http://wschat", "sendMessageReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wschat", "sendMessage"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("sendMessage") == null) {
            _myOperations.put("sendMessage", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("sendMessage")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wschat", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getContacts", _params, new javax.xml.namespace.QName("http://wschat", "getContactsReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://wschat", "ArrayOfString"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wschat", "getContacts"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getContacts") == null) {
            _myOperations.put("getContacts", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getContacts")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wschat", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wschat", "contact"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("addContact", _params, new javax.xml.namespace.QName("http://wschat", "addContactReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wschat", "addContact"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("addContact") == null) {
            _myOperations.put("addContact", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("addContact")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wschat", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wschat", "contact"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("removeContact", _params, new javax.xml.namespace.QName("http://wschat", "removeContactReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wschat", "removeContact"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("removeContact") == null) {
            _myOperations.put("removeContact", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("removeContact")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wschat", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("receiveMessage", _params, new javax.xml.namespace.QName("http://wschat", "receiveMessageReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://wschat", "ArrayOfString"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wschat", "receiveMessage"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("receiveMessage") == null) {
            _myOperations.put("receiveMessage", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("receiveMessage")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wschat", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getStatus", _params, new javax.xml.namespace.QName("http://wschat", "getStatusReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wschat", "getStatus"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getStatus") == null) {
            _myOperations.put("getStatus", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getStatus")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wschat", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("existUserName", _params, new javax.xml.namespace.QName("http://wschat", "existUserNameReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wschat", "existUserName"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("existUserName") == null) {
            _myOperations.put("existUserName", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("existUserName")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wschat", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wschat", "Auth"), wschat.Auth.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("addUser", _params, new javax.xml.namespace.QName("http://wschat", "addUserReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wschat", "addUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("addUser") == null) {
            _myOperations.put("addUser", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("addUser")).add(_oper);
    }

    public ChatServiceBindingSkeleton() {
        this.impl = new wschat.ChatServiceBindingImpl();
    }

    public ChatServiceBindingSkeleton(wschat.ChatService impl) {
        this.impl = impl;
    }
    public int login(wschat.Auth user) throws java.rmi.RemoteException
    {
        int ret = impl.login(user);
        return ret;
    }

    public int logout(wschat.Auth user) throws java.rmi.RemoteException
    {
        int ret = impl.logout(user);
        return ret;
    }

    public int sendMessage(wschat.TextMessage textMessage) throws java.rmi.RemoteException
    {
        int ret = impl.sendMessage(textMessage);
        return ret;
    }

    public java.lang.String[] getContacts(java.lang.String username) throws java.rmi.RemoteException
    {
        java.lang.String[] ret = impl.getContacts(username);
        return ret;
    }

    public int addContact(java.lang.String username, java.lang.String contact) throws java.rmi.RemoteException
    {
        int ret = impl.addContact(username, contact);
        return ret;
    }

    public int removeContact(java.lang.String username, java.lang.String contact) throws java.rmi.RemoteException
    {
        int ret = impl.removeContact(username, contact);
        return ret;
    }

    public java.lang.String[] receiveMessage(java.lang.String username) throws java.rmi.RemoteException
    {
        java.lang.String[] ret = impl.receiveMessage(username);
        return ret;
    }

    public int getStatus(java.lang.String username) throws java.rmi.RemoteException
    {
        int ret = impl.getStatus(username);
        return ret;
    }

    public int existUserName(java.lang.String username) throws java.rmi.RemoteException
    {
        int ret = impl.existUserName(username);
        return ret;
    }

    public int addUser(wschat.Auth user) throws java.rmi.RemoteException
    {
        int ret = impl.addUser(user);
        return ret;
    }

}
