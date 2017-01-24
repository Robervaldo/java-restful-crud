package br.com.crud_restful.service;

import javax.persistence.EntityManager;

import br.com.crud_restful.model.AbstractEntity;

public abstract class AbstractPersistence<T extends AbstractEntity, PK extends Number> {

	private Class<T> entityClass;
	
	public AbstractPersistence(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T save(T e) {
		if (e.getId() != null)
			return getEntityManager().merge(e);
		else {
			getEntityManager().persist(e);
			return e;
		}
	}
	
	public T persist(T e) {
		getEntityManager().persist(e);
		return e;
	}
	
	public T merge(T e) {
		return getEntityManager().merge(e);
	}

	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public T find(PK id) {
		return getEntityManager().find(entityClass, id);
	}

	protected abstract EntityManager getEntityManager();
}
