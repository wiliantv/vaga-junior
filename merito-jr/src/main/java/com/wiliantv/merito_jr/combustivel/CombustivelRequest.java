package com.wiliantv.merito_jr.combustivel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CombustivelRequest {

    private String nome;
    private BigDecimal preco;
}
