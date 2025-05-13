package com.senai.alexandre.apialuguelveiculo.service;

import com.senai.alexandre.apialuguelveiculo.entity.Veiculo;
import com.senai.alexandre.apialuguelveiculo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo save(Veiculo veiculo) {
        return this.veiculoRepository.save(veiculo);
    }

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo update(Veiculo veiculo) {
        return this.save(veiculo);
    }

    public void delete(Integer id) {
        if (!veiculoRepository.existsById(id)) {
            throw new RuntimeException("Veiculo não encontrado para exclusão.");
        }
        this.veiculoRepository.deleteById(id);
    }
}
