package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Departamento;

public interface DepartamentoService {
	void salvar(Departamento departamento);

	void editar(Departamento departamento);

	void excluir(Long id);

	Departamento recuperaPorId(Long id);

	List<Departamento> buscarTodos();


}
