package br.com.joaocarvalhop.exerciciossb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaocarvalhop.exerciciossb.model.entities.Produto;
import br.com.joaocarvalhop.exerciciossb.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	// @PostMapping
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Produto salvarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}

	@GetMapping
	public Iterable<Produto> obterProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Produto> obterPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}

	// requisição do tipo put é usada para alterar todos os dados
	// se quiser só alterar o nome, preco ou desconto é a req path
	// @PutMapping
	// public Produto alterarProduto(@Valid Produto produto) {
	// produtoRepository.save(produto);
	// return produto;
	// }

	@DeleteMapping(path = "/{id}")
	public void excluirProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}

	@GetMapping(path = "/pagina/{numPagina}")
	public Iterable<Produto> obterPorPagina(@PathVariable int numPagina) {
		Pageable page = PageRequest.of(numPagina, 3);
		return produtoRepository.findAll(page);
	}

	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
		return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
	}

}
