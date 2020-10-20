package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, String> {

	@Query("select MAX(e.codigo) from Departamento e ")
	Integer carregaSequencia();

}
