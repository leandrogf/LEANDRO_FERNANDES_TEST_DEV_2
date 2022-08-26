package com.pr.test.application.dto

class TransacaoTransferenciaModelDTO {
    long idContaOrigem;
    long idContaDestino;
    double valor;

    long getIdContaOrigem() {
        return idContaOrigem
    }

    void setIdContaOrigem(long idContaOrigem) {
        this.idContaOrigem = idContaOrigem
    }

    long getIdContaDestino() {
        return idContaDestino
    }

    void setIdContaDestino(long idContaDestino) {
        this.idContaDestino = idContaDestino
    }

    double getValor() {
        return valor
    }

    void setValor(double valor) {
        this.valor = valor
    }
}
