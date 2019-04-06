package com.albenyuan.rmi;

import java.rmi.RemoteException;

/**
 * @Author Alben Yuan
 * @Date 2018-08-14 16:57
 */
public interface GenericRemoteService {
    Object doService(String serviceName, String methodName, Object[] args) throws RemoteException;
}
