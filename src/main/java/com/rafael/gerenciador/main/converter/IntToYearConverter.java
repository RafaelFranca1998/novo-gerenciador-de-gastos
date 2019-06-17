package com.rafael.gerenciador.main.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rafael.gerenciador.main.entity.Year;
import com.rafael.gerenciador.main.services.YearService;

@Component
public class IntToYearConverter implements Converter<Integer, Year> {

	@Autowired
	private YearService service;

	@Override
	public Year convert(Integer text) {
		if (text == null) {
			return null;
		}
		int id = Integer.valueOf(text);
		Year year =  new Year();
		year.setYear(id);
		return year;
	}
}