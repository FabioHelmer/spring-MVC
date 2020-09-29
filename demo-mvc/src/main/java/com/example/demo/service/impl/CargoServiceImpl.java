package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.interfaces.CargoDAO;
import com.example.demo.domain.Cargo;
import com.example.demo.service.CargoService;

@Service
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoDAO cargoDAO;

	@Override
	public void salvar(Cargo cargo) {
		cargoDAO.save(cargo);

	}

	@Override
	public void editar(Cargo cargo) {
		cargoDAO.update(cargo);

	}

	@Override
	public void excluir(Long id) {
		cargoDAO.delete(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Cargo recuperaPorId(Long id) {
		return cargoDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		return cargoDAO.findAll();
	}

}
