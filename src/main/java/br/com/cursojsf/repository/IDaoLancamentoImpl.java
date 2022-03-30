package br.com.cursojsf.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.cursojsf.entidades.Lancamento;
import br.com.cursojsf.jpautil.JPAUtil;

public class IDaoLancamentoImpl implements IDaoLancamento {

	@Override
	public List<Lancamento> consultarLancamento(Long codUser) {
		List<Lancamento> lancamento = null;

		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		lancamento = (List<Lancamento>) entityManager.createQuery("from Lancamento where usuario.id = " + codUser)
				.getResultList();

		entityTransaction.commit();
		entityManager.close();

		return lancamento;
	}

}
