package com.rafael.gerenciador.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.gerenciador.main.entity.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {
	
	List<Items> findAll();
	
	//List<Items> findByName(String nome);

}
