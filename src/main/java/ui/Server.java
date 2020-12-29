package ui;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.security.AllPermission;

import dao.NewDao;
import dao.UserDao;
import dao.impl.NewImpl;
import dao.impl.UserImpl;

public class Server {
	public static void main(String[] args) {
		SecurityManager manager = System.getSecurityManager();
		if (manager==null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			UserDao userDao = new UserImpl();
			NewDao newDao = new NewImpl();
			LocateRegistry.createRegistry(9999);
			Naming.bind("rmi://QuangTran:9999/userDao", userDao);
			Naming.bind("rmi://QuangTran:9999/newDao", newDao);
			System.out.println("Server is ready...");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
