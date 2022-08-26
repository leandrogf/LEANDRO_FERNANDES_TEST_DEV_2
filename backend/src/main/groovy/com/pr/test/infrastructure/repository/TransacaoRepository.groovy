package com.pr.test.infrastructure.repository


import com.pr.test.domain.Transacao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    @Query(value = "SELECT t FROM Transacao t WHERE t.contaBancaria.Id = :id ORDER BY t.dataHora")
    HashSet<Transacao> transacoesPorConta(@Param("id") long idDaConta);
}
