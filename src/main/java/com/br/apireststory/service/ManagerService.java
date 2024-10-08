package com.br.apireststory.service;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public boolean existsCPF(String cpf) {
        return managerRepository.existsById(cpf);
    }

    public List<Manager> listManagers(){
        return managerRepository.findAll();
    }
}
