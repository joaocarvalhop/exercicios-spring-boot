package br.com.joaocarvalhop.exerciciossb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaocarvalhop.exerciciossb.model.entities.Produto;
import br.com.joaocarvalhop.exerciciossb.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	public @ResponseBody Produto novoProduto(@RequestParam Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}

}
