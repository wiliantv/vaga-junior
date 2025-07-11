package com.wiliantv.merito_jr.abastecida;

import com.wiliantv.merito_jr.bomba.Bomba;
import com.wiliantv.merito_jr.combustivel.Combustivel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Abastecida {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "bomba_id")
    private Bomba bomba;
    @ManyToOne
    @JoinColumn(name = "combustivel_id")
    private Combustivel combustivel;
    private Integer quantidade;
    private BigDecimal valor;
    private LocalDateTime dataHoraAbastecida;
}
