package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
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
	//db.users.aggregate([{$project:{mun:{$size:{$ifNull:["$comments",[]]}}}}])
	@Override
	public Map<User, Integer> getStatistics() throws RemoteException {
		 Map<User, Integer> map = new HashMap<User, Integer>();
		 String sql = "db.users.aggregate([{'$project':{'mun':{$size:{$ifNull:['$comments',[]]}}}},{'$match':{'mun':{$gte:3}}}])";
		 List<?> list = em.createNativeQuery(sql).getResultList();
		 if (list.size()>0) {
			for(Object o: list) {
				Object[] temp = (Object[]) o;
				User user = em.find(User.class,(Long) temp[0]  );
				map.put(user, (Integer) temp[1]);
			}
		}		 
		return map;
	}

	
//	db.users.find({'$or':[{'userName':'John Smith'},{'userEmail':'xyz@gmail.com'}]})
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers(String keyword) throws RemoteException {
		return  em.createNativeQuery("db.users.find({'$or':[{'userName':'"+keyword+"'},{'userEmail':'"+keyword+"'}]})",User.class).setMaxResults(5).getResultList();
	}

	@Override
	public User getUSer(Long id) throws RemoteException {
		return em.find(User.class, id);
	}

}
