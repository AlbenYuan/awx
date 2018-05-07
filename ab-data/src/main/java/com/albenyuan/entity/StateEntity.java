package com.albenyuan.entity;

import java.io.Serializable;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 20:38
 */
public class StateEntity<ID extends Serializable> extends BaseEntity<ID> {

    protected Integer state;

    protected Boolean deleted = false;

    protected String remark;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StateEntity{");
        sb.append("id=").append(id);
        sb.append(", state=").append(state);
        sb.append(", deleted=").append(deleted);
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append('}');
        return sb.toString();
    }
}
