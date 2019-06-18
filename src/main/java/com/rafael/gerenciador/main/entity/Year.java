package com.rafael.gerenciador.main.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

@Entity
@Table(name = "YEAR")
@ComponentScan
public class Year {


	private static ArrayList<Year> YEARLIST;
	

	static public ArrayList<Year> getYEARLIST() {
		YEARLIST = new ArrayList<Year>();
		for (int i = 2016; i < 3000; i++) {
			Year year =  new Year();
			year.setYear(i);
			YEARLIST.add(year);
		}
		
		return YEARLIST;
	}

	@Column(name = "year", nullable = false, unique = true, length = 4)
	private int year;

	@Id
	@Column(name = "id_year")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idYear;

	@OneToMany
	private List<Month> month;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Long getIdYear() {
		return idYear;
	}

	public void setIdYear(Long idYear) {
		this.idYear = idYear;
	}
	
	

}
