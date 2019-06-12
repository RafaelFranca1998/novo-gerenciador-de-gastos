package com.rafael.gerenciador.main.dao;

import java.util.List;

import com.rafael.gerenciador.main.domain.Month;


public interface MonthDao  {

	void save(Month month);
	
	void update(Month month);
	
	void delete(Long id);
	
	Month findById(Long id);
	
	List<Month> findAll();
	
	List<Month> findByName(String nome);

}
