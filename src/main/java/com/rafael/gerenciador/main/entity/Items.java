package com.rafael.gerenciador.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "ITEMS")
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_items")
	private Long idItems;
	
	@Column(name = "name")
	private String name;

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "value", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private int value;
	@Column(name = "plots")
	private int plots;

	@ManyToOne
	private Items items;

	public Long getIdItems() {
		return idItems;
	}

	public void setIdItems(Long id) {
		this.idItems = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	/*
	 * public int getIdMonth() { return idMonth; }
	 * 
	 * public void setIdMonth(int idMonth) { this.idMonth = idMonth; }
	 */
	public int getPlots() {
		return plots;
	}

	public void setPlots(int plots) {
		this.plots = plots;
	}

}
