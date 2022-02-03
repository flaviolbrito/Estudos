package com.fiap.cerveja.dto;

import com.fiap.cerveja.domain.Tipo;
import com.fiap.cerveja.entity.Cerveja;

import java.time.LocalDate;

public class CervejaDTO {

    private Long id;
    private String nome;
    private Tipo tipo;
    private LocalDate vencimento;

    public CervejaDTO(){}

    public CervejaDTO(Cerveja cerveja) {
        this.id = cerveja.getId();
        this.nome = cerveja.getNome();
        this.tipo = cerveja.getTipo();
        this.vencimento = cerveja.getVencimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }
}
