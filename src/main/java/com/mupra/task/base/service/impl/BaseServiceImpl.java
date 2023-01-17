package com.mupra.task.base.service.impl;

import com.mupra.task.base.entity.BaseEntity;
import com.mupra.task.base.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
public class BaseServiceImpl<E extends BaseEntity ,R extends JpaRepository<E,Long>> implements BaseService<E> {
    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public E saveOrUpdate(E entity) {
        try {
            log.info("save/update");
            repository.save(entity);
            log.debug("save/update is successfully");
        }catch (Exception e){
            log.error("error for save/update");
        }
        return entity;
    }

    @Override
    @Transactional
    public void delete(E entity) {
        try {
            log.info("delete");
            repository.delete(entity);
            log.debug("delete is successfully");
        }catch (Exception e){
            log.error("error for delete");
        }
    }

    @Override
    public Optional<E> loadById(Long id) {
        log.info("load by id");
        return repository.findById(id);
    }
}
