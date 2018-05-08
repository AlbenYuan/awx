package com.albenyuan.web.service.impl;

import com.albenyuan.core.PageResult;
import com.albenyuan.entity.BaseEntity;
import com.albenyuan.exception.DataNotFountException;
import com.albenyuan.repository.BaseRepository;
import com.albenyuan.web.service.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 21:30
 */
public abstract class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable> implements BaseService<T, ID> {

    protected abstract BaseRepository<T, ID> getDao();

    @Override
    public T save(T t) {
        return null;
    }

    @Override
    public Iterable<T> save(Iterable<T> iterable) {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public Iterable<T> update(Iterable<T> iterable) {
        return null;
    }

    @Override
    public boolean delete(T t) {
        return false;
    }

    @Override
    public int delete(Iterable<T> iterable) {
        return 0;
    }

    @Override
    public boolean deleteById(T t) {
        return false;
    }

    @Override
    public int deleteByIds(Iterable<ID> iterable) {
        return 0;
    }

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
    public PageResult<T> findPage(int page, int limit) {
        return null;
    }
}
