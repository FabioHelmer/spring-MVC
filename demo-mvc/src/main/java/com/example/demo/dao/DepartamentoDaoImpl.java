package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.interfaces.DepartamentoDAO;
import com.example.demo.domain.Departamento;

@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDAO {


}
