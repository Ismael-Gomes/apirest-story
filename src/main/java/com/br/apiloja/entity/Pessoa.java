package com.br.apiloja.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pessoa {

    private String cpf;
    private String name;
    private String email;
    private String birthday;
    private String sex;
    private String situation;
}
