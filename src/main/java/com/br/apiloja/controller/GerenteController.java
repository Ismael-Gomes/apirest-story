package com.br.apiloja.controller;

import com.br.apiloja.entity.Gerente;
import com.br.apiloja.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class GerenteController {
    @Autowired
    private GerenteService gerenteService;

    @GetMapping
    public List<Gerente> listarGerentes() {
        return gerenteService.listarGerentes();
    }

    @GetMapping("/{cpf}")
    public Gerente buscarGerentePorID(@PathVariable("cpf") String cpf) {
        return gerenteService.buscarGerentePorID(cpf);
    }

    //TODO - Mesmo cpf em outras requisicoes tambem sao encontradas.
    @PostMapping
    public Gerente salvarGerente(@RequestBody Gerente gerente) {
        if(gerenteService.existeCPF(gerente.getCpf())){
            throw new RuntimeException("Gerente já existente com esse CPF.");
        } else {
            return gerenteService.salvarGerente(gerente);
        }
    }

    @DeleteMapping("/{cpf}")
    public void deletarGerentePorID(@PathVariable("cpf") String cpf) {
        gerenteService.deletarGerentePorID(cpf);
    }

}
