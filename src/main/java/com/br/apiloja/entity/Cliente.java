package com.br.apiloja.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente extends Pessoa{

    @NotBlank(message = "Address is mandatory!")
    private String address;

    @NotBlank(message = "Phone is mandatory!")
    private String phone;
}
