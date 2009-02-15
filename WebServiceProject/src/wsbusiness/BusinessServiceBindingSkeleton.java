/**
 * BusinessServiceBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsbusiness;

public class BusinessServiceBindingSkeleton implements wsbusiness.BusinessService, org.apache.axis.wsdl.Skeleton {
    private wsbusiness.BusinessService impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsbusiness", "fromCurrency"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getDolarCotization", _params, new javax.xml.namespace.QName("http://wsbusiness", "getDolarCotizationReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsbusiness", "getDolarCotization"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getDolarCotization") == null) {
            _myOperations.put("getDolarCotization", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getDolarCotization")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsbusiness", "amount"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://wsbusiness", "currencies"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsbusiness", "ArrayOfString"), java.lang.String[].class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("convertCurrency", _params, new javax.xml.namespace.QName("http://wsbusiness", "convertCurrencyReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://wsbusiness", "ArrayOfDouble"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://wsbusiness", "convertCurrency"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("convertCurrency") == null) {
            _myOperations.put("convertCurrency", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("convertCurrency")).add(_oper);
    }

    public BusinessServiceBindingSkeleton() {
        this.impl = new wsbusiness.BusinessServiceBindingImpl();
    }

    public BusinessServiceBindingSkeleton(wsbusiness.BusinessService impl) {
        this.impl = impl;
    }
    public double getDolarCotization(java.lang.String fromCurrency) throws java.rmi.RemoteException
    {
        double ret = impl.getDolarCotization(fromCurrency);
        return ret;
    }

    public double[] convertCurrency(double amount, java.lang.String[] currencies) throws java.rmi.RemoteException
    {
        double[] ret = impl.convertCurrency(amount, currencies);
        return ret;
    }

}
