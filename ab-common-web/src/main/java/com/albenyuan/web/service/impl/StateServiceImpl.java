package com.albenyuan.web.service.impl;

import com.albenyuan.core.Page;
import com.albenyuan.entity.StateEntity;
import com.albenyuan.exception.DataNotFountException;
import com.albenyuan.repository.StateRepository;
import com.albenyuan.web.service.StateService;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 21:35
 */
public abstract class StateServiceImpl<T extends StateEntity<ID>, ID extends Serializable>
        extends BaseServiceImpl<T, ID>
        implements StateService<T, ID> {

    protected abstract StateRepository<T, ID> getDao();

    @Override
    public T findById(ID id) {
        return null;
    }

    @Override
    public T checkById(ID id) throws DataNotFountException {
        return null;
    }

    @Override
    public List<T> findByIds(Iterable<ID> ids) {
        return null;
    }

    @Override
    public Page<T> findPage(int page, int limit) {
        return null;
    }
}
