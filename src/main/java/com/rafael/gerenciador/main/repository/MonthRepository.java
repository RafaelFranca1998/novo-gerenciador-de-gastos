package com.rafael.gerenciador.main.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.gerenciador.main.entity.Month;

@Repository
public interface MonthRepository extends JpaRepository<Month, Long> {

	List<Month> findAll();
	
	ArrayList<Month> findByIdYear(Long idYear);
	
	//List<Month> findByName(String nome);

}
