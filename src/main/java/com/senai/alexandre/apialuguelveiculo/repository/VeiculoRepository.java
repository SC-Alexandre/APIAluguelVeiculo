package com.senai.alexandre.apialuguelveiculo.repository;

import com.senai.alexandre.apialuguelveiculo.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
}
