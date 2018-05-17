package com.albenyuan.web.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-05-17 15:57
 */
public class InvocationInterceptor implements MethodInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvocationInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch clock = new StopWatch();
        clock.start(); // 计时开始
        Object result = invocation.proceed();
        clock.stop(); // 计时结束

        // 方法参数类型，转换成简单类型
        Class[] params = invocation.getMethod().getParameterTypes();
        String[] simpleParams = new String[params.length];
        for (int i = 0; i < params.length; i++) {
            simpleParams[i] = params[i].getSimpleName();
        }
        Object[] args = invocation.getArguments();

        LOGGER.info("[{} ms] [{}.{}({})({})] "
                , clock.getTime()
                , invocation.getThis().getClass().getName()
                , invocation.getMethod().getName()
                , StringUtils.join(simpleParams, ",")
                , StringUtils.join(args, ","));
        return result;
    }

}
