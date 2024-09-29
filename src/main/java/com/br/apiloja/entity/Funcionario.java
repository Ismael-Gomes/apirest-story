package com.br.apiloja.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Funcionario extends Pessoa {

    private String position;
    private String password;
    private double salary;

}
