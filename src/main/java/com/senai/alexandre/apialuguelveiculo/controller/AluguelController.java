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

    @GetMapping
    public List<Aluguel> getAllAlugueis() {
        return aluguelService.findAll();
    }

    @PostMapping
    public Aluguel saveAluguel(@RequestBody Aluguel aluguel){
        return aluguelService.save(aluguel);
    }

    @PutMapping
    public Aluguel updateAluguel(@RequestBody Aluguel aluguel) {
        return aluguelService.update(aluguel);
    }

    @DeleteMapping("/{id}")
    public void deleteAluguel(@PathVariable Integer id) {
        this.aluguelService.delete(id);
    }
}
