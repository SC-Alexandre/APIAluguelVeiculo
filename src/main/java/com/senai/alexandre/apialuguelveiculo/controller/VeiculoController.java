package com.senai.alexandre.apialuguelveiculo.controller;

import com.senai.alexandre.apialuguelveiculo.entity.Cliente;
import com.senai.alexandre.apialuguelveiculo.entity.Veiculo;
import com.senai.alexandre.apialuguelveiculo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Veiculo")
@CrossOrigin("*")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.findAll();
    }

    @PostMapping
    public Veiculo saveVeiculo(@RequestBody Veiculo veiculo){
        return veiculoService.save(veiculo);
    }

    @PutMapping
    public Veiculo updateVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.update(veiculo);
    }

    @DeleteMapping("/{id}")
    public void deleteVeiculo(@PathVariable Integer id) {
        this.veiculoService.delete(id);
    }
}
