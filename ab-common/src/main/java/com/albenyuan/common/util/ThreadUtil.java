package com.albenyuan.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-05-22 08:31
 */
public class ThreadUtil {

    private static final Logger logger = LoggerFactory.getLogger(ThreadUtil.class);


    private ThreadUtil() {

    }

    public static void join(Thread thread) {
        if (null != thread) {
            try {
                thread.join();
            } catch (InterruptedException ignore) {
                logger.debug(ignore.getMessage(), ignore);
            }
        }
    }

    public static void join(Thread thread, long millis) {
        if (null != thread) {
            try {
                thread.join(millis);
            } catch (InterruptedException ignore) {
                logger.debug(ignore.getMessage(), ignore);
            }
        }
    }


    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignore) {
            logger.debug(ignore.getMessage(), ignore);
        }
    }

}
