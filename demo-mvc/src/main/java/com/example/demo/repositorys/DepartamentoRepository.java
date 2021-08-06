package com.example.demo.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Cargo;
import com.example.demo.models.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, String> {

	@Query("select MAX(e.codigo) from Departamento e ")
	Integer carregaSequencia();
	
	@Query("select e from Cargo e WHERE e.departamento.id = :idDepartamento ")
	List<Cargo> findCargos(@Param("idDepartamento") String idDepartamento);

}
