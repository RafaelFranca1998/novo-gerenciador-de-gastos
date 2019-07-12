package com.rafael.gerenciador.main.resources;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.gerenciador.main.entity.Month;
import com.rafael.gerenciador.main.entity.Month.MonthList;
import com.rafael.gerenciador.main.entity.Year;
import com.rafael.gerenciador.main.services.MonthService;
import com.rafael.gerenciador.main.services.YearService;


@RestController
@RequestMapping("/rest/month") 
public class MonthResource extends GenericResource {
 
	@Autowired
	private  MonthService monthService;
	
	@Autowired
	private YearService yearService;
	
	@GetMapping()
	public ResponseEntity<Page<Month>> list(HttpSession session,
			@RequestParam(value="idYear", required=false) Long idYear,
			@RequestParam(value="month", required=false) Month month,
			@RequestParam(value="pageNumber", required=false) Integer pageNumber, 
			@RequestParam(value="pageSize", defaultValue="10") Integer pageSize){	
		//idYear = (long) 1;
		Year year = yearService.findById(idYear);
		PageRequest pageRequest = getPagination(pageNumber, pageSize);
		Page<Month> projectList = monthService.getByYear(year, pageRequest);
	    return ResponseEntity.ok().body(projectList);
	}
	
	@GetMapping("/{idYear}/table")
	public ResponseEntity<List<Month>> listMonth(@ModelAttribute("month") Month month) {
		System.out.println("MonthResourceOk");
		Year year = month.getYear();
		System.out.println(year.getIdYear());
		ArrayList<Month> monthCompare =  null;
		try {
			monthCompare = new ArrayList<Month>(monthService.getByYear(year));
		} catch (Exception e) {
			System.err.println("Erro De listagem: "+e.getMessage());
		}
		
		ArrayList<Month> result = new ArrayList<>();	
		
		/*
		 * for (MonthList month : Month.MonthList.values()) {
		 * result.add(month.getMonthForm()); }
		 */
		
		for (Month month2 : monthCompare) {
			for (int i = 0; i < result.size(); i++) {
				if (month2.getMonthName().equals(result.get(i).getMonthName())) {
					result.remove(i);
				}				
			}
		}
		
	    return ResponseEntity.ok().body(monthCompare);
	}
	
}
