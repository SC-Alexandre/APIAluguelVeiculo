package com.senai.alexandre.apialuguelveiculo.controller;

import com.senai.alexandre.apialuguelveiculo.entity.Aluguel;
import com.senai.alexandre.apialuguelveiculo.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Aluguel")
@CrossOrigin("*")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @PostMapping
    public void registrarAluguel(@RequestBody Aluguel aluguel) {
        aluguelService.registrarAluguel(aluguel);
    }

    @PutMapping
    public Aluguel updateAluguel(@PathVariable Integer id) {
        return aluguelService.devolverVeiculo(id);
    }

    @GetMapping("/ativos")
    public List<Aluguel> listarAlugueisAtivos() {
        return aluguelService.findAlugueisAtivos();
    }

    @GetMapping("/geral")
    public List<Aluguel> getAllAlugueis() {
        return aluguelService.findAll();
    }
}
