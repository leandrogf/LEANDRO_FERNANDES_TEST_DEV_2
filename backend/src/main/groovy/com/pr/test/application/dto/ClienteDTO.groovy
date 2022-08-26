package com.pr.test.application.dto

import com.pr.test.application.interfaces.IEntityTransform
import com.pr.test.domain.Cliente
import org.hibernate.validator.constraints.br.CPF

import javax.validation.constraints.NotEmpty

class ClienteDTO implements IEntityTransform<Cliente> {


    @CPF
    String cpf;
    @NotEmpty
    String nome;

    ClienteDTO(){

    }

    ClienteDTO(Cliente cliente){
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
    }

    ClienteDTO(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }

    @Override
    public Cliente ToEntity(){
        return  new Cliente(cpf,nome);
    }
    String getCpf() {
        return cpf
    }

    void setCpf(String cpf) {
        this.cpf = cpf.replaceAll(/[^0-9]/,"")
    }

    String getNome() {
        return nome
    }

    void setNome(String nome) {
        this.nome = nome
    }
}
