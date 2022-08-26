package com.pr.test.infrastructure.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

import com.pr.test.domain.Cliente
import com.pr.test.domain.ContaBancaria

@Repository
interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
	@Query(value = "SELECT count(c.Id) > 0 FROM ContaBancaria c WHERE c.conta = :nc")
	boolean isContaExiste(@Param("nc") String numeroConta);
}
