package com.rafael.gerenciador.main.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.gerenciador.main.entity.Month;
import com.rafael.gerenciador.main.entity.Month.MonthList;
import com.rafael.gerenciador.main.services.MonthService;


@RestController
@RequestMapping("/rest/year") 
public class MonthResource extends GenericResource {
 
	@Autowired
	private  MonthService monthService;
	
	@GetMapping("/{idYear}/month")
	public ResponseEntity<List<Month>> listMonth(@PathVariable("idYear") Long idYear) {
 
		ArrayList<Month> monthCompare = new ArrayList<Month>(monthService.getByIdYear(idYear));
		MonthList[]mList =  Month.MonthList.values();
		
		ArrayList<String> result = new ArrayList<>();
		
		for (Month month2 : monthCompare) {
			if (!month2.getIdYear().equals(idYear)) {
				
			}
		}
		
	    return ResponseEntity.ok().body(monthCompare);
	}
	
}
