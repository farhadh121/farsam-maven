package com.radio.svc.dalc;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: farhad
 * Date: 5/10/12
 * Time: 9:23 AM
 * To change this template use CommonFile | Settings | CommonFile Templates.
 */
public interface IGenericDA<TEntity, TId extends Serializable>
{
    TEntity get(TId id);
    List<TEntity> get();
    List<TEntity> get(long from, long size);
    List<TEntity> get(int from, int size);
    Object getProperty(Long id, String property);
    long getCount();
    TEntity insert(TEntity entity);
    TEntity update(TEntity entity);
    void delete(TId id);
    void delete(TEntity entity);

}
