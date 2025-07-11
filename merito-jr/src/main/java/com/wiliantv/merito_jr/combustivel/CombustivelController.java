package com.wiliantv.merito_jr.combustivel;


import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/combustiveis")
public class CombustivelController {
    private final CombustivelServiceController combustivelService;

    @PostMapping
    public ResponseEntity<Combustivel> create(CombustivelRequest combustivelRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(combustivelService.create(combustivelRequest));
    }

    @GetMapping
    public ResponseEntity<Page<Combustivel>> findAll(@ParameterObject Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(combustivelService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combustivel> findAll(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(combustivelService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Combustivel> update(@PathVariable Long id, CombustivelRequest combustivelRequest) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(combustivelService.update(id, combustivelRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        combustivelService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
