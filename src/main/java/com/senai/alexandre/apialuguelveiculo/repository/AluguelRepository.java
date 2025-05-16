package com.senai.alexandre.apialuguelveiculo.repository;

import com.senai.alexandre.apialuguelveiculo.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, Integer> {
    List<Aluguel> findByDataDevolucaoIsNull();
}
