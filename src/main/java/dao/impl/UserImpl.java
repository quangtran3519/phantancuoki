package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.UserDao;
import entity.User;

public class UserImpl extends UnicastRemoteObject implements UserDao {
	private EntityManager em ;
	public UserImpl() throws RemoteException {
		em = MyEntityManager.getInstance().getEm();
	}

	@Override
	public boolean addUSer(User u) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(u);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}	
		return false;
	}

	@Override
	public Map<User, Integer> getStatistics() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listUsers(String keyword) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
