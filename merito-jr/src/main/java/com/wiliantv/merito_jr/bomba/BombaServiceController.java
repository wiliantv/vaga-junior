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
    private final CombustivelService combustivelService;


    public Bomba create(BombaRequest request) {
        return service.create(requestToModel(request));
    }


    public Page<Bomba> getAll( Pageable pageable) {
        return service.getAll(pageable);
    }


    public Bomba getById(Long id) {
        return service.getById(id);
    }


    public Bomba update(Long id, BombaRequest request) {
        return service.update(id, requestToModel(request));
    }


    public void delete(Long id) {
        service.delete(id);
    }

    public  Bomba requestToModel(BombaRequest request) {
        Bomba bomba = new Bomba();
        bomba.setNome(request.getNome());
        Optional.ofNullable(request.getCombustivelId()).ifPresent(id -> bomba.setCombustivel(combustivelService.getById(id)));

        return bomba;
    }
}
