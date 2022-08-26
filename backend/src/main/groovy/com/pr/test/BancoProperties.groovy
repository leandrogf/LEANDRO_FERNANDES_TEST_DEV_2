package com.pr.test

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("app.banco")
public class BancoProperties {
	private String nome = "Banco Progress Rail";
	private String agencia = "0001";
}
