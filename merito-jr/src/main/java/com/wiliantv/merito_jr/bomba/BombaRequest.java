package com.wiliantv.merito_jr.bomba;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BombaRequest {
    private String nome;
    private Long combustivel_id;
}
