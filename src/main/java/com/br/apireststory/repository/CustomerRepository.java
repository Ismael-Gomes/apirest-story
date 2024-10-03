package com.br.apireststory.repository;

import com.br.apireststory.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Override
    boolean existsById(String cpf);

}
