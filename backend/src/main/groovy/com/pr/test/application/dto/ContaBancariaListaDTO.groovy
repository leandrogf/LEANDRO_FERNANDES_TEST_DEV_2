package com.pr.test.application.dto

import com.pr.test.application.interfaces.IEntityTransform
import com.pr.test.domain.ContaBancaria

class ContaBancariaListaDTO implements  IEntityTransform<ContaBancaria> {

    private long id;
    private String nomeCliente;
    private String numeroAgencia;
    private String numeroConta;
    private double saldo = 0;

    ContaBancariaListaDTO(){
    }

    ContaBancariaListaDTO(ContaBancaria contaBancaria){
        this.id = contaBancaria.getId();
        this.nomeCliente = contaBancaria.getCliente().getNome();
        this.numeroAgencia = contaBancaria.getAgencia();
        this.numeroConta = contaBancaria.getConta();
        this.saldo = this.getSaldo();
    }

    long getId() {
        return id
    }

    void setId(long id) {
        this.id = id
    }

    String getNomeCliente() {
        return nomeCliente
    }

    void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente
    }

    String getNumeroAgencia() {
        return numeroAgencia
    }

    void setNumeroAgencia(String agencia) {
        this.numeroAgencia = agencia
    }

    String getNumeroConta() {
        return numeroConta
    }

    void setNumeroConta(String conta) {
        this.numeroConta = conta
    }

    double getSaldo() {
        return saldo
    }

    void setSaldo(double saldo) {
        this.saldo = saldo
    }

    @Override
    ContaBancaria ToEntity() {
        return new ContaBancaria(numeroAgencia,numeroConta, cliente.ToEntity())
    }
}
