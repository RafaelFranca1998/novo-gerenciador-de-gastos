package com.rafael.gerenciador.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.gerenciador.main.entity.Year;


public interface YearRepository extends JpaRepository<Year, Long> {

	List<Year> findAll();
}
