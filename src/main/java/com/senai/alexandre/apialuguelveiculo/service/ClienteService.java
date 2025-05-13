package com.senai.alexandre.apialuguelveiculo.service;

import com.senai.alexandre.apialuguelveiculo.entity.Cliente;
import com.senai.alexandre.apialuguelveiculo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente update(Cliente cliente) {
        return this.save(cliente);
    }

    public void delete(Integer id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado para exclusão.");
        }
        this.clienteRepository.deleteById(id);
    }

}
