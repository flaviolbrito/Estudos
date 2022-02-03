package com.fiap.cerveja.entity;

import com.fiap.cerveja.domain.Tipo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_CERVEJA")
public class Cerveja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column
    private LocalDate vencimento;

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
