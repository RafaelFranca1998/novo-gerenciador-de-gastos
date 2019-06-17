package com.rafael.gerenciador.main.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rafael.gerenciador.main.entity.Month;
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
	
	
	public ArrayList<Month> getByIdYear(Long idYear) {
		return monthRepository.findByIdYear(idYear);
	}
	
	@Override
	protected void updateData(Month currentObj, Month newObj) {
		
	}
	
}
