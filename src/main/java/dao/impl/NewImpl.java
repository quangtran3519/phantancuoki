package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.NewDao;
import entity.News;

public class NewImpl extends UnicastRemoteObject implements NewDao {
	private EntityManager em;
	public NewImpl() throws RemoteException {
		em = MyEntityManager.getInstance().getEm();
		
	}
	
	@Override
	public List<News> getNewsByTagsOrCategoriesName(String value) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> listNewsByUserEmail(String email) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public News findNew(Long l) throws RemoteException {
		return em.find(News.class, l);
	}

	

}
