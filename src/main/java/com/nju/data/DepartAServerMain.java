package com.nju.data;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class DepartAServerMain {

	
	public static void main(String[] args) {
		
		try {
			ProvideService departAService = new DepartAProvideImpl();
			 LocateRegistry.createRegistry(8001);
			 Naming.bind("rmi://10.0.0.14:8001/departAService",departAService);
			 System.out.println("departA服务器已启动"); 
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
