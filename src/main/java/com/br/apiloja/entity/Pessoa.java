package com.br.apiloja.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

@Entity
@Getter
@Setter
public class Pessoa {

    @Id
    private String cpf;

    @NotBlank(message = "Name is mandatory!")
    private String name;

    @Column(unique = true)
    @NotBlank(message = "E-mail is mandatory!")
    private String email;

    @NotBlank(message = "Birthday is mandatory!")
    private String birthday;

    @NotBlank(message = "Sex is mandatory!")
    private String sex;

    @NotBlank(message = "Situation is mandatory!")
    private String situation;

}
