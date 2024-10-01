package com.br.apiloja.repository;

import com.br.apiloja.entity.Functionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionaryRepository extends JpaRepository <Functionary, String> {
}
