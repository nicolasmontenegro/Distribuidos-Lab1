package com.lab1.pkginterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TestRemote extends Remote
{
    public boolean UserLogged (String userName) throws RemoteException;
}
