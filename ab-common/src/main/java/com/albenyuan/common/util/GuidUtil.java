package com.albenyuan.common.util;

import java.util.UUID;

/**
 * @Author Alben Yuan
 * @Date 2017-12-25 13:24
 */

public class GuidUtil {

    public static final Integer DEFAULT_LENGTH = 32;

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String uuid(Integer length) {
        if (DEFAULT_LENGTH.compareTo(length) == -1) {
            throw new RuntimeException("length:" + length + ", large than " + DEFAULT_LENGTH);
        }
        String uuid = "";
        char[] chars = UUID.randomUUID().toString().replace("-", "").toCharArray();
        for (char c : chars) {
            uuid += c;
        }
        return uuid;
    }


}
