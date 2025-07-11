package com.wiliantv.merito_jr.bomba;


import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/bomba")
public class BombaController {
    private final BombaServiceController service;

    @PostMapping
    public ResponseEntity<Bomba> create(BombaRequest BombaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(BombaRequest));
    }

    @GetMapping
    public ResponseEntity<Page<Bomba>> findAll(@ParameterObject Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bomba> findAll(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bomba> update(@PathVariable Long id, BombaRequest BombaRequest) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(id, BombaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
