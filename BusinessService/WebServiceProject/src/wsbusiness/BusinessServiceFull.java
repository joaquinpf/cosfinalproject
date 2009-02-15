/**
 * BusinessServiceFull.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsbusiness;

public interface BusinessServiceFull extends javax.xml.rpc.Service {
    public java.lang.String getBusinessServiceAddress();

    public wsbusiness.BusinessService getBusinessService() throws javax.xml.rpc.ServiceException;

    public wsbusiness.BusinessService getBusinessService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
