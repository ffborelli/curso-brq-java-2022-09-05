package com.brq.ms01.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* @Data, que faz o papel dos Getters, Setters e toString()
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {

    private int id;
    private String nome;
    private String email;
}
