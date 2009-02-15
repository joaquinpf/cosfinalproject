/**
 * BusinessService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsbusiness;

public interface BusinessService extends java.rmi.Remote {
    public double getDolarCotization(java.lang.String fromCurrency) throws java.rmi.RemoteException;
    public double[] convertCurrency(double amount, java.lang.String[] currencies) throws java.rmi.RemoteException;
}
