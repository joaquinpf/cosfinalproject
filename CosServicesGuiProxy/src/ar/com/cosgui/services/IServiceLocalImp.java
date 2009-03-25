package ar.com.cosgui.services;

/**
 * Interface que deben implementar los servicios para utilizarlos en ServicePoint
 * @author Joaquin Alejandro Perez Fuentes
 */
public interface IServiceLocalImp{
	public void connect();
	public int addUser(String user, String pass);
}
