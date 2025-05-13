package com.senai.alexandre.apialuguelveiculo.service;

import com.senai.alexandre.apialuguelveiculo.entity.Aluguel;
import com.senai.alexandre.apialuguelveiculo.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    public Aluguel save(Aluguel aluguel){
        return this.aluguelRepository.save(aluguel);
    }

    public List<Aluguel>findAll(){
        return this.aluguelRepository.findAll();
    }

    public Aluguel update(Aluguel aluguel){
        return this.aluguelRepository.save(aluguel);
    }

    public void delete(Integer id) {
        if (!aluguelRepository.existsById(id)) {
            throw new RuntimeException("Veiculo não encontrado para exclusão.");
        }
        this.aluguelRepository.deleteById(id);
    }

}
