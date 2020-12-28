package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.News;

public interface NewDao extends Remote {
	//+ getNewsByTagsOrCategoriesName(value: String): List<News>
	public List<News> getNewsByTagsOrCategoriesName(String value) throws RemoteException;
	
	
	//+ listNewsByUserEmail(email: String) : List<News>
	public List<News >listNewsByUserEmail(String email) throws RemoteException; 
	
	//find NEw
	public News findNew(Long id) throws RemoteException;


}
