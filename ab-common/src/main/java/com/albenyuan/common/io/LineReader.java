package com.albenyuan.common.io;

import java.io.File;

/**
 * @Author Alben Yuan
 * @Date 2018-01-15 09:19
 */

public abstract class LineReader extends AbstractFileReader {


    public LineReader(String path) {
        super(path);
    }

    public LineReader(File file) {
        super(file);
    }

    public void readFile() {
        this.readLine("");
    }

    abstract void readLine(String line);

}
