package org.deanframework.component.autocoding.entity;

import java.util.List;

/**
 * @auther Dean
 */
public interface BaseRepository<E,ID> {

    int insert(E entity);

    int insertSelective(E entity);

    int insertBatch(List<E> entity);

    int updateByPrimaryKey(E entity);

    int updateByPrimaryKeySelective(E entity);

    int updateBatch(List<E> entity);

    E findByPrimaryKey(ID id);

    List<E> findByPrimaryKeys(List<ID> ids);

    List<E> findByEntity(E entity);

    E findOneByEntity(E entity);

    int deleteByPrimaryKey(ID id);

    int deleteByPrimaryKeys(List<ID> ids);
}
