package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.interfaces.FuncionarioDAO;
import com.example.demo.domain.Funcionario;
import com.example.demo.service.FuncionarioService;

public class FuncionarioServiceImpl implements FuncionarioService {
	@Autowired
	FuncionarioDAO funcionarioDAO;

	@Override
	public void salvar(Funcionario funcionario) {
		funcionarioDAO.save(funcionario);

	}

	@Override
	public void editar(Funcionario funcionario) {
		funcionarioDAO.update(funcionario);

	}

	@Override
	public void excluir(Long id) {
		funcionarioDAO.delete(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario recuperaPorId(Long id) {
		return funcionarioDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		return funcionarioDAO.findAll();
	}
}
