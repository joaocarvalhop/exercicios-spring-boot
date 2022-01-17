package br.com.joaocarvalhop.exerciciossb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaocarvalhop.exerciciossb.model.entities.Produto;
import br.com.joaocarvalhop.exerciciossb.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping
	public @ResponseBody Produto novoProduto(@Valid Produto produto1) {
		produtoRepository.save(produto1);
		return produto1;
	}

	@GetMapping
	public Iterable<Produto> obterProduto() {
		return produtoRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Produto> obterPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}

}
