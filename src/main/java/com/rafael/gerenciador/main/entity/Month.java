package com.rafael.gerenciador.main.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "MONTH ")
@ComponentScan
public class Month{
	
	public Month() {
		
	}

	public Month(String month) {
		this.monthName = month;
	}

	
	
	public static final String[] MONTHLIST = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
			"Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_month")
	private Long idMonth;

	@NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "received", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal received; 
	@NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "previous", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal previous;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_year")
	private Year year; 
	
	@Column(name = "month_name")
	private String monthName;
	

	public enum MonthList {
		JANEIRO(1, "Janeiro", new Month("Janeiro")), FEVEREIRO(2, "Fevereiro",new Month("Fevereiro")), MARCO(3, "Março",new Month("Março")), ABRIL(4, "Abril",new Month("Abril")), MAIO(5, "Maio",new Month("Maio")),
		JUNHO(6, "Junho",new Month("Junho")), JULHO(7, "Julho",new Month("Julho")), AGOSTO(8, "Agosto",new Month("Agosto")), SETEMBRO(9, "Setembro",new Month("Setembro")), OUTUBRO(10, "Outubro",new Month("Outubro")),
		NOVEMBRO(11, "Novembro",new Month("Novembro")), DEZEMBRO(12, "Dezembro",new Month("Dezembro"));

		int numericForm;

		String literalForm;
		
		 Month monthForm;

		MonthList(int numericForm, String literalForm, Month monthForm) {
			this.numericForm = numericForm;
			this.literalForm = literalForm;
			this.monthForm =  monthForm;
		}

		public int getNumericForm() {
			return numericForm;
		}

		public String getLiteralForm() {
			return literalForm;
		}

		public Month getMonthForm() {
			monthForm =  new Month();
			monthForm.setMonthName(getLiteralForm());
			return monthForm;
		}

		
		
//		public ArrayList<Month> getAsArray(){
//			ArrayList<Month> list =  new ArrayList<>() ;
//			for (int i = 0; i < MonthList.values().length; i++) {
//				list.add()
//			}
//			return list;
//			
//		}
		
	}

	public Long getIdMonth() {
		return idMonth;
	}

	public void setIdMonth(Long idMonth) {
		this.idMonth = idMonth;
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
	
}
