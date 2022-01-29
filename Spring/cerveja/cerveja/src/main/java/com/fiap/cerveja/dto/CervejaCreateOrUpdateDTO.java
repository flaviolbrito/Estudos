package com.fiap.cerveja.dto;

import java.time.LocalDate;

public class CervejaCreateOrUpdateDTO {
    private String nome;
    private Tipo tipo;
    private LocalDate vencimento;

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
