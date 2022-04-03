package br.com.cursojsf.repository;

import java.util.List;

import javax.faces.model.SelectItem;

import br.com.cursojsf.entidades.Pessoa;

public interface IDaoPessoa {

	Pessoa consultarUsuario(String login, String senha);

	List<SelectItem> listaEstados();
}
