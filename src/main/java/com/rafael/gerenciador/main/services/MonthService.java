package com.rafael.gerenciador.main.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.rafael.gerenciador.main.entity.Month;
import com.rafael.gerenciador.main.entity.Year;
import com.rafael.gerenciador.main.repository.MonthRepository;
import com.rafael.gerenciador.main.services.utils.CrudService;

@Component
public class MonthService  extends CrudService<Month, MonthRepository , Long> {

	@Autowired
	MonthRepository monthRepository;
	
	public boolean saveMonth(Month month) {
		try {
		insert(month);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public ArrayList<Month> getByYear(Year year) {
		return monthRepository.findByYear(year);
	}
	
	@Override
	protected void updateData(Month currentObj, Month newObj) {
		
	}


	public Page<Month> getByYear(Year year, PageRequest pageRequest) {
		return monthRepository.getByYear(year,pageRequest);
	}
	
}
