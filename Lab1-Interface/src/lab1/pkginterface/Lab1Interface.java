package lab1.pkginterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Lab1Interface extends Remote
{
    public boolean UserLogged (String userName) throws RemoteException;
}
