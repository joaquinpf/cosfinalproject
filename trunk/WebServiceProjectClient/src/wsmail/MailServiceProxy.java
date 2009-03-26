package wsmail;

public class MailServiceProxy implements wsmail.MailService {
  private String _endpoint = null;
  private wsmail.MailService mailService = null;
  
  public MailServiceProxy() {
    _initMailServiceProxy();
  }
  
  public MailServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initMailServiceProxy();
  }
  
  private void _initMailServiceProxy() {
    try {
      mailService = (new wsmail.MailServiceFullLocator()).getMailService();
      if (mailService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mailService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mailService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mailService != null)
      ((javax.xml.rpc.Stub)mailService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wsmail.MailService getMailService() {
    if (mailService == null)
      _initMailServiceProxy();
    return mailService;
  }
  
  public int sendMail(wsmail.Auth user, wsmail.Mail mail) throws java.rmi.RemoteException{
    if (mailService == null)
      _initMailServiceProxy();
    return mailService.sendMail(user, mail);
  }
  
  public int validUser(wsmail.Auth user) throws java.rmi.RemoteException{
    if (mailService == null)
      _initMailServiceProxy();
    return mailService.validUser(user);
  }
  
  public int validUserName(java.lang.String user) throws java.rmi.RemoteException{
    if (mailService == null)
      _initMailServiceProxy();
    return mailService.validUserName(user);
  }
  
  public java.lang.String[] getMails(wsmail.Auth user) throws java.rmi.RemoteException{
    if (mailService == null)
      _initMailServiceProxy();
    return mailService.getMails(user);
  }
  
  public int saveMail(wsmail.Auth user, wsmail.Mail mail) throws java.rmi.RemoteException{
    if (mailService == null)
      _initMailServiceProxy();
    return mailService.saveMail(user, mail);
  }
  
  public int deleteMail(wsmail.Auth user, wsmail.Mail mail) throws java.rmi.RemoteException{
    if (mailService == null)
      _initMailServiceProxy();
    return mailService.deleteMail(user, mail);
  }
  
  public int addUserMail(wsmail.Auth user) throws java.rmi.RemoteException{
    if (mailService == null)
      _initMailServiceProxy();
    return mailService.addUserMail(user);
  }
  /*
  public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("user.dir"));
		wsmail.MailServiceProxy service = new wsmail.MailServiceProxy ();
		try {
			Login login = new Login(service);
			login.setVisible(true);
		}// catch (RemoteException e) {
			catch (Exception e) {
				System.out.println("Ocurrio un problema al intentarconectarse remotamentecon elservidor.");
				e.printStackTrace();
		}
  }*/
}