package br.com.joaocarvalhop.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

	// sempre quando o usuário aperta enter no browser ele faz uma requisição do tipo get
	// path indica que quando usado o link + o /ola ele vai acessar o método ola, ou seja
	// tenho duas urls que atendem esse método, pq path é um array de String
	@GetMapping(path = {"/ola", "/saudacao"})
	public String ola() {
		return "Olá Spring Boot!";
	}
}
