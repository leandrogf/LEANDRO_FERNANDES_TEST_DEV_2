package com.pr.test.infrastructure.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

import com.pr.test.domain.Cliente

@Repository
interface ClienteRepository extends JpaRepository<Cliente, Long> {
	@Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
	public Cliente findByCpf(@Param("cpf") String cpf);
}
