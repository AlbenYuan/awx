package com.albenyuan.rmi.concurrent;

/**
 * @Author Alben Yuan
 * @Date 2018-08-14 16:52
 */
public interface SafeLock {

    Boolean lock(String symbolId, String target);

    Boolean release(String symbolId, String target);

}
