package com.rafael.gerenciador.main.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "MONTH ")
public class Month extends AbstractEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String[] MONTHLIST = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
			"Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_month")
	private Long idMonth;

	@Column(name = "fk_year")
	private int idYear;

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "received", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private int received;
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "previous", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private int previous;

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

	}
}
