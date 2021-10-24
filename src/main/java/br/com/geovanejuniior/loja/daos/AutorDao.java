package br.com.geovanejuniior.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.geovanejuniior.loja.models.Autor;

public class AutorDao {
	
	@PersistenceContext
	private EntityManager em;

	public List<Autor> findAll() {
		
		String jPQL = "select a from Autor a "
				+     "order by a.nome";
		return em
				.createQuery(jPQL, Autor.class)
				.getResultList();
	}
}
