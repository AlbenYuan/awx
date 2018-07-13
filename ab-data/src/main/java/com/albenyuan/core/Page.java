package com.albenyuan.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 20:57
 */
public class Page<T extends Serializable> implements Serializable {

    private long total; // 总记录数
    private int totalPage; // 总记录数
    private int page = 1; // 页码，起始页码为1

    private int preview;
    private int next;


    private boolean hasPreview;
    private boolean hasNext;

    private List<T> data;


}
