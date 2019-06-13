package com.rafael.gerenciador.main.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/year")
public class YearController {
	
	@GetMapping("/list")
	public String list() {
		return "/year/list";
	}
	
	@GetMapping("/add")
	public String add() {
		return "/year/add";
	}
	
	@GetMapping("/save")
	public String save() {
		return "/year/add";
	}
	
}
