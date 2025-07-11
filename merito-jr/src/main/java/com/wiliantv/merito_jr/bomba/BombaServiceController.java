package com.wiliantv.merito_jr.bomba;

import com.wiliantv.merito_jr.combustivel.CombustivelService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BombaServiceController {

    private final BombaService service;
    private final CombustivelService repository;


    public Bomba create(BombaRequest request) {
        return service.create(requestToModel(request));
    }


    public Page<Bomba> getAll( Pageable pageable) {
        return service.getAll(pageable);
    }


    public Bomba getById(Long id) {
        return service.getById(id);
    }


    public Bomba update(Long id, BombaRequest BombaRequest) {
        return service.update(id, requestToModel(BombaRequest));
    }


    public void delete(Long id) {
        service.delete(id);
    }

    public  Bomba requestToModel(BombaRequest BombaRequest) {
        Bomba bomba = new Bomba();
        bomba.setNome(BombaRequest.getNome());
        Optional.ofNullable(BombaRequest.getCombustivel_id()).ifPresent(id -> bomba.setCombustivel(repository.getById(id)));

        return bomba;
    }
}
