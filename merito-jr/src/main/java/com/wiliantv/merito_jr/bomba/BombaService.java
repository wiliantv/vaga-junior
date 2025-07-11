package com.wiliantv.merito_jr.bomba;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BombaService {
    private final BombaRepository repository;

    public Bomba create(Bomba bomba) {
        validate(bomba);
        return repository.save(bomba);
    }

    public Bomba getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Bomba não encontrado"));
    }

    public Bomba update(Long id, Bomba bomba) {

        Bomba byId = getById(id);

        Optional.ofNullable(bomba.getNome()).filter(n -> !n.isBlank()).ifPresent(byId::setNome);
        Optional.ofNullable(bomba.getCombustivel()).ifPresent(byId::setCombustivel);

        validate(bomba);

        return repository.save(bomba);

    }

    private static void validate(Bomba bomba) {
        if(bomba.getCombustivel() == null) throw new RuntimeException("Combustivel não pode ser nulo");
    }

    public Page<Bomba> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }


}
