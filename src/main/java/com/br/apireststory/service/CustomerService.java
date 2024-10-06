package com.br.apireststory.service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public boolean existsCPF(String cpf) {
        return customerRepository.existsById(cpf);
    }
}
