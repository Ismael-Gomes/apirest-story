package com.br.apireststory.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Functionary extends Person {

    @NotBlank(message = "Position is mandatory!")
    private String position;

    @NotBlank(message = "Password is mandatory!")
    private String password;

    @NotBlank(message = "Salary is mandatory!")
    private double salary;

}
