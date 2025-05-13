package com.senai.alexandre.apialuguelveiculo.repository;

import com.senai.alexandre.apialuguelveiculo.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Integer> {
}
