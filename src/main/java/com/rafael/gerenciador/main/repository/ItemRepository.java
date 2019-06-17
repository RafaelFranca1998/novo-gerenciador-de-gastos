package com.rafael.gerenciador.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.gerenciador.main.entity.Items;


public interface ItemRepository extends JpaRepository<Items, Long> {
	
	List<Items> findAll();
	
	//List<Items> findByName(String nome);

}
