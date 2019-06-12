package com.rafael.gerenciador.main.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rafael.gerenciador.main.domain.Month;

@Repository
public class MonthDaoImpl  extends AbstractDao<Month, Long> implements MonthDao {

	@Override
	public List<Month> findByName(String nome) {
		return createQuery("select m from Month m where m.nome like concat ('%',?1,'%')", nome);

	}



}
