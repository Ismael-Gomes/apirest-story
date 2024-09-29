package com.br.apiloja.service;

import com.br.apiloja.entity.Funcionario;
import com.br.apiloja.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public boolean existeCPF(String cpf) {
        return funcionarioRepository.existsById(cpf);
    }

    public List<Funcionario> listarFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarFuncionarioPorID(String cpf){
        return funcionarioRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Funcionario não encontrado com o ID: " + cpf));
    }

    public Funcionario salvarFuncionario(Funcionario funcionario){
        if(validarFuncionario(funcionario)){
            return funcionarioRepository.save(funcionario);
        }else{
            throw new RuntimeException("Funcionario já cadastrado com esse CPF.");
        }
    }

    public void deletarFuncionarioPorID(String cpf){
        funcionarioRepository.deleteById(cpf);
    }

    private boolean validarCPFExistente(Funcionario funcionario) {
        return !existeCPF(funcionario.getCpf());
    }

    private boolean validarNome(Funcionario funcionario) {
        return !funcionario.getName().isEmpty();
    }

    private boolean validarTelefone(Funcionario funcionario) {
        return !(funcionario.getPhone().length() <= 11);
    }

    private boolean validarSalario(Funcionario funcionario) {
        return funcionario.getSalario() > 0;
    }

    private boolean validarFuncionario(Funcionario funcionario) {
        return validarCPFExistente(funcionario) && validarSalario(funcionario) && validarNome(funcionario) && validarTelefone(funcionario);
    }

    private String phone;
    private String email;
    private String birthday;
    private String sexo;
    private String cargo;
    private String senha;
}
