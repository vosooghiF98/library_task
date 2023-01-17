package com.mupra.task.base.service;

import com.mupra.task.base.entity.BaseEntity;

import java.util.Optional;

public interface BaseService<E extends BaseEntity> {
    E saveOrUpdate(E entity);
    void delete(E entity);
    Optional<E> loadById(Long id);
}
