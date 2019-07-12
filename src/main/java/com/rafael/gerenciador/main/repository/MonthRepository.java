package com.rafael.gerenciador.main.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.gerenciador.main.entity.Month;
import com.rafael.gerenciador.main.entity.Year;

@Repository
public interface MonthRepository extends JpaRepository<Month, Long> {

	List<Month> findAll();

	ArrayList<Month> findByYear(Year year);

	Page<Month> getByYear(Year year, Pageable pageable);
	
//	ArrayList<Month> findByIdYear(Long idYear);
	
	//List<Month> findByName(String nome);

}
