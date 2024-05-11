package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    private int id;

    private int idModelo;

    private String placa;

    private String cor;

    private boolean disponivel;

    private int ano;
}
