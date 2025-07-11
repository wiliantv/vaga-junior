package com.wiliantv.merito_jr.abastecida;


import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/abastecida")
public class AbastecidaController {
    private final AbastecidaServiceController service;

    @PostMapping
    public ResponseEntity<Abastecida> create(AbastecidaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<Page<Abastecida>> findAll(@ParameterObject Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abastecida> findAll(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abastecida> update(@PathVariable UUID id, AbastecidaRequest request) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
