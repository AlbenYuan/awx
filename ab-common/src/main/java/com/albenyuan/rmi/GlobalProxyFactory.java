package com.albenyuan.rmi;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author Alben Yuan
 * @Date 2018-08-14 16:48
 */
public class GlobalProxyFactory {

    private static final ConcurrentMap<String, Object> PROXY_CACHE = new ConcurrentHashMap<String, Object>();

    private static final String SERVICE_NAME = "SERVICENAME";


    /**
     * 清空缓存
     */
    public static void clearProxyCache() {
        PROXY_CACHE.clear();
    }

    public static <T> T getProxy(Class<T> clazz, String host, int port) throws Exception {

        String serviceName = getServiceName(clazz);
        if (PROXY_CACHE.containsKey(serviceName)) {
            return (T) PROXY_CACHE.get(serviceName);
        }
        GenericRemoteService rmiService = (GenericRemoteService) Naming.lookup("rmi://" + host + ":" + port + "/GenericRemoteService");
        InvocationHandler h = new InvocationHandler(serviceName, rmiService);
        Object proxy = Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, h);
        PROXY_CACHE.put(serviceName, proxy);
        return (T) proxy;
    }

    private static <T> String getServiceName(Class<T> clazz) throws IllegalArgumentException, IllegalAccessException {
        Field[] fs = clazz.getFields();
        for (Field f : fs) {
            if (SERVICE_NAME.equals(f.getName())) {
                return (String) f.get(null);
            }
        }

        return clazz.getName();
    }

    static class InvocationHandler implements java.lang.reflect.InvocationHandler {
        private String serviceName;
        private GenericRemoteService genericRemoteService;

        public InvocationHandler(String serviceName, GenericRemoteService genericRemoteService) {
            this.serviceName = serviceName;
            this.genericRemoteService = genericRemoteService;
        }

        public Object invoke(Object proxy, Method method, Object[] args) {
            Object r = null;
            try {
                r = genericRemoteService.doService(serviceName, method.getName(), args);

            } catch (Exception e) {
                clearProxyCache();
                throw new RuntimeException(e.getMessage(), e);
            }

            return r;
        }
    }
}
