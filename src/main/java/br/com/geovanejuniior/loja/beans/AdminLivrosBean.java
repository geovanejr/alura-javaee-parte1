package br.com.geovanejuniior.loja.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.geovanejuniior.loja.daos.AutorDao;
import br.com.geovanejuniior.loja.daos.LivroDao;
import br.com.geovanejuniior.loja.models.Autor;
import br.com.geovanejuniior.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {
	
	private Livro livro = new Livro();
	
	// Context and Dependency Injection
	@Inject
	private FacesContext context;
	
	@Inject
	private LivroDao livroDao;
	
	@Inject
	private AutorDao autorDao;
	
	public AdminLivrosBean() {

		context = FacesContext.getCurrentInstance();
	}

	@Transactional
	public String salvar() {

		livroDao.salvar(livro);
		
		// Ativando o Face Scope
		context.getExternalContext().getFlash().setKeepMessages(true);

		// Envio da mensagem de sucesso ao formulário
		context.addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));
//		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		
		// Envio da mensagem de sucesso ao formulário
//		FacesContext
//			.getCurrentInstance()
//			.addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));
		
		System.out.println("Livro salvo com sucesso! " + livro);

		return "/livros/lista?faces-redirect=true";
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
		
	public List<Autor> getAutores() {
		
		return autorDao.findAll();
	}

}
