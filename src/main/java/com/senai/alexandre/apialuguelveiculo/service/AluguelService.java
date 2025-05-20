package com.senai.alexandre.apialuguelveiculo.service;

import com.senai.alexandre.apialuguelveiculo.entity.Aluguel;
import com.senai.alexandre.apialuguelveiculo.entity.Veiculo;
import com.senai.alexandre.apialuguelveiculo.repository.AluguelRepository;
import com.senai.alexandre.apialuguelveiculo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Aluguel registrarAluguel(Aluguel aluguel) {
        Integer veiculoId = aluguel.getVeiculo().getId();

        Veiculo veiculo = veiculoRepository.findById(veiculoId)
                .orElseThrow(() -> new RuntimeException("Veículo com ID " + veiculoId + " não encontrado."));

        if (!veiculo.isDisponivel()) {
            throw new RuntimeException("Veículo com ID " + veiculoId + " está indisponível para aluguel.");
        }

        veiculo.setDisponivel(false);
        veiculoRepository.save(veiculo);

        return aluguelRepository.save(aluguel);
    }


    public Aluguel devolverVeiculo(Integer id) {
        Optional<Aluguel> aluguelOpt = aluguelRepository.findById(id);
        if (!aluguelOpt.isPresent()) {
            throw new RuntimeException("Aluguel não encontrado");
        }
        Aluguel aluguel = aluguelOpt.get();
        if (aluguel.getDataInicio() != null) {
            throw new RuntimeException("Veículo já foi devolvido");
        }
        aluguel.setDataFim(LocalDate.now());

        Veiculo veiculo = aluguel.getVeiculo();
        veiculo.setDisponivel(true);
        veiculoRepository.save(veiculo);

        return aluguelRepository.save(aluguel);
    }

    public List<Aluguel>findAll(){
        return this.aluguelRepository.findAll();
    }

    public List<Aluguel> findAlugueisAtivos() {
        return aluguelRepository.findByDataDevolucaoIsNull();
    }

}
