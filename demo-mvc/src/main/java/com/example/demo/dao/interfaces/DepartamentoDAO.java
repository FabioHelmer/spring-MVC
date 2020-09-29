package com.example.demo.dao.interfaces;

import java.util.List;

import com.example.demo.domain.Departamento;

public interface DepartamentoDAO {

	void save(Departamento departamento);

	void update(Departamento departamento);

	void delete(Long id);

	Departamento findById(Long id);

	List<Departamento> findAll();

}
