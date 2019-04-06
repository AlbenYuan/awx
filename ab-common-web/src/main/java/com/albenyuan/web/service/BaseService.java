package com.albenyuan.web.service;

import com.albenyuan.core.Page;
import com.albenyuan.entity.BaseEntity;
import com.albenyuan.exception.DataNotFountException;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 20:53
 */
public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> {

    T save(T t);

    Iterable<T> save(Iterable<T> iterable);

    T update(T t);

    Iterable<T> update(Iterable<T> iterable);

    boolean delete(T t);

    int delete(Iterable<T> iterable);

    boolean deleteById(T t);

    int deleteByIds(Iterable<ID> iterable);

    T findById(ID id);

    T checkById(ID id) throws DataNotFountException;

    List<T> findByIds(Iterable<ID> ids);

    Page<T> findPage(int page, int limit);


}
