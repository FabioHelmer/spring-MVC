package com.example.demo.dao.interfaces;

import java.util.List;

import com.example.demo.domain.Funcionario;

public interface FuncionarioDAO {
	void save(Funcionario funcionario);

	void update(Funcionario funcionario);

	void delete(Long id);

	Funcionario findById(Long id);

	List<Funcionario> findAll();

}
