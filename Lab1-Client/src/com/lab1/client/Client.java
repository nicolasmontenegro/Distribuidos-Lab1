package com.lab1.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.lab1.pkginterface.Constant;
import com.lab1.pkginterface.TestRemote;

public class Client {

	/**
     * @param args the command line arguments
     * @throws RemoteException
     * @throws NotBoundException 
     */
	
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", Constant.RMI_PORT);
		TestRemote remote = (TestRemote) registry.lookup(Constant.RMI_ID);
		
		System.out.println(remote.UserLogged("test"));
		System.out.println(remote.UserLogged("null"));		
	}

}
