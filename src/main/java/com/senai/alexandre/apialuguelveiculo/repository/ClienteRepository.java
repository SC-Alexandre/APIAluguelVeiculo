package com.senai.alexandre.apialuguelveiculo.repository;

import com.senai.alexandre.apialuguelveiculo.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
