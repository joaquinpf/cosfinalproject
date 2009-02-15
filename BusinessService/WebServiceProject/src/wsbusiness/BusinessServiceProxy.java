package wsbusiness;

public class BusinessServiceProxy implements wsbusiness.BusinessService {
  private String _endpoint = null;
  private wsbusiness.BusinessService businessService = null;
  
  public BusinessServiceProxy() {
    _initBusinessServiceProxy();
  }
  
  public BusinessServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initBusinessServiceProxy();
  }
  
  private void _initBusinessServiceProxy() {
    try {
      businessService = (new wsbusiness.BusinessServiceFullLocator()).getBusinessService();
      if (businessService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)businessService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)businessService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (businessService != null)
      ((javax.xml.rpc.Stub)businessService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wsbusiness.BusinessService getBusinessService() {
    if (businessService == null)
      _initBusinessServiceProxy();
    return businessService;
  }
  
  public double getDolarCotization(java.lang.String fromCurrency) throws java.rmi.RemoteException{
    if (businessService == null)
      _initBusinessServiceProxy();
    return businessService.getDolarCotization(fromCurrency);
  }
  
  public double[] convertCurrency(double amount, java.lang.String[] currencies) throws java.rmi.RemoteException{
    if (businessService == null)
      _initBusinessServiceProxy();
    return businessService.convertCurrency(amount, currencies);
  }
  
  
}