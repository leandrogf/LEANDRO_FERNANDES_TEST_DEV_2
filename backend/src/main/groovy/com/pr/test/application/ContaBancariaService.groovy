package com.pr.test.application

import com.pr.test.application.dto.ClienteDTO
import com.pr.test.application.dto.ContaBancariaDTO
import com.pr.test.application.dto.ContaBancariaListaDTO
import com.pr.test.application.dto.TransacaoListaDTO
import com.pr.test.domain.Cliente
import com.pr.test.domain.ContaBancaria
import com.pr.test.domain.Transacao
import com.pr.test.infrastructure.repository.ClienteRepository
import com.pr.test.infrastructure.repository.ContaBancariaRepository
import com.pr.test.infrastructure.repository.TransacaoRepository
import com.pr.test.application.interfaces.IContaBancariaService
import org.springframework.stereotype.Service

@Service
public class ContaBancariaService implements IContaBancariaService {

	private final ContaBancariaRepository contaBancariaRepository;
	private final ClienteRepository clienteRepository;
	private final TransacaoRepository transacaoRepository;

	private String nome = "Banco Progress Rail";
	private String agencia = "0001";

	public ContaBancariaService(ContaBancariaRepository contaBancariaRepository, ClienteRepository clienteRepository,
	TransacaoRepository transacaoRepository) {
		super();
		this.contaBancariaRepository = contaBancariaRepository;
		this.clienteRepository = clienteRepository;
		this.transacaoRepository = transacaoRepository;
	}

	private String GerarNumeroConta() {
		Random r = new Random();
		return (r.nextInt(20000 - (10000 - 1)) + 10000).toString();
	}

	@Override
	public ContaBancariaDTO AbrirConta(ClienteDTO clienteDto) {
		Cliente cliente = clienteRepository.findByCpf(clienteDto.getCpf()) ?: clienteRepository.save(clienteDto.ToEntity());
		ContaBancaria conta = contaBancariaRepository.save(new ContaBancaria(agencia, GerarNumeroConta(), cliente));
		Creditar(conta.getId(), 0, "SALDO INICIAL");
		return new ContaBancariaDTO(conta);
	}

	@Override
	TransacaoListaDTO doTransacao(TipoTransacao tipo, long idConta, double valor, String historico) {

		ContaBancaria conta = contaBancariaRepository.getReferenceById(idConta);
		String tipoNome = "";

		if(conta == null){
			throw new ServiceException("A CONTA NÃO ENCONTRADA");
		}

		if(tipo == TipoTransacao.None) {
			throw new ServiceException("A transação deve ser de Debito ou de Credito");
		}
		else if(tipo == TipoTransacao.Debito){
			tipoNome = " DÉBITO"
			if(conta.isSaldoSuficiente(valor)) {
				throw new ServiceException("A CONTA NÃO TEM SALDO SUFICIENE");
			}
		}
		else{
			tipoNome = " CRÉDITO"
		}
		
		Double v = TipoTransacao.Debito == tipo ? Math.abs(valor) * -1 : Math.abs(valor);
		
		if(historico.isBlank() && historico.isEmpty()) {
			historico = "OPERAÇÃO DE " + tipoNome;
		}
		
		//FAZ A OPERAÇÃO
		Transacao t = transacaoRepository.save(new Transacao(conta, new Date(), historico, v, conta.getSaldo() ));
		
		//ATUALIZA O SALDO DA CONTA
		conta.setSaldo(conta.getSaldo() + v);
		contaBancariaRepository.save(conta);

		return new TransacaoListaDTO(t);
	}

	@Override
	TransacaoListaDTO Debitar(long idConta, double valor, String historico = "") {
		return doTransacao(TipoTransacao.Debito, idConta, valor, historico);
	}

	@Override
	TransacaoListaDTO Creditar(long idConta, double valor, String historico = "") {
		return doTransacao(TipoTransacao.Credito, idConta, valor, historico);
	}

	@Override
	TransacaoListaDTO[] Transferir(long idConta, long idContaDestino, double valor) {
		return [
				Debitar(idConta, valor, "TRANSFERÊNCIA P/ " + idContaDestino.toString() ),
		Creditar(idContaDestino, valor, "TRANSFERÊNCIA DE " + idConta.toString() )];
	}

	@Override
	Set<ContaBancariaListaDTO> listContas() {
		Set<ContaBancaria> contas = contaBancariaRepository.findAll().toSorted();
		Set<ContaBancariaListaDTO> contasDto = new HashSet<ContaBancariaListaDTO>();
		for(ContaBancaria c in contas){
			contasDto.add(new ContaBancariaListaDTO(c));
		}
		return contasDto;
	}

	@Override
	ContaBancariaDTO dadosConta(long id) {
		def conta = contaBancariaRepository.findById(id);
        return conta.isEmpty()? null : new ContaBancariaDTO(conta.get());
	}

	Set<TransacaoListaDTO> listTransacoes(long id) {
		Set<Transacao> transacoes = transacaoRepository.transacoesPorConta(id);
		Set<TransacaoListaDTO> transacoesDto = new HashSet<TransacaoListaDTO>();
		for(Transacao t in transacoes){
			transacoesDto.add(new TransacaoListaDTO(t));
		}
		return transacoesDto;
	}
}
