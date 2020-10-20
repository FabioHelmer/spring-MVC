package com.example.demo.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {

	@Query("select e from Funcionario e where e.nome LIKE %:nome%")
	List<Funcionario> buscaPorNome(@Param("nome") String nome);

}
