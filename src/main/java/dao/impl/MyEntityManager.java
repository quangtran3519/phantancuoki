package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MyEntityManager {
	private static MyEntityManager instance =null;
	private EntityManager em ;
	private MyEntityManager() {
		em =  Persistence.createEntityManagerFactory("OGM_cuoiki_2").createEntityManager();
	}
	
	
	public synchronized static MyEntityManager getInstance() {
		if (instance==null) {
			instance = new MyEntityManager();
		}
		return instance;
	}
	
	public EntityManager getEm() {
		return em;
	}
	
	
	

}
