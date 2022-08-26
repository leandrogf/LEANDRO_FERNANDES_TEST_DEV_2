package com.pr.test.application.dto

import com.pr.test.application.interfaces.IEntityTransform
import com.pr.test.domain.Transacao

class TransacaoModelDTO implements  IEntityTransform<Transacao> {
    private long idConta
    private String historico;
    private double valor;
    private double saldoAnterior;

    TransacaoModelDTO(){
    }

    TransacaoModelDTO(Transacao transacao){
        this.idConta = transacao.getContaBancaria().getId();
        this.historico = transacao.getHistorico();
        this.valor = transacao.getValor();
    }

    long getIdConta() {
        return idConta
    }

    void setIdConta(long idConta) {
        this.idConta = idConta
    }

    String getHistorico() {
        return historico
    }

    void setHistorico(String historico) {
        this.historico = historico
    }

    double getValor() {
        return valor
    }

    void setValor(double valor) {
        this.valor = valor
    }

    double getSaldoAnterior() {
        return saldoAnterior
    }

    void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior
    }

    @Override
    Transacao ToEntity() {
        return  new Transacao(this.idConta, new Date(), historico, valor, saldoAnterior);
    }
}
