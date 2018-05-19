package com.albenyuan.common;

import com.albenyuan.common.security.EncodeUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @Author Alben Yuan
 * @Date 2018-05-19 15:37
 */
public class EncodeUtilTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void parseByte2Hex() throws Exception {
        byte[] bytes = {Byte.MIN_VALUE, Byte.MIN_VALUE + 17, -2, -1, 00, 1, 2, Byte.MAX_VALUE, Byte.MAX_VALUE - 1};
        logger.info("HEX: {}", EncodeUtil.parseByte2Hex(bytes));
    }

    @Test
    public void parseHex2Bytes() throws Exception {
        logger.info("bytes: {}", Arrays.toString(EncodeUtil.parseHex2Byte("FF")));
    }

}
