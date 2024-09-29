package com.br.apiloja.service;

import com.br.apiloja.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.apiloja.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public boolean existeCPF(String cpf) {
        return clienteRepository.existsById(cpf);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente listarClientePorCPF(String cpf) {
        return clienteRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Cliente não encontrada com o CPF: " + cpf));
    }

    public Cliente salvarCliente(Cliente cliente) {
        if(validarCPFExistente(cliente)){
            return clienteRepository.save(cliente);
        }else{
            throw new RuntimeException("Cliente já cadastrado com esse CPF.");
        }
    }

    public void deletarClientePorCPF(String cpf) {
        clienteRepository.deleteById(cpf);
    }

    private boolean validarCPFExistente(Cliente cliente) {
        return !existeCPF(cliente.getCpf());
    }

}
