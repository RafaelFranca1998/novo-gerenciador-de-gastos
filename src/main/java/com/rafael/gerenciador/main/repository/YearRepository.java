package com.rafael.gerenciador.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.gerenciador.main.entity.Year;

@Repository
public interface YearRepository extends JpaRepository<Year, Long> {

	List<Year> findAll();
}
