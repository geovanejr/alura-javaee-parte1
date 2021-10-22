package br.com.geovanejuniior.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import br.com.geovanejuniior.loja.daos.LivroDao;
import br.com.geovanejuniior.loja.models.Livro;

@Model
public class AdminListaLivrosBean {
	
	@Inject
	private LivroDao livroDao;
	
	private List<Livro> livros = new ArrayList<>();
	
	public List<Livro> getLivros() {
		
		this.livros = livroDao.listar();
		return livros;
	}
}
