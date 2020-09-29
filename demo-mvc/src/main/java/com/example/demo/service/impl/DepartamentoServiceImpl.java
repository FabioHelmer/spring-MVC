package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.interfaces.DepartamentoDAO;
import com.example.demo.domain.Departamento;
import com.example.demo.service.DepartamentoService;

@Service
@Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	DepartamentoDAO departamentoDAO;

	@Override
	public void salvar(Departamento departamento) {
		departamentoDAO.save(departamento);

	}

	@Override
	public void editar(Departamento departamento) {
		departamentoDAO.update(departamento);

	}

	@Override
	public void excluir(Long id) {
		departamentoDAO.delete(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Departamento recuperaPorId(Long id) {
		return departamentoDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> buscarTodos() {
		return departamentoDAO.findAll();
	}

}
