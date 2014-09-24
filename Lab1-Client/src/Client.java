import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

import pkginterface.*;

public class Client 
{
	private static Scanner s;

	/**
     * @param args the command line arguments
     * @throws RemoteException
     * @throws NotBoundException 
     */
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws RemoteException, NotBoundException 
	{
		Registry registry = LocateRegistry.getRegistry("localhost", Constant.RMI_PORT);
		TestRemote remote = (TestRemote) registry.lookup(Constant.RMI_ID);
		
		System.out.println(remote.UserLogged("test"));
		System.out.println(remote.UserLogged("null"));	
		try 
		{
			System.setSecurityManager(new RMISecurityManager());
			s = new Scanner(System.in);
			System.out.println("Enter Your name and press Enter:");
			String name=s.nextLine().trim();	
			ChatInterface client = new Chat(name);
			 
			ChatInterface server = (ChatInterface)Naming.lookup("rmi://localhost:222/ABC");
			String msg="["+client.getName()+"] got connected";
			server.send(msg);
			System.out.println("[System] Chat Remote Object is ready:");
			server.setClient(client);
			 
			while(true)
			{
				msg=s.nextLine().trim();
				msg="["+client.getName()+"] "+msg;	
				server.send(msg);
			}			
		}
		catch (Exception e) 
		{
			System.out.println("[System] Server failed: " + e);
		}
	}
}