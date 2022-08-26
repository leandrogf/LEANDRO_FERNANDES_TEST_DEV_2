package com.pr.test.application.dto

import com.pr.test.application.interfaces.IEntityTransform
import com.pr.test.domain.Transacao

class TransacaoDTO  implements  IEntityTransform<Transacao> {
    ContaBancariaDTO conta;
    private Date dataHora;
    private String historico;
    private double valor;
    private double saldoAnterior;

    TransacaoDTO(){
    }

    TransacaoDTO(Transacao transacao){
        this.conta = new ContaBancariaDTO(transacao.getContaBancaria());
        this.dataHora = transacao.getDataHora();
        this.historico = transacao.historico;
        this.valor = transacao.getValor();
        this.saldoAnterior = transacao.getSaldoAnterior();
    }

    ContaBancariaDTO getConta() {
        return conta
    }

    void setConta(ContaBancariaDTO conta) {
        this.conta = conta
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
        return new Transacao(conta.ToEntity(), dataHora, historico, valor, saldoAnterior);
    }
}
