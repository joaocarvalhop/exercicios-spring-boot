package br.com.joaocarvalhop.exerciciossb.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.joaocarvalhop.exerciciossb.model.entities.Produto;

// Essa classe é responsável por abstrair os dados
// <primeiro defina a classe a ser trabalhada, tipo do id(Não acita tipos primitivos)>
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

	// coloquei nome pq usei nomes em portugues em todo projeto
	// containing -> contem alguma parte do nome
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
}
