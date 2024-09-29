package com.br.apiloja.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Cliente extends Pessoa{

    private String address;
    private String phone;
}
