package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Departamento;
import com.example.demo.repositorys.DepartamentoRepository;
import com.example.demo.service.utils.Utils;

@Service
public class DepartamentoService implements GenericService<Departamento, String> {

	@PersistenceContext
	EntityManager entityManager;

	Session session;

	@Autowired
	private DepartamentoRepository departamentoRepository;

	public Departamento save(Departamento departamento) {
		Integer max = departamentoRepository.carregaSequencia();
		if (max == null) {
			max = 0;
		}
		String codigo = Utils.zeroExquerda(max + 1);
		departamento.setCodigo(codigo);
		departamento.setId(Utils.UUID());
		return departamentoRepository.save(departamento);

	}

	@Override
	public List<Departamento> findAll() {
		return departamentoRepository.findAll();
	}

	@Override
	public Departamento findById(String id) {
		return departamentoRepository.findById(id).get();

	}

	public void delete(String id) {
		departamentoRepository.deleteById(id);
	}

	public Departamento update(Departamento entity) {
		Departamento departamento = departamentoRepository
				.findById(entity.getId().substring(0, entity.getId().length() - 1)).get();
		departamento.setNome(entity.getNome());
		return departamentoRepository.save(departamento);
	}

}
