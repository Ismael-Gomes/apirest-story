package com.br.apiloja.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pessoa {

    @Id
    private String cpf;
    private String name;
    @Column(unique = true)
    private String email;
    private String birthday;
    private String sex;
    private String situation;
}
