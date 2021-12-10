package br.com.joaocarvalhop.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaocarvalhop.exerciciossb.models.Cliente;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

	// não precisa mais usar "/clientes/qualquer" pq já está mapeada a classe para /clientes
	@GetMapping(path = "/qualquer")
	public Cliente obterCliente() {
		return new Cliente(28, "Pedro", "123.456.789-00");
	}
}
