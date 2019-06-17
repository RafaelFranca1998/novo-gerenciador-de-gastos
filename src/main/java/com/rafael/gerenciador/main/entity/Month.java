package com.rafael.gerenciador.main.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "MONTH ")
public class Month {


	public static final String[] MONTHLIST = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
			"Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_month")
	private Long idMonth;

	@Column(name = "fk_year")
	private Long idYear;

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "received", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal received;
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "previous", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal previous;
	
	@ManyToOne
	private Year year; 
	
	@Column(name = "month_name")
	private String monthName;
	
	/* (mappedBy = "items",cascade = CascadeType.ALL) */
	@OneToMany
	private List<Items> items;
	
	
	

	public enum MonthList {
		JANEIRO(1, "Janeiro"), FEVEREIRO(2, "Fevereiro"), MARCO(3, "Março"), ABRIL(4, "Abril"), MAIO(5, "Maio"),
		JUNHO(6, "Junho"), JULHO(7, "Julho"), AGOSTO(8, "Agosto"), SETEMBRO(9, "Setembro"), OUTUBRO(10, "Outubro"),
		NOVEMBRO(11, "Novembro"), DEZEMBRO(12, "Dezembro");

		int numericForm;

		String literalForm;

		MonthList(int numericForm, String literalForm) {
			this.numericForm = numericForm;
			this.literalForm = literalForm;
		}

		public int getNumericForm() {
			return numericForm;
		}

		public String getLiteralForm() {
			return literalForm;
		}

//		public ArrayList<Month> getAsArray(){
//			ArrayList<Month> list =  new ArrayList<>() ;
//			for (int i = 0; i < MonthList.values().length; i++) {
//
//			}
//			
//		}
		
	}




	public Long getIdMonth() {
		return idMonth;
	}




	public void setIdMonth(Long idMonth) {
		this.idMonth = idMonth;
	}




	public Long getIdYear() {
		return idYear;
	}




	public void setIdYear(Long idYear) {
		this.idYear = idYear;
	}




	public BigDecimal getReceived() {
		return received;
	}




	public void setReceived(BigDecimal received) {
		this.received = received;
	}




	public BigDecimal getPrevious() {
		return previous;
	}




	public void setPrevious(BigDecimal previous) {
		this.previous = previous;
	}




	public Year getYear() {
		return year;
	}




	public void setYear(Year year) {
		this.year = year;
	}




	public String getMonthName() {
		return monthName;
	}




	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}




	public List<Items> getItems() {
		return items;
	}




	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	
}
