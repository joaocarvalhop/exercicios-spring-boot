package br.com.joaocarvalhop.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaocarvalhop.exerciciossb.model.entities.Cliente;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

	// não precisa mais usar "/clientes/qualquer" pq já está mapeada a classe para
	// /clientes
	@GetMapping(path = "/qualquer")
	public Cliente obterCliente() {
		return new Cliente(28, "Pedro", "123.456.789-00");
	}

	// {} significa que o id pode ser qualquer número
	@GetMapping("/{id}")
	public Cliente ObterClientePorId1(@PathVariable int id) {
		return new Cliente(id, "Maria", "987.654.321-00");
	}

	// agora ele vai acessar o id em /clientes?id=...
	// se não passar nenhum parametro ele vai por padrao em 1
	@GetMapping
	public Cliente ObterClientePorId2(@RequestParam(name = "id", defaultValue = "1") int id) {
		return new Cliente(id, "Joao", "123.456.789-00");
	}
}
