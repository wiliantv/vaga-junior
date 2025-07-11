package com.wiliantv.merito_jr.abastecida;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AbastecidaRepository extends JpaRepository<Abastecida, UUID> {
}
