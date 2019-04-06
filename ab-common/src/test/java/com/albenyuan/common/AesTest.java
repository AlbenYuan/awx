package com.albenyuan.common;

import com.albenyuan.common.security.AESUtil;
import com.albenyuan.common.security.Base64Util;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-05-20 23:27
 */
public class AesTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String text = "{'repairPhone':'18547854787','customPhone':'12365478965','captchav':'58m7'}";
    private String secret = "123456";
    private String password = "U2FsdGVkX19DraWmzVlw6gIC+qDP8JnOG2WP6uTrLm4=";

    @Test
    public void encrypt() throws Exception {
        byte[] result = AESUtil.encrypt(text.getBytes(), secret.getBytes());
        logger.info(" result : {}", Base64Util.encode(result));
        logger.info("password: {}", Base64Util.encode(password.getBytes()));
    }
}
