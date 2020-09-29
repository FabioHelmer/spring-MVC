package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Funcionario;

public interface FuncionarioService {
	void salvar(Funcionario funcionario);

	void editar(Funcionario funcionario);

	void excluir(Long id);

	Funcionario recuperaPorId(Long id);

	List<Funcionario> buscarTodos();

}
