package com.br.apireststory.service;

@Service
public class FunctionaryService {
    @Autowired
    private FunctionaryRepository functionaryRepository;

    public boolean existsCPF(String cpf) {
        return functionaryRepository.existsById(cpf);
    }

    public List<Functionary> listEmployees(){
        return functionaryRepository.findAll();
    }

    public Functionary listFunctionaryByCPF(String cpf){
        return functionaryRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Employee not found with this CPF: " + cpf));
    }
}
