/**
 * ProjectTeamServiceFullLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsprojectteam;

public class ProjectTeamServiceFullLocator extends org.apache.axis.client.Service implements wsprojectteam.ProjectTeamServiceFull {

    public ProjectTeamServiceFullLocator() {
    }


    public ProjectTeamServiceFullLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProjectTeamServiceFullLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ProjectTeamService
    private java.lang.String ProjectTeamService_address = "http://localhost:8080/WebServiceProject/services/ProjectTeamService";

    public java.lang.String getProjectTeamServiceAddress() {
        return ProjectTeamService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ProjectTeamServiceWSDDServiceName = "ProjectTeamService";

    public java.lang.String getProjectTeamServiceWSDDServiceName() {
        return ProjectTeamServiceWSDDServiceName;
    }

    public void setProjectTeamServiceWSDDServiceName(java.lang.String name) {
        ProjectTeamServiceWSDDServiceName = name;
    }

    public wsprojectteam.ProjectTeamService getProjectTeamService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ProjectTeamService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProjectTeamService(endpoint);
    }

    public wsprojectteam.ProjectTeamService getProjectTeamService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            wsprojectteam.ProjectTeamServiceBindingStub _stub = new wsprojectteam.ProjectTeamServiceBindingStub(portAddress, this);
            _stub.setPortName(getProjectTeamServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProjectTeamServiceEndpointAddress(java.lang.String address) {
        ProjectTeamService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (wsprojectteam.ProjectTeamService.class.isAssignableFrom(serviceEndpointInterface)) {
                wsprojectteam.ProjectTeamServiceBindingStub _stub = new wsprojectteam.ProjectTeamServiceBindingStub(new java.net.URL(ProjectTeamService_address), this);
                _stub.setPortName(getProjectTeamServiceWSDDServiceName());
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
        if ("ProjectTeamService".equals(inputPortName)) {
            return getProjectTeamService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wsprojectteam", "ProjectTeamServiceFull");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wsprojectteam", "ProjectTeamService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ProjectTeamService".equals(portName)) {
            setProjectTeamServiceEndpointAddress(address);
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
