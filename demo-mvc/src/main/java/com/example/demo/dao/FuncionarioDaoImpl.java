package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.interfaces.FuncionarioDAO;
import com.example.demo.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDAO {

}
