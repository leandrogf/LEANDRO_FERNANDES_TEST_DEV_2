package com.pr.test.domain

import org.hibernate.validator.constraints.br.CPF

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.OrderBy
import javax.persistence.OrderColumn
import javax.persistence.Table

import org.springframework.lang.NonNull

import com.pr.test.domain.base.BaseEntity
import com.pr.test.domain.base.DomainException

import groovyjarjarantlr4.v4.runtime.misc.NotNull

@Entity
@Table(name = "cliente")
class Cliente extends BaseEntity {

	@NonNull
	@Column(name = "cpf")
	@CPF
	private String cpf;

	@NotNull
	@Column(name = "nome")
	@OrderColumn()
	@OrderBy
	private String nome;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ContaBancaria> Contas = new HashSet<>();

	Cliente() {

	}

	public Cliente(String cpf, String nome){
		super();
		this.setCpf(cpf);
		this.setNome(nome);
	}

//	public static boolean isCPF(String cpf) {
//		// considera-se erro CPF's formados por uma sequencia de numeros iguais
//		if (cpf.equals("00000000000") ||
//				cpf.equals("11111111111") ||
//				cpf.equals("22222222222") || cpf.equals("33333333333") ||
//				cpf.equals("44444444444") || cpf.equals("55555555555") ||
//				cpf.equals("66666666666") || cpf.equals("77777777777") ||
//				cpf.equals("88888888888") || cpf.equals("99999999999") ||
//				(cpf.length() != 11))
//			return(false);
//
//		char dig10, dig11;
//		int sm, i, r, num, peso;
//
//		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
//		try {
//			// Calculo do 1o. Digito Verificador
//			sm = 0;
//			peso = 10;
//			for (i=0; i<9; i++) {
//				// converte o i-esimo caractere do CPF em um numero:
//				// por exemplo, transforma o caractere '0' no inteiro 0
//				// (48 eh a posicao de '0' na tabela ASCII)
//				num = (int)(cpf.charAt(i) - 48);
//				sm = sm + (num * peso);
//				peso = peso - 1;
//			}
//
//			r = 11 - (sm % 11);
//			if ((r == 10) || (r == 11))
//				dig10 = '0';
//			else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
//
//			// Calculo do 2o. Digito Verificador
//			sm = 0;
//			peso = 11;
//			for(i=0; i<10; i++) {
//				num = (int)(cpf.charAt(i) - 48);
//				sm = sm + (num * peso);
//				peso = peso - 1;
//			}
//
//			r = 11 - (sm % 11);
//			if ((r == 10) || (r == 11))
//				dig11 = '0';
//			else dig11 = (char)(r + 48);
//
//			// Verifica se os digitos calculados conferem com os digitos informados.
//			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
//				return(true);
//			else return(false);
//		} catch (InputMismatchException erro) {
//			return(false);
//		}
//	}
//
//
//	public String getCpf() {
//		return cpf;
//	}

//	public void setCpf(String cpf) {
//
//		if(cpf.isBlank() || cpf.isEmpty()) {
//			throw new DomainException("O CPF deve ser informado");
//		}
//
//		if(!isCPF(cpf)) {
//			throw new DomainException("CPF Inválido");
//		}
//
//		this.cpf = cpf;
//	}

//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//
//		if(nome.isBlank() || nome.isEmpty()) {
//			throw new DomainException("O Nome deve ser informado");
//		}
//
//		this.nome = nome;
//	}
	@NonNull
	String getCpf() {
		return cpf
	}

	void setCpf(@NonNull String cpf) {
		this.cpf = cpf.replaceAll(/[^0-9]/,"").toString()
	}

	String getNome() {
		return nome
	}

	void setNome(String nome) {
		this.nome = nome
	}

	public void addConta(ContaBancaria obj){
		Contas.add(obj);
		obj.setCliente(this);
	}

	public void removeConta(ContaBancaria obj){
		Contas.remove(obj);
	}
}
