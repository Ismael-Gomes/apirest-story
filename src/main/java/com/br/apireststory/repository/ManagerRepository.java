package com.br.apireststory.repository;

import com.br.apireststory.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository <Manager, String> {
    @Override
    boolean existsById(String cpf);
}
