package com.albenyuan.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Alben Yuan
 * @Date 2018-05-04 17:21
 */
public class BaseEntity<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = -6809503779486640584L;

    protected ID id;

    protected Date createDate;

    protected Date updateDate;


    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public int hashCode() {
        return null == this.id ? 0 : this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return null == this.id ? null == obj : this.id.equals(obj);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseEntity{");
        sb.append("id=").append(id);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }
}
