package com.albenyuan.common.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @Author Alben Yuan
 * @Date 2017-12-25 13:57
 */

public class CloseableUtil {

    private CloseableUtil() {
    }


    public static void close(Closeable... closeables) {
        for (int i = 0; i < closeables.length; i++) {
            close(closeables[i]);
        }
    }

    public static void close(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeable = null;
        }
    }
}
