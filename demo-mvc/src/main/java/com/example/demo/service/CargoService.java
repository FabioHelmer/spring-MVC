package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Cargo;
import com.example.demo.repositorys.CargoRepository;
import com.example.demo.service.utils.Utils;

@Service
public class CargoService implements GenericService<Cargo, String> {

	@Autowired
	private CargoRepository cargoRepository;

	@Override
	public Cargo save(Cargo cargo) {
		cargo.setId(Utils.UUID());
		Integer max = cargoRepository.carregaSequencia();
		if (max == null) {
			max = 999;
		}
		cargo.setCodigo(Utils.zeroExquerda(max + 1));
		return cargoRepository.save(cargo);
	}

	@Override
	public List<Cargo> findAll() {
		return cargoRepository.findAll();
	}

	@Override
	public Cargo findById(String id) {
		return cargoRepository.findById(id).get();
	}

	@Override
	public Cargo update(Cargo entity) {
		Cargo cargo = cargoRepository.findById(entity.getId().substring(0, entity.getId().length() - 1)).get();
		cargo.setNome(entity.getNome());
		cargo.setDepartamento(entity.getDepartamento());
		return cargoRepository.save(cargo);

	}

	public void delete(String id) {
		cargoRepository.deleteById(id);

	}

}
