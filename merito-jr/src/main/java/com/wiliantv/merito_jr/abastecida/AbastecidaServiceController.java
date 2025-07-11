package com.wiliantv.merito_jr.abastecida;

import com.wiliantv.merito_jr.bomba.BombaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AbastecidaServiceController {

    private final AbastecidaService service;
    private final BombaService bombaService;


    public Abastecida create(AbastecidaRequest request) {
        return service.create(requestToModel(request));
    }


    public Page<Abastecida> getAll( Pageable pageable) {
        return service.getAll(pageable);
    }


    public Abastecida getById(UUID id) {
        return service.getById(id);
    }


    public Abastecida update(UUID id, AbastecidaRequest request) {
        return service.update(id, requestToModel(request));
    }


    public void delete(UUID id) {
        service.delete(id);
    }

    public  Abastecida requestToModel(AbastecidaRequest request) {
        Abastecida abastecida = new Abastecida();
        abastecida.setDataHoraAbastecida(request.getDataHoraAbastecida());
        abastecida.setQuantidade(request.getQuantidade());
        abastecida.setValor(request.getValor());

        Optional.ofNullable(request.getBombaId()).ifPresent(id -> abastecida.setBomba(bombaService.getById(id)));

        return abastecida;
    }
}
