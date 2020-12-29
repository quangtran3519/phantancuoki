package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;


import dao.NewDao;
import entity.News;

public class NewImpl extends UnicastRemoteObject implements NewDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	public NewImpl() throws RemoteException {
		em = MyEntityManager.getInstance().getEm();
		
	}
	
	
	// hibernate khong ho tro tao index tren field co thuoc tinh set nen phai tao index duoi mongo
	// db.news.find({$text:{$search:'Community'}}).pretty()
	//db.news.createIndex({tags:'text',newsCategories:'text'})
	
	@SuppressWarnings("unchecked")
	@Override
	public List<News> getNewsByTagsOrCategoriesName(String value) throws RemoteException {
		
		
		return em.createNativeQuery("db.news.find({$text:{$search:'"+value+"'}})", News.class).setMaxResults(5).getResultList();
		
	}

	
	//db.news.aggregate([{$lookup:{'from':'users','localField':'_id','foreignField':'comments.newID','as':'rs'}},{$match:{'rs.userEmail':'Sondaz@gmail.com'}},{$project:{_id:1,'newsContent':1,'newsTitle':1,'creationDate':1,'newsCategories':1,'tags':1,'votes':1}}]).pretty()
	//db.news.aggregate([{$lookup:{from:'users',localField:'_id',foreignField:'comments.newID',as:'rs'}},{$match:{'rs.userEmail':'Sondaz@gmail.com'}},{$project:{_id:1}}])
	@SuppressWarnings({  "unchecked" })
	@Override
	public List<News> listNewsByUserEmail(String email) throws RemoteException {
	return	em.createNativeQuery("db.news.aggregate([{'$lookup':{'from':'users','localField':'_id','foreignField':'comments.newID','as':'rs'}},{'$match':{'rs.userEmail':'"+email+"'}},{'$project':{'newsContent':'1','newsTitle':'1','creationDate':'1','newsCategories':'1','tags':'1','votes':'1'}}])",News.class).getResultList();
		
	}

	
	@Override
	public News findNew(Long l) throws RemoteException {
		return em.find(News.class, l);
	}

	

}
