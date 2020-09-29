package com.example.demo.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

public abstract class AbstractDao<T, PK extends Serializable> {

	@SuppressWarnings("unchecked")
	private final Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];

	@PersistenceContext
	private EntityManager entityManager;

	private Session session;

	protected Session getSession() {
		return session;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(PK id) {
		entityManager.remove(entityManager.getReference(entityClass, id));
	}

	public T findById(PK id) {
		return entityManager.find(entityClass, id);
	}

	public List<T> findAll() {
		return entityManager.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
	}

	protected List<T> createNativeQuery(String sql, HashMap<String, Object> params) {

		@SuppressWarnings("unchecked")
		TypedQuery<T> query = (TypedQuery<T>) entityManager.createNativeQuery(sql);
		params.forEach((key, value) -> {
			query.setParameter(key, value);
		});

		return query.getResultList();
	}

	protected List<T> createQuery(String sql, HashMap<String, Object> params) {

		TypedQuery<T> query = entityManager.createQuery(sql, entityClass);
		params.forEach((key, value) -> {
			query.setParameter(key, value);
		});

		return query.getResultList();
	}

}
