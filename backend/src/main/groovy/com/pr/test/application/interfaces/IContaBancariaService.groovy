package com.pr.test.application.interfaces

import com.pr.test.application.dto.ClienteDTO
import com.pr.test.application.dto.ContaBancariaDTO
import com.pr.test.application.TipoTransacao
import com.pr.test.application.dto.TransacaoListaDTO
import com.pr.test.domain.Transacao

interface IContaBancariaService extends IReadonlyService<ContaBancariaDTO> {
    ContaBancariaDTO AbrirConta(ClienteDTO cliente);

    TransacaoListaDTO doTransacao(TipoTransacao tipo, long idConta, double valor, String historico);
    TransacaoListaDTO Debitar(long  idConta, double valor, String historico) ;
    TransacaoListaDTO Creditar(long idConta, double valor, String historico);
    TransacaoListaDTO[] Transferir(long idConta, long idContaDestino, double valor);
}