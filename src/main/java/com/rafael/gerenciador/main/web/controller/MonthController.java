package com.rafael.gerenciador.main.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/month")
public class MonthController {

	@GetMapping("/list")
	public String list() {
		return "/month/list";
	}
	
	@GetMapping("/add")
	public String add() {
		return "/list/add";
	}
}
