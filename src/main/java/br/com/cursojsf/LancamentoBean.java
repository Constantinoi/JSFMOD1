package br.com.cursojsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.cursojsf.dao.DaoGeneric;
import br.com.cursojsf.entidades.Lancamento;
import br.com.cursojsf.entidades.Pessoa;
import br.com.cursojsf.repository.IDaoLancamento;
import br.com.cursojsf.repository.IDaoLancamentoImpl;

@ViewScoped
@ManagedBean(name = "lancamentoBean")
public class LancamentoBean {

	private Lancamento lancamento = new Lancamento();
	private DaoGeneric<Lancamento> daoGeneric = new DaoGeneric<Lancamento>();
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private IDaoLancamento daoLancamento = new IDaoLancamentoImpl();

	public String salvar() {

		Pessoa pessoaUser = requisicaoPessoaUser();

		lancamento.setUsuario(pessoaUser);
		daoGeneric.salvar(lancamento);

		carregarLancamentos();

		return "";
	}

	private Pessoa requisicaoPessoaUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		HttpServletRequest req = (HttpServletRequest) externalContext.getRequest();
		HttpSession session = req.getSession();
		Pessoa pessoaUser = (Pessoa) session.getAttribute("usuarioLogado");
		return pessoaUser;
	}

	@PostConstruct
	public void carregarLancamentos() {
		Pessoa pessoaUser = requisicaoPessoaUser();
		lancamentos = daoLancamento.consultarLancamento(pessoaUser.getId());
	}

	public String novo() {
		lancamento = new Lancamento();
		return "";
	}

	public String remover() {
		daoGeneric.removePorId(lancamento);
		lancamento = new Lancamento();
		carregarLancamentos();
		return "";
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public DaoGeneric<Lancamento> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Lancamento> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

}
