package br.com.cursojsf.repository;

import java.util.List;

import br.com.cursojsf.entidades.Lancamento;

public interface IDaoLancamento {

	List<Lancamento> consultarLancamento(Long codUser);
	
}
