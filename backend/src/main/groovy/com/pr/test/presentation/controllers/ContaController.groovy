package com.pr.test.presentation.controllers

import com.pr.test.application.dto.ClienteDTO
import com.pr.test.application.dto.ContaBancariaListaDTO
import com.pr.test.application.dto.TransacaoDTO
import com.pr.test.application.ContaBancariaService
import com.pr.test.application.dto.ContaBancariaDTO
import com.pr.test.application.dto.TransacaoListaDTO
import com.pr.test.application.dto.TransacaoModelDTO
import com.pr.test.application.dto.TransacaoTransferenciaModelDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/contas")
@CrossOrigin(origins = "*")
class ContaController {
    @Autowired
    ContaBancariaService service;

    @GetMapping
    ResponseEntity<HashSet<ContaBancariaListaDTO>> getAllList(){
        return new ResponseEntity<HashSet<ContaBancariaListaDTO>>(service.listContas(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<ContaBancariaDTO> add(@RequestBody ClienteDTO cliente){
        return new ResponseEntity<ContaBancariaDTO>(service.AbrirConta(cliente),HttpStatus.OK);
    }

    @PostMapping('/creditar')
    ResponseEntity<TransacaoDTO> creditar(@RequestBody TransacaoModelDTO transacao){
        return new ResponseEntity<TransacaoDTO>(service.Creditar(transacao.getIdConta(), transacao.getValor(), transacao.getHistorico()),HttpStatus.OK);
    }

    @PostMapping('/debitar')
    ResponseEntity<TransacaoListaDTO> debitar(@RequestBody TransacaoModelDTO transacao){
        return new ResponseEntity<TransacaoListaDTO>(service.Debitar(transacao.getIdConta(), transacao.getValor(), transacao.getHistorico()),HttpStatus.OK);
    }

    @PostMapping('/transferir')
    ResponseEntity<TransacaoListaDTO[]> transferir(@RequestBody TransacaoTransferenciaModelDTO transacao){
        return new ResponseEntity<TransacaoListaDTO[]>(service.Transferir(transacao.getIdContaOrigem(), transacao.getIdContaDestino(), transacao.getValor()),HttpStatus.OK);
    }

    @GetMapping('/{idDaConta}')
    ResponseEntity<ContaBancariaDTO> getById(@PathVariable long idDaConta){
        def conta = service.dadosConta(idDaConta);

        if(conta == null)
            return new ResponseEntity<ContaBancariaDTO>(HttpStatus.NOT_FOUND);

        return  new ResponseEntity<ContaBancariaDTO>(conta,HttpStatus.OK)
    }

    @GetMapping('/{idDaConta}/transacoes')
    ResponseEntity<HashSet<TransacaoListaDTO>> getTransacoes(@PathVariable long idDaConta){
        def conta = service.dadosConta(idDaConta);

        if(conta == null)
            return new ResponseEntity<HashSet<TransacaoListaDTO>>(HttpStatus.NOT_FOUND);

        return  new ResponseEntity<HashSet<TransacaoListaDTO>>(service.listTransacoes(conta.getId()),HttpStatus.OK)
    }
}
