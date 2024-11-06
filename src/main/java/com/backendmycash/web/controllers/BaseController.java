package com.backendmycash.web.controllers;

import org.springframework.http.ResponseEntity;
import java.util.List;

public interface BaseController<RequestDto, ResponseDto, ID> {

    ResponseEntity<ResponseDto> create(RequestDto dto);

    ResponseEntity<ResponseDto> findById(ID id);

    ResponseEntity<List<ResponseDto>> findAll();

    ResponseEntity<ResponseDto> update(ID id, RequestDto dto);

    ResponseEntity<Void> delete(ID id);
}
