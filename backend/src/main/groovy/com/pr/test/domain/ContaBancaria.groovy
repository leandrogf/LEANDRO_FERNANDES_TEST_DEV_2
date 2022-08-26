package com.pr.test.domain

import com.pr.test.domain.base.BaseEntity
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "conta_bancaria")
public class ContaBancaria extends BaseEntity {
	@NotNull
	@Column(name = "agencia")
	private String agencia;
	
	@NotNull
	@Column(name = "conta")
	private String conta;
	
	@NotNull
	@Column(name = "saldo")
	private double saldo = 0.0;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Transacao> transacoes = new HashSet<>();

	ContaBancaria(){

	}
		
	ContaBancaria(String agencia, String conta, Cliente cliente) {
		super();
		setAgencia(agencia);
		setConta(conta);
		setCliente(cliente);
	}
	
	public boolean isSaldoSuficiente(Double valorADebitar) {
		return (this.saldo - Math.abs(valorADebitar)) > 0
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void addTransacao(Transacao transacao){
		transacoes.add(transacao);
		transacao.setContaBancaria(this);
	}

	public void removeTransacao(Transacao transacao){
		transacoes.remove(transacao);
	}
}