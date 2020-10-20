package com.example.demo.service;

import java.util.List;

public interface GenericService<T, V> {

	public T save(final T entity);

	public List<T> findAll();

	public T findById(final String id);

	public T update(final T entity);

}
