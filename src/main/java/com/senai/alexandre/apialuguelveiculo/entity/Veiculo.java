package com.senai.alexandre.apialuguelveiculo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;

    @Column(name = "dispobilidade", nullable = false)
    private boolean disponivel;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private Tipo tipo;

    public Veiculo() {
    }

    public Veiculo(Integer id, String modelo, boolean disponivel, Tipo tipo) {
        this.id = id;
        this.modelo = modelo;
        this.disponivel = disponivel;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
