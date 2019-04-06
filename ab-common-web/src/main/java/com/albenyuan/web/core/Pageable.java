package com.albenyuan.web.core;

import java.io.Serializable;

/**
 * @Author Alben Yuan
 * @Date 2018-05-19 20:36
 */
public class Pageable implements Serializable, Cloneable {

    private int page = 1; // 页码，

    private int size = 20;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Pageable next() {
        Pageable pageable = null;
        try {
            pageable = (Pageable) super.clone();
            pageable.page++;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return pageable;
    }

    public static void main(String[] args) {
        Pageable pageable = new Pageable();
        System.out.println(pageable);
        System.out.println(pageable.next());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pageable {");
        sb.append("page=").append(page);
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }
}
