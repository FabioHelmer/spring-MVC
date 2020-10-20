package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, String> {
	@Query("select MAX(e.codigo) from Cargo e ")
	Integer carregaSequencia();

}
