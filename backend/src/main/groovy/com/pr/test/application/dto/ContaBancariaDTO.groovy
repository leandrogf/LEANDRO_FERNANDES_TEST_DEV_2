package com.pr.test.application.dto

import com.pr.test.application.interfaces.IEntityTransform
import com.pr.test.domain.ContaBancaria

class ContaBancariaDTO implements  IEntityTransform<ContaBancaria> {

    long id;
    ClienteDTO cliente;
    String agencia;
    String conta;
    double saldo = 0;

    ContaBancariaDTO(){
    }

    ContaBancariaDTO(ContaBancaria contaBancaria){
        this.id = contaBancaria.getId();
        this.cliente = new ClienteDTO(contaBancaria.getCliente());
        this.agencia = contaBancaria.getAgencia();
        this.conta = contaBancaria.getConta();
        this.saldo = this.getSaldo();
    }

    long getId() {
        return id
    }

    void setId(long id) {
        this.id = id
    }

    ClienteDTO getCliente() {
        return cliente
    }

    void setCliente(ClienteDTO cliente) {
        this.cliente = cliente
    }

    String getAgencia() {
        return agencia
    }

    void setAgencia(String agencia) {
        this.agencia = agencia
    }

    String getConta() {
        return conta
    }

    void setConta(String conta) {
        this.conta = conta
    }

    double getSaldo() {
        return saldo
    }

    void setSaldo(double saldo) {
        this.saldo = saldo
    }

    @Override
    ContaBancaria ToEntity() {
        return new ContaBancaria(agencia,conta, cliente.ToEntity())
    }
}
