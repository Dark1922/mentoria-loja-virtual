package com.mentoria.lojavirtual.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pessoa_fisica")
//@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Pessoa implements Serializable {

    @Column(nullable = false)
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
