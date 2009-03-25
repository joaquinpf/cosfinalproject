/**
 * ChatServiceFullLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wschat;

public class ChatServiceFullLocator extends org.apache.axis.client.Service implements wschat.ChatServiceFull {

    public ChatServiceFullLocator() {
    }


    public ChatServiceFullLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ChatServiceFullLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ChatService
    private java.lang.String ChatService_address = "http://localhost:8080/WebServiceProject/services/ChatService";

    public java.lang.String getChatServiceAddress() {
        return ChatService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ChatServiceWSDDServiceName = "ChatService";

    public java.lang.String getChatServiceWSDDServiceName() {
        return ChatServiceWSDDServiceName;
    }

    public void setChatServiceWSDDServiceName(java.lang.String name) {
        ChatServiceWSDDServiceName = name;
    }

    public wschat.ChatService getChatService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ChatService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getChatService(endpoint);
    }

    public wschat.ChatService getChatService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            wschat.ChatServiceBindingStub _stub = new wschat.ChatServiceBindingStub(portAddress, this);
            _stub.setPortName(getChatServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setChatServiceEndpointAddress(java.lang.String address) {
        ChatService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (wschat.ChatService.class.isAssignableFrom(serviceEndpointInterface)) {
                wschat.ChatServiceBindingStub _stub = new wschat.ChatServiceBindingStub(new java.net.URL(ChatService_address), this);
                _stub.setPortName(getChatServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ChatService".equals(inputPortName)) {
            return getChatService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wschat", "ChatServiceFull");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wschat", "ChatService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ChatService".equals(portName)) {
            setChatServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
