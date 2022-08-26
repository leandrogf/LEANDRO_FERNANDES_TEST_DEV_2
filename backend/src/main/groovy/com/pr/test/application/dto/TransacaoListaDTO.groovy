package com.pr.test.application.dto

import com.pr.test.application.interfaces.IEntityTransform
import com.pr.test.domain.Transacao

class TransacaoListaDTO implements  IEntityTransform<Transacao> {
    private long idConta
    private Date dataHora;
    private String historico;
    private double valor;
    private double saldoAnterior

    TransacaoListaDTO(){
    }

    TransacaoListaDTO(Transacao transacao){
        this.idConta = transacao.getContaBancaria().getId();
        this.dataHora = transacao.getDataHora();
        this.historico = transacao.getHistorico();
        this.valor = transacao.getValor();
        this.saldoAnterior = transacao.getSaldoAnterior();
    }

    long getIdConta() {
        return idConta
    }

    void setIdConta(long idConta) {
        this.idConta = idConta
    }

    Date getDataHora() {
        return dataHora
    }

    void setDataHora(Date dataHora) {
        this.dataHora = dataHora
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
        return  new Transacao(this.idConta, dataHora, historico, valor, saldoAnterior );
    }
}
