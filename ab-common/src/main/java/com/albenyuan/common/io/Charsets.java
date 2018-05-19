package com.albenyuan.common.io;

import java.nio.charset.Charset;

/**
 * @Author Alben Yuan
 * @Date 2018-05-19 17:27
 */
public class Charsets extends org.apache.commons.io.Charsets {

    public static final Charset GBK = Charset.forName("GBK");

    public static final Charset GB2312 = Charset.forName("GB2312");

    public static final Charset GB18030 = Charset.forName("GB18030");
    
    public static final Charset DEFAULT_CHARSET = UTF_8;


}
