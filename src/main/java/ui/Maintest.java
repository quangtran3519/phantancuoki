package ui;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

		News news =  newImpl.findNew(21l);
		News news2 =  newImpl.findNew(24l);
		News news3 =  newImpl.findNew(4l);
		News news4 =  newImpl.findNew(14l);
		System.out.println(news2);
		//News news2 = new News(id, newTitle, newsContent, creationDate, newsCategories, tags, votes)
		 Comment comment = new Comment("hahahahaha", LocalDateTime.now());
		 comment.setNewl(news);	
		 Comment comment2 = new Comment("hahahahaha", LocalDateTime.now());
		 comment2.setNewl(news2);	
		 Comment comment3 = new Comment("hahahahaha", LocalDateTime.now());
		 comment3.setNewl(news3);	
		 Comment comment4 = new Comment("hahahahaha", LocalDateTime.now());
		 comment4.setNewl(news4);	
		
		 Set<String> strings = new HashSet<String>();
		 strings.add("abc");
		 strings.add("xyz");
		 User user = new User(1117l, "Son12", "Sondaz@gmail.com", "123",strings , Gender.Female);
		 List<Comment> listComment = new ArrayList<Comment>();
		 listComment.add(comment);
		 listComment.add(comment2);
		 listComment.add(comment3);
		 listComment.add(comment4);
		user.setComments(listComment );		
//		 if (userImpl.addUSer(user)) {
//			System.out.println("them user thanh cong");				
//		}	
		 System.out.println("cau 2 b");
		 List<News> list = newImpl.getNewsByTagsOrCategoriesName("Community");
		 list.forEach(x->System.out.println(x));	
		 System.out.println("cau 2 e");
		 List<User> users = userImpl.listUsers("Sondaz@gmail.com");
		 users.forEach(x->System.out.println(x));
		 System.out.println("cau 2 d");
		 List<News> news5 = newImpl.listNewsByUserEmail("Sondaz@gmail.com");
		 news5.forEach(x->System.out.println(x));	
		 System.out.println("cau 2 c");
		 Map<User, Integer> map = userImpl.getStatistics();
		 map.forEach((x,y)-> System.out.println(x + "tổng sô bình luận :"+ y));
		 
		 
	}
}
