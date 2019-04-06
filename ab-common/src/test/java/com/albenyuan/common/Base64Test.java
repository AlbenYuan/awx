package com.albenyuan.common;

import com.albenyuan.common.security.Base64Util;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-05-20 23:25
 */
public class Base64Test {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void name() throws Exception {
        String text = "123456789";
        String result = Base64Util.encode(text);
        logger.info("result:{}", result);

    }
}
