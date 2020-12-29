package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import entity.User;

public interface UserDao extends Remote {
	//+ addUser(u: User): boolean
	public boolean addUSer(User u) throws RemoteException; 
	public User getUSer(Long id) throws RemoteException; 
	//+ getStatistics(): Map<User, Integer>
	
	public Map<User, Integer> getStatistics() throws RemoteException;
	
	//+ listUsers(keyword: String) : List<User>
	public List<User> listUsers(String keyword) throws RemoteException;
}
