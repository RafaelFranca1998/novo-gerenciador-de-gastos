package com.rafael.gerenciador.main.dao;

import java.util.List;

import com.rafael.gerenciador.main.domain.Items;


public interface ItemDao  {

	void save(Items items);
	
	void update(Items items);
	
	void delete(Long id);
	
	Items findById(Long id);
	
	List<Items> findAll();
	
	List<Items> findByName(String nome);

}
