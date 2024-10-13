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

    public Manager listManagersByCPF(String cpf){
        return managerRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Manager not found with this CPF:" + cpf));
    }

    public void deleteManagerByCPF(String cpf){
        managerRepository.deleteById(cpf);
    }

    private boolean validateExistsCPF(Manager manager) {
        if (existsCPF(manager.getCpf())) {
            throw new RuntimeException("Employee already registered with this CPF.");
        }else{
            return true;
        }
    }
}
