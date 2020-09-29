package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.interfaces.CargoDAO;
import com.example.demo.domain.Cargo;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDAO {

}
