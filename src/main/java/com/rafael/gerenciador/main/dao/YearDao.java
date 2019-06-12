package com.rafael.gerenciador.main.dao;

import java.util.List;

import com.rafael.gerenciador.main.domain.Year;


public interface YearDao  {

	void save(Year year);
	
	void update(Year year);
	
	void delete(Long id);
	
	Year findById(Long id);
	
	List<Year> findAll();
}
