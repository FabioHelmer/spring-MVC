package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {

}
