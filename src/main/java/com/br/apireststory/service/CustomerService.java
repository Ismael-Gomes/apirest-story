package com.br.apireststory.service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public boolean existsCPF(String cpf) {
        return customerRepository.existsById(cpf);
    }

    public List<Customer> listClients() {
        return customerRepository.findAll();
    }

    public Customer listCustomerByCPF(String cpf) {
        return customerRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Customer not found with this CPF: " + cpf));
    }

    public Optional<Customer> updateCustomer(String cpf, Customer newData) {
        Optional<Customer> customerExists = customerRepository.findById(cpf);

        if (customerExists.isPresent()) {
            Customer customer = customerExists.get();

            customer.setName(newData.getName());
            customer.setPhone(newData.getPhone());
            customer.setAddress(newData.getAddress());
            customer.setSituation(newData.getSituation());

            customerRepository.save(customer);
            return Optional.of(customer);
        } else {
            return Optional.empty();
        }
    }

    public void deleteCustomerByCPF(String cpf) {
        customerRepository.deleteById(cpf);
    }

    private boolean validateExistsCPF(Customer customer) {
        if (existsCPF(customer.getCpf())) {
            throw new RuntimeException("Customer already registered with this CPF.");
        }else{
            return true;
        }
    }
}
