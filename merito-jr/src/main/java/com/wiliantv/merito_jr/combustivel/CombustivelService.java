package com.wiliantv.merito_jr.combustivel;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CombustivelService {
    private final CombustivelRepository repository;

    public Combustivel create(Combustivel combustivel) {

        return repository.save(combustivel);
    }

    public Combustivel getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Combustivel não encontrado"));
    }

    public Combustivel update(Long id, Combustivel combustivel) {

        Combustivel byId = getById(id);

        Optional.ofNullable(combustivel.getNome()).filter(n -> !n.isBlank()).ifPresent(byId::setNome);
        Optional.ofNullable(combustivel.getPreco()).ifPresent(byId::setPreco);

        return repository.save(combustivel);

    }

    public Page<Combustivel> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }


}
