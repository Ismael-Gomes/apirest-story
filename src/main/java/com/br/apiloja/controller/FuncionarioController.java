package com.br.apiloja.controller;

import com.br.apiloja.entity.Funcionario;
import com.br.apiloja.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping("/{cpf}")
    public Funcionario buscarFuncionarioPorID(@PathVariable("cpf") String cpf){
        return funcionarioService.buscarFuncionarioPorID(cpf);
    }

    //TODO - Mesmo cpf em outras requisicoes tambem sao encontradas.
    @PostMapping
    public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario){
        if(funcionarioService.existeCPF(funcionario.getCpf())){
            throw new RuntimeException("Funcionario já existente com esse CPF.");
        } else {
            return funcionarioService.salvarFuncionario(funcionario);
        }
    }

    @DeleteMapping("/{cpf}")
    public void deletarFuncionarioPorID(@PathVariable("cpf") String cpf){
        funcionarioService.deletarFuncionarioPorID(cpf);
    }
}
