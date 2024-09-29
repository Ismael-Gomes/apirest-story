package com.br.apiloja.service;

import com.br.apiloja.entity.Gerente;
import com.br.apiloja.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenteService {
    @Autowired
    private GerenteRepository gerenteRepository;

    public boolean existeCPF(String cpf) {
        return gerenteRepository.existsById(cpf);
    }

    public List<Gerente> listarGerentes(){
        return gerenteRepository.findAll();
    }

    public Gerente buscarGerentePorID(String cpf){
        return gerenteRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Gerente não encontrado com o ID: " + cpf));
    }

    public Gerente salvarGerente(Gerente gerente){
        if(validarCPFExistente(gerente)){
            return gerenteRepository.save(gerente);
        }else{
            throw new RuntimeException("Gerente já cadastrado com esse CPF.");
        }
    }

    public void deletarGerentePorID(String cpf){
        gerenteRepository.deleteById(cpf);
    }

    private boolean validarCPFExistente(Gerente gerente) {
        return !existeCPF(gerente.getCpf());
    }
}
