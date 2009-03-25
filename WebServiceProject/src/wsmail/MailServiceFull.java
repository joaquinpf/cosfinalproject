/**
 * MailServiceFull.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsmail;

public interface MailServiceFull extends javax.xml.rpc.Service {
    public java.lang.String getMailServiceAddress();

    public wsmail.MailService getMailService() throws javax.xml.rpc.ServiceException;

    public wsmail.MailService getMailService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
