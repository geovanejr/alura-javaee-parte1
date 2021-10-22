package br.com.geovanejuniior.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.geovanejuniior.loja.models.Livro;

public class LivroDao {
	
	@PersistenceContext
	private EntityManager em;

	public void salvar(Livro livro) {
		
		em.persist(livro);
	}

	public List<Livro> listar() {

		String jPQL = "Select distinct(l) from Livro l "
				+     " join fetch l.autores";
		
		return em.createQuery(jPQL, Livro.class).getResultList();
	}
}
