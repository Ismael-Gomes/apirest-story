package com.br.apireststory.repository;

import com.br.apireststory.entity.Functionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionaryRepository extends JpaRepository <Functionary, String> {
}
