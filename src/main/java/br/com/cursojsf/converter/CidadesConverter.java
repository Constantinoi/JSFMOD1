package br.com.cursojsf.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.cursojsf.entidades.Cidades;
import br.com.cursojsf.entidades.Estados;
import br.com.cursojsf.jpautil.JPAUtil;

//@FacesConverter(forClass = Cidades.class, value = "cidadeConverter")
public class CidadesConverter implements Serializable {


}
//	@Override /* REtorna o objeto */
//	public Object getAsObject(FacesContext context, UIComponent component, String codigoCidadades) {
//
//		EntityManager entityManager = JPAUtil.getEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//
//		Cidades cidades = (Cidades) entityManager.find(Cidades.class, Long.parseLong(codigoCidadades));
//
//		return cidades;
//	}
//
//	@Override /* Retorna apenas o codigo em String */
//	public String getAsString(FacesContext context, UIComponent component, Object cidades) {
//
//		if (cidades == null) {
//			return null;
//		}
//		if (cidades instanceof Cidades) {
//			return ((Cidades) cidades).getId().toString();
//		}
//		return cidades.toString();
//	}
//
//}
