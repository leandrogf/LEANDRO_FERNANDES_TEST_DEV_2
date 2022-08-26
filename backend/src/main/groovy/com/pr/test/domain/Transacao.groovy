package com.pr.test.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OrderBy
import javax.persistence.OrderColumn
import javax.persistence.Table

import com.pr.test.domain.base.BaseEntity
import com.pr.test.domain.base.DomainException

@Entity
@Table(name = "transacao")
public class Transacao extends BaseEntity
 {
	@Column(name = "data_hora")
	@OrderColumn()
	@OrderBy
	private Date dataHora;
	
	@Column(name = "historico")
	private String historico;
	
	@Column(name = "valor")
	private double valor;

	 @Column(name = "saldo_anterior")
	 private double saldoAnterior;

	 @ManyToOne()
	@JoinColumn(name = "conta_bancaria_id", referencedColumnName = "id", nullable = false)
	private ContaBancaria contaBancaria;

	 Transacao(){

	 }

	Transacao(ContaBancaria conta,  Date dataHora, String historico, double valor, double saldoAnterior){
		super();
		setContaBancaria(conta);
		setDataHora(dataHora);
		setHistorico(historico);
		setValor(valor);
		setSaldoAnterior(saldoAnterior)
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		
		if(historico.isBlank() || historico.isEmpty()) {
			throw new DomainException("O Histórico deve ser informado");
		}
		
		this.historico = historico;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	 double getSaldoAnterior() {
		 return saldoAnterior
	 }

	 void setSaldoAnterior(double saldoAnterior) {
		 this.saldoAnterior = saldoAnterior
	 }

	 public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}
}
