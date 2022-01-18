package br.com.joaocarvalhop.exerciciossb.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.joaocarvalhop.exerciciossb.model.entities.Produto;

// Essa classe é responsável por abstrair os dados
// <primeiro defina a classe a ser trabalhada, tipo do id(Não acita tipos primitivos)>
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

}
