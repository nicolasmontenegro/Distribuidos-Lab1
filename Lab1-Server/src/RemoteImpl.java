

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import pkginterface.*;


public class RemoteImpl extends UnicastRemoteObject implements TestRemote
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     *
     * @throws RemoteException
     */    
    RemoteImpl () throws RemoteException
    {
        super();
    }
    
    @Override
    public boolean UserLogged (String userName) throws RemoteException
    {
        return userName.equals("test");
    }

}
