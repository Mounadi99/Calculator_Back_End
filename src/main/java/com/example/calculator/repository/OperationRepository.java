package com.example.calculator.repository;


import com.example.calculator.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Result, Integer> {

    List<Result> findAll();
}
