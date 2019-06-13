package com.rafael.gerenciador.main.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "YEAR")
public class Year extends  AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "year", nullable = false, unique = true, length = 4)
	private int year;

	@Id
	@Column(name = "id_year")
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
