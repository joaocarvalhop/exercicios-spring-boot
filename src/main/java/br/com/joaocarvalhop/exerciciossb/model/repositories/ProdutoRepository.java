package br.com.joaocarvalhop.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.joaocarvalhop.exerciciossb.model.entities.Produto;

// Essa classe é responsável por abstrair os dados
// <primeiro defina a classe a ser trabalhada, tipo do id(Não acita tipos primitivos)>
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

	// coloquei nome pq usei nomes em portugues em todo projeto
	// containing -> contem alguma parte do nome
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);

	// Mais consultas
	// findByNomeContaining
	// findByNomeIsContaining
	// findByNomeContains
	// findByNomeStartsWith
	// findByNomeEndsWith
	// findByNomeNotContaining

	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String nome);
}
