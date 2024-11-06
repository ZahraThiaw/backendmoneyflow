package com.backendmycash.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean // Indique que cette interface n'est pas une vraie repository pour Spring
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {

    // Recherche par ID uniquement si isDeleted est false
    Optional<T> findByIdAndIsDeletedFalse(ID id);

    // Recherche tous les enregistrements où isDeleted est false
    List<T> findByIsDeletedFalse();
}
