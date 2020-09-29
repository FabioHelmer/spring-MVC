package com.example.demo.dao.interfaces;

import java.util.List;

import com.example.demo.domain.Cargo;

public interface CargoDAO {
	void save(Cargo cargo);

	void update(Cargo cargo);

	void delete(Long id);

	Cargo findById(Long id);

	List<Cargo> findAll();
}
