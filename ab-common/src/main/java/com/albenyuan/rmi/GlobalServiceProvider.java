package com.albenyuan.rmi;

import com.albenyuan.rmi.concurrent.SafeLock;

/**
 * @Author Alben Yuan
 * @Date 2018-08-14 16:49
 */
public class GlobalServiceProvider {


    private String host = "127.0.0.1";
    private int port = 1109;
    private final String LOCK_ORDER = "order";
    private final String LOCK_COUPON = "coupon";
    private final String LOCK_OTHER = "other";

    private SafeLock getSafeLock() {
        try {
            return GlobalProxyFactory.getProxy(SafeLock.class, host, port);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}
