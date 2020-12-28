package ui;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import dao.impl.MyEntityManager;
import dao.impl.NewImpl;
import dao.impl.UserImpl;
import entity.Comment;
import entity.Gender;
import entity.News;
import entity.User;

public class Maintest {
	public static void main(String[] args) throws RemoteException {
		NewImpl newImpl = new NewImpl();
		UserImpl userImpl = new UserImpl();

		News news =  newImpl.findNew(14l);
		//News news2 = new News(id, newTitle, newsContent, creationDate, newsCategories, tags, votes)
		 Comment comment = new Comment("hahahahaha", LocalDateTime.now());
		 comment.setNewl(news);		 
		 Set<String> strings = new HashSet<String>();
		 strings.add("abc");
		 strings.add("xyz");
		 User user = new User(3519l, "Quang", "Quangtran3519@gmail.com", "123",strings , Gender.Female);
		 user.setComments(Arrays.asList(comment ));		
		 if (userImpl.addUSer(user)) {
			System.out.println("them user thanh cong");				
		}	
	}
}
