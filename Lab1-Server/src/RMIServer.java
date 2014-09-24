import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

import pkginterface.*;

public class RMIServer {

    private static Scanner s;

	/**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     * @throws AlreadyBoundException 
     */
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        RemoteImpl impl =  new RemoteImpl();
        Registry reg = LocateRegistry.createRegistry(Constant.RMI_PORT);
        reg.bind(Constant.RMI_ID, impl);
        System.out.println("Server is ready!");
        
        try 
        {
        	System.setSecurityManager(new RMISecurityManager());
        	s = new Scanner(System.in);
        	System.out.println("Enter Your name and press Enter:");
        	String name=s.nextLine().trim();
        	 
        	Chat server = new Chat(name);	
        	 
        	Naming.rebind("rmi://localhost:222/ABC", server);
        	 
        	System.out.println("[System] Chat Remote Object is ready:");
        	 
        	while(true)
        	{
	        	String msg=s.nextLine().trim();
	        	if (server.getClient()!=null)
	        	{
		        	ChatInterface client=server.getClient();
		        	msg="["+server.getName()+"] "+msg;
		        	client.send(msg);
	        	}	
        	}
        	 
        }
        catch (Exception e) 
        {
        	System.out.println("[System] Server failed: " + e);
        }
    }
        
}