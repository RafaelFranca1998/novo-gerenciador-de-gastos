package com.rafael.gerenciador.main.services;

import org.springframework.stereotype.Component;

import com.rafael.gerenciador.main.entity.Year;
import com.rafael.gerenciador.main.repository.YearRepository;
import com.rafael.gerenciador.main.services.utils.CrudService;


@Component
public class YearService extends CrudService<Year, YearRepository , Long> {

	public boolean saveYear(Year year) {
		try {
		insert(year);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	protected void updateData(Year currentObj, Year newObj) {
		// TODO Auto-generated method stub
		
	}

	
}
