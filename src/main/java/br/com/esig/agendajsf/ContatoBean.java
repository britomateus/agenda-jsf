package br.com.esig.agendajsf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.primefaces.PrimeFaces;

import br.com.esig.agendajsf.dao.GenericDAO;
import br.com.esig.agendajsf.model.Contato;

/**
 * @author Mateus Brito
 */

//Classe para gerenciar o Bean, é o controller no padrão MVC

@ViewScoped
@ManagedBean(name = "contatoBean")
public class ContatoBean {
	
	Contato contato = new Contato();
	
	private GenericDAO<Contato> dao = new GenericDAO<Contato>(){};
	
	private List<Contato> contatoList = new ArrayList<Contato>();
	
	public String salvar() throws InterruptedException {		
		dao.save(contato);
		contato = new Contato();
		carregarContatos();
		
		FacesMessage msg = new FacesMessage("Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
		return "";
	}
	
	public String remover(Contato contato) {
		dao.delete(contato);
		carregarContatos();
		return "";
	}
	
	public void alterarContato(Contato contato) throws IOException {
		this.contato = dao.finById(contato);
		contato = new Contato();
		carregarContatos();
	}
	
	
	public void carregarContatos() {
		contatoList = dao.findAll();
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatoList() {
		return contatoList;
	}

	public void setContatoList(List<Contato> contatoList) {
		this.contatoList = contatoList;
	}
	
	
}
