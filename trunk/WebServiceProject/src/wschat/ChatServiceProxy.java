package wschat;

public class ChatServiceProxy implements wschat.ChatService {
  private String _endpoint = null;
  private wschat.ChatService chatService = null;
  
  public ChatServiceProxy() {
    _initChatServiceProxy();
  }
  
  public ChatServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initChatServiceProxy();
  }
  
  private void _initChatServiceProxy() {
    try {
      chatService = (new wschat.ChatServiceFullLocator()).getChatService();
      if (chatService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)chatService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)chatService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (chatService != null)
      ((javax.xml.rpc.Stub)chatService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wschat.ChatService getChatService() {
    if (chatService == null)
      _initChatServiceProxy();
    return chatService;
  }
  
  public int login(wschat.Auth user) throws java.rmi.RemoteException{
    if (chatService == null)
      _initChatServiceProxy();
    return chatService.login(user);
  }
  
  public int logout(wschat.Auth user) throws java.rmi.RemoteException{
    if (chatService == null)
      _initChatServiceProxy();
    return chatService.logout(user);
  }
  
  public int sendMessage(wschat.TextMessage textMessage) throws java.rmi.RemoteException{
    if (chatService == null)
      _initChatServiceProxy();
    return chatService.sendMessage(textMessage);
  }
  
  public java.lang.String[] getContacts(java.lang.String username) throws java.rmi.RemoteException{
    if (chatService == null)
      _initChatServiceProxy();
    return chatService.getContacts(username);
  }
  
  public int addContact(java.lang.String username, java.lang.String contact) throws java.rmi.RemoteException{
    if (chatService == null)
      _initChatServiceProxy();
    return chatService.addContact(username, contact);
  }
  
  public java.lang.String[] receiveMessage(java.lang.String username) throws java.rmi.RemoteException{
    if (chatService == null)
      _initChatServiceProxy();
    return chatService.receiveMessage(username);
  }
  
  public int getStatus(java.lang.String username) throws java.rmi.RemoteException{
    if (chatService == null)
      _initChatServiceProxy();
    return chatService.getStatus(username);
  }
  
  public int existUserName(java.lang.String username) throws java.rmi.RemoteException{
    if (chatService == null)
      _initChatServiceProxy();
    return chatService.existUserName(username);
  }
  
  public int addUser(wschat.Auth user) throws java.rmi.RemoteException{
    if (chatService == null)
      _initChatServiceProxy();
    return chatService.addUser(user);
  }
  
  
}