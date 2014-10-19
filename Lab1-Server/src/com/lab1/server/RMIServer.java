package com.lab1.server;

import com.lab1.pkginterface.Constant;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    /**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     * @throws AlreadyBoundException 
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        RemoteImpl impl =  new RemoteImpl();
        Registry reg = LocateRegistry.createRegistry(Constant.RMI_PORT);
        reg.bind(Constant.RMI_ID, impl);
        System.out.println("Server is ready!");
        
    }
    
}
