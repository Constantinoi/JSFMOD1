package br.com.cursojsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.cursojsf.dao.DaoGeneric;
import br.com.cursojsf.entidades.Pessoa;
import br.com.cursojsf.repository.IDaoPessoa;
import br.com.cursojsf.repository.IDaoPessoaImpl;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {

	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();

	private IDaoPessoa iDaoPessoa = new IDaoPessoaImpl();

	public String salvar() {
		pessoa = daoGeneric.merge(pessoa);
		carregarPessoas();
		mostrarMsg("Cadastrado com sucesso!");
		return "";
	}

	private void mostrarMsg(String msg) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(msg);
		contexto.addMessage(null, message);
	}

	@PostConstruct
	public void carregarPessoas() {
		pessoas = daoGeneric.getListEntity(Pessoa.class);
	}

	public String remove() {
		daoGeneric.removePorId(pessoa);
		pessoa = new Pessoa();
		mostrarMsg("Removido com sucesso!");
		carregarPessoas();
		return "";
	}

	public String novo() {
//		daoGeneric.salvar(pessoa);
		pessoa = new Pessoa();
		return "";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String logar() {

		Pessoa pessoaUser = iDaoPessoa.consultarUsuario(pessoa.getLogin(), pessoa.getSenha());

		if (pessoaUser != null) {// localizou user

			// adicionar usuario na sessao usuarioLogado

			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext externalContext = context.getExternalContext();
			externalContext.getSessionMap().put("usuarioLogado", pessoaUser);

//			HttpServletRequest req = (HttpServletRequest) externalContext.getRequest();
//			HttpSession session = req.getSession();
//
//			session.setAttribute("usuarioLogado", pessoaUser);

			return "primeirapagina.xhtml";
		}

		return "login.xhtml";
	}

	public boolean permiteAcesso(String acesso) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();

		HttpServletRequest req = (HttpServletRequest) externalContext.getRequest();
		HttpSession session = req.getSession();

		Pessoa pessoaUser = (Pessoa) session.getAttribute("usuarioLogado");

		return pessoaUser.getPerfilUser().equals(acesso);
	}

}
