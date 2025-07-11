package com.wiliantv.merito_jr.combustivel;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CombustivelServiceController {

    private final CombustivelService service;


    public Combustivel create(CombustivelRequest request) {
        return service.create(requestToModel(request));
    }


    public Page<Combustivel> getAll( Pageable pageable) {
        return service.getAll(pageable);
    }


    public Combustivel getById(Long id) {
        return service.getById(id);
    }


    public Combustivel update(Long id, CombustivelRequest combustivelRequest) {
        return service.update(id, requestToModel(combustivelRequest));
    }


    public void delete(Long id) {
        service.delete(id);
    }

    public  Combustivel requestToModel(CombustivelRequest combustivelRequest) {
        Combustivel combustivel = new Combustivel();
        combustivel.setNome(combustivelRequest.getNome());
        combustivel.setPreco(combustivelRequest.getPreco());

        return combustivel;
    }
}
