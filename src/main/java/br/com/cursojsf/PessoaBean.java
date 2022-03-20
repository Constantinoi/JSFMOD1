package br.com.cursojsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cursojsf.dao.DaoGeneric;
import br.com.cursojsf.entidades.Pessoa;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {

	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();

	public String salvar() {
		pessoa = daoGeneric.merge(pessoa);
		return "";
	}

	public String remove() {
		daoGeneric.removePorId(pessoa);
		pessoa = new Pessoa();
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

}
