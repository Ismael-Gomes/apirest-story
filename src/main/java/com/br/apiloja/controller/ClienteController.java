package com.br.apiloja.controller;

import com.br.apiloja.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.br.apiloja.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("/{cpf}")
    public Cliente listarClientePorCPF(@PathVariable("cpf") String cpf){
        return clienteService.listarClientePorCPF(cpf);
    }

    @PostMapping
    public Cliente salvarCliente(@Validated @RequestBody Cliente cliente){
        return clienteService.salvarCliente(cliente);
    }

    @DeleteMapping("/{cpf}")
    public void deletarClientePorCPF(@PathVariable("cpf") String cpf){
        clienteService.deletarClientePorCPF(cpf);
    }

}
