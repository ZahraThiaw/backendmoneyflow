package com.backendmycash.web.controllers.impl;

import com.backendmycash.services.BaseService;
import com.backendmycash.web.controllers.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractBaseController<RequestDto, ResponseDto, T, ID> implements BaseController<RequestDto, ResponseDto, ID> {

    protected BaseService<T, ID> service;

    // Méthode pour convertir RequestDto en Entity
    protected abstract T toEntity(RequestDto dto);

    // Méthode pour convertir Entity en ResponseDto
    protected abstract ResponseDto toResponseDto(T entity);

    // Constructeur ou méthode pour injecter le service dans les sous-classes
    protected AbstractBaseController(BaseService<T, ID> service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<ResponseDto> create(@RequestBody RequestDto dto) {
        T entity = toEntity(dto);
        T savedEntity = service.create(entity);
        return ResponseEntity.ok(toResponseDto(savedEntity));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable ID id) {
        Optional<T> entityOpt = service.findById(id);
        return entityOpt.map(entity -> ResponseEntity.ok(toResponseDto(entity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ResponseDto>> findAll() {
        List<T> entities = service.findAll();
        List<ResponseDto> dtos = entities.stream().map(this::toResponseDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable ID id, @RequestBody RequestDto dto) {
        T entity = toEntity(dto);
        T updatedEntity = service.update(entity);
        return ResponseEntity.ok(toResponseDto(updatedEntity));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
