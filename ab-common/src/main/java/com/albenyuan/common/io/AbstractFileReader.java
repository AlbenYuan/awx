package com.albenyuan.common.io;

import java.io.File;

/**
 * @Author Alben Yuan
 * @Date 2018-01-15 09:23
 */

public abstract class AbstractFileReader {

    protected File file;

    private AbstractFileReader() {

    }

    protected AbstractFileReader(String path) {
        this(new File(path));
    }

    protected AbstractFileReader(File file) {
        this.file = file;
    }

}
