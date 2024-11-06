package com.backendmycash.services.impl;

import com.backendmycash.data.entities.BaseEntity;
import com.backendmycash.data.repositories.BaseRepository;
import com.backendmycash.services.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public abstract class AbstractBaseService<T extends BaseEntity, ID> implements BaseService<T, ID> {

    protected final BaseRepository<T, ID> repository;

    protected AbstractBaseService(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findByIdAndIsDeletedFalse(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findByIsDeletedFalse();
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(ID id) {
        Optional<T> entityOpt = repository.findById(id);
        entityOpt.ifPresent(entity -> {
            entity.setDeleted(true);  // Marquer comme supprimé
            repository.save(entity);
        });
    }
}
