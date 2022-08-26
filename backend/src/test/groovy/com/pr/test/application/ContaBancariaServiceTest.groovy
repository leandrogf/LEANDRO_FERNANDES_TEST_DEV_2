package com.pr.test.application

import com.pr.test.application.dto.ClienteDTO
import com.pr.test.application.dto.ContaBancariaDTO
import com.pr.test.domain.Cliente
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertNotNull

@RunWith(SpringRunner.class)
@SpringBootTest
class ContaBancariaServiceTest{

    @Autowired
    ContaBancariaService contaBancariaService;

    ClienteDTO[] clientes = [
            new ClienteDTO("430.121.235-39", "Milena Josefa Bernardes"),
            new ClienteDTO("537.960.021-29", "Raquel Nicole Ramos"),
            new ClienteDTO("525.510.347-01", "Severino Bruno Dias"),
            new ClienteDTO("525.510.347-01", "Severino Bruno Dias")
    ];

    @Test
    void testAbrirConta() {

        ContaBancariaDTO[] contas;
        for(c in clientes){
            contas[] = contaBancariaService.AbrirConta(c);
        }

        assertEquals(contas.length, contaBancariaService.listContas().count());
    }

    @Test
    void testTransacao() {
//        ContaBancaria c1 = contaBancariaService.AbrirConta(clientes["milena"]);
//        ContaBancaria c2 = contaBancariaService.AbrirConta(clientes["raquel"]);
//
//        double valorDep = 1000
//        double valorEsp = c1.getSaldo() + valorDep
//
//        contaBancariaService.Creditar(c1.getId(), valorDep, "DEPÓSITO");// DEPOSITA 1.000,00 NA CONTA DA MILENA
//        assertEquals(contaBancariaService.dadosConta(c1.getId()).getSaldo(),valorEsp) // TEM QUE TER 1000 NA CONTA
//
//        contaBancariaService.Creditar(c2.getId(), 1000.0, "DEPÓSITO");// DEPOSITA 1.000,00 NA CONTA DA RAQUEL
//        assertEquals(contaBancariaService.dadosConta(c2.getId()).getSaldo(),valorEsp) //TEM QUE TER 100 NA CONTA
//
//        double valorSaq = 500;
//        ContaBancariaDTO c2Db = contaBancariaService.dadosConta(c2.getId())
//        valorEsp = c2Db.getSaldo() - valorSaq;
//        contaBancariaService.Creditar(c2.getId(), 500.0, "SAQUE");// SACA 500,00 NA CONTA DA RAQUEL
//        assertEquals(c2Db.getSaldo(),valorEsp) // TEM QUE TER 500 NA CONTA
//
//        double valorTransf = 250;
//        ContaBancariaDTO c1Db = contaBancariaService.dadosConta(c1.getId())
//        c2Db = contaBancariaService.dadosConta(c2.getId())
//        double valorEspC1 = c1Db.getSaldo() - valorTransf;
//        double valorEspC2 = c2Db.getSaldo() + valorTransf;
//        contaBancariaService.Transferir(c1Db.getId(), c2Db.getId(), valorTransf); // TRANSFERE 250 PARA CONTA DA RAQUEL
//        c1Db = contaBancariaService.dadosConta(c1.getId())
//        c2Db = contaBancariaService.dadosConta(c2.getId())
//        assertEquals(c1Db.getSaldo(),valorEspC1) // TEM QUE TER 500 NA CONTA
//        assertEquals(c2Db.getSaldo(),valorEspC2) // TEM QUE TER 500 NA CONTA
    }

    void testDebitar() {
    }

    void testTestDebitar() {
    }

    void testCreditar() {
    }

    void testTestCreditar() {
    }

    void testTransferir() {
    }

    void testListContas() {
    }

    void testDadosConta() {
    }

    void testListTransacoes() {
    }
}
