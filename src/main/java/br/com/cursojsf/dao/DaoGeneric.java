package br.com.cursojsf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.cursojsf.jpautil.JPAUtil;

public class DaoGeneric<T> {

	public void salvar(T entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.persist(entidade);

		entityTransaction.commit();
		entityManager.close();

	}

	public T merge(T entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		T retorno = entityManager.merge(entidade);

		entityTransaction.commit();
		entityManager.close();

		return retorno;
	}

	public void remove(T entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.remove(entidade);

		entityTransaction.commit();
		entityManager.close();

	}

	public void removePorId(T entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Object id = JPAUtil.getPrimaryKey(entidade);

		entityManager.createQuery("delete from " + entidade.getClass().getCanonicalName() + " WHERE id = " + id)
				.executeUpdate();

		entityTransaction.commit();
		entityManager.close();

	}

	public List<T> getListEntity(Class<T> entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		List<T> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();

		entityTransaction.commit();
		entityManager.close();

		return lista;
	}

}
