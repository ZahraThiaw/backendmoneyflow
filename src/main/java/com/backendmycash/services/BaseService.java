package com.backendmycash.services;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
    T create(T entity);                       // Méthode pour créer une entité
    Optional<T> findById(ID id);              // Méthode pour retrouver une entité par son ID
    List<T> findAll();                        // Méthode pour récupérer toutes les entités
    T update(T entity);                       // Méthode pour mettre à jour une entité
    void delete(ID id);                       // Méthode pour supprimer une entité
}
