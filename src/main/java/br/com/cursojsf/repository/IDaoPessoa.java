package br.com.cursojsf.repository;

import br.com.cursojsf.entidades.Pessoa;

public interface IDaoPessoa {

	Pessoa consultarUsuario(String login, String senha);

//	List<SelectItem> listaEstados();
}
