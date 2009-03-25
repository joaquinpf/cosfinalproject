/**
 * MailServiceBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsmail;

public class MailServiceBindingSkeleton implements wsmail.MailService, org.apache.axis.wsdl.Skeleton {
    private wsmail.MailService impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsmail", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsmail", "Auth"), wsmail.Auth.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsmail", "mail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsmail", "Mail"), wsmail.Mail.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("sendMail", _params, new javax.xml.namespace.QName("http://wsmail", "sendMailReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsmail", "sendMail"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("sendMail") == null) {
            _myOperations.put("sendMail", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("sendMail")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsmail", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsmail", "Auth"), wsmail.Auth.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("validUser", _params, new javax.xml.namespace.QName("http://wsmail", "validUserReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsmail", "validUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("validUser") == null) {
            _myOperations.put("validUser", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("validUser")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsmail", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("validUserName", _params, new javax.xml.namespace.QName("http://wsmail", "validUserNameReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsmail", "validUserName"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("validUserName") == null) {
            _myOperations.put("validUserName", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("validUserName")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsmail", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsmail", "Auth"), wsmail.Auth.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getMails", _params, new javax.xml.namespace.QName("http://wsmail", "getMailsReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://wsmail", "ArrayOfString"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsmail", "getMails"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getMails") == null) {
            _myOperations.put("getMails", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getMails")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsmail", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsmail", "Auth"), wsmail.Auth.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsmail", "mail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsmail", "Mail"), wsmail.Mail.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("saveMail", _params, new javax.xml.namespace.QName("http://wsmail", "saveMailReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsmail", "saveMail"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("saveMail") == null) {
            _myOperations.put("saveMail", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("saveMail")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsmail", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsmail", "Auth"), wsmail.Auth.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsmail", "mail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsmail", "Mail"), wsmail.Mail.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("deleteMail", _params, new javax.xml.namespace.QName("http://wsmail", "deleteMailReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsmail", "deleteMail"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("deleteMail") == null) {
            _myOperations.put("deleteMail", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("deleteMail")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsmail", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsmail", "Auth"), wsmail.Auth.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("addUserMail", _params, new javax.xml.namespace.QName("http://wsmail", "addUserMailReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsmail", "addUserMail"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("addUserMail") == null) {
            _myOperations.put("addUserMail", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("addUserMail")).add(_oper);
    }

    public MailServiceBindingSkeleton() {
        this.impl = new wsmail.MailServiceBindingImpl();
    }

    public MailServiceBindingSkeleton(wsmail.MailService impl) {
        this.impl = impl;
    }
    public int sendMail(wsmail.Auth user, wsmail.Mail mail) throws java.rmi.RemoteException
    {
        int ret = impl.sendMail(user, mail);
        return ret;
    }

    public int validUser(wsmail.Auth user) throws java.rmi.RemoteException
    {
        int ret = impl.validUser(user);
        return ret;
    }

    public int validUserName(java.lang.String user) throws java.rmi.RemoteException
    {
        int ret = impl.validUserName(user);
        return ret;
    }

    public java.lang.String[] getMails(wsmail.Auth user) throws java.rmi.RemoteException
    {
        java.lang.String[] ret = impl.getMails(user);
        return ret;
    }

    public int saveMail(wsmail.Auth user, wsmail.Mail mail) throws java.rmi.RemoteException
    {
        int ret = impl.saveMail(user, mail);
        return ret;
    }

    public int deleteMail(wsmail.Auth user, wsmail.Mail mail) throws java.rmi.RemoteException
    {
        int ret = impl.deleteMail(user, mail);
        return ret;
    }

    public int addUserMail(wsmail.Auth user) throws java.rmi.RemoteException
    {
        int ret = impl.addUserMail(user);
        return ret;
    }

}
