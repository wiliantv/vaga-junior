package com.wiliantv.merito_jr.abastecida;

import com.wiliantv.merito_jr.combustivel.Combustivel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AbastecidaService {
    private final AbastecidaRepository repository;

    public Abastecida create(Abastecida abastecida) {
        Optional<Combustivel> combustivel1 = Optional.of(abastecida.getBomba().getCombustivel());
        Optional.ofNullable(abastecida.getCombustivel()).or(() -> combustivel1).ifPresent(abastecida::setCombustivel);
        validate(abastecida);
        return repository.save(abastecida);
    }

    public Abastecida getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Abastecida não encontrado"));
    }

    public Abastecida update(UUID id, Abastecida abastecida) {

        Abastecida byId = getById(id);

        Optional.ofNullable(abastecida.getBomba()).ifPresent(byId::setBomba);

        validate(abastecida);

        return repository.save(abastecida);

    }

    private static void validate(Abastecida abastecida) {
        if(abastecida.getCombustivel() == null) throw new RuntimeException("Combustivel não pode ser nulo");
    }

    public Page<Abastecida> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void delete(UUID id) {
        repository.delete(getById(id));
    }


}
