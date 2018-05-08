package com.albenyuan.web.service.impl;

import com.albenyuan.entity.TreeEntity;
import com.albenyuan.repository.TreeRepository;
import com.albenyuan.web.service.TreeService;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 21:39
 */
public abstract class TreeServiceImpl<T extends TreeEntity<ID>, ID extends Serializable>
        extends StateServiceImpl<T, ID>
        implements TreeService<T, ID> {

    protected abstract TreeRepository getDao();


    @Override
    public List<T> findByParentId(ID parentId) {
        TreeRepository repository = this.getDao();
        return null;
    }
}
