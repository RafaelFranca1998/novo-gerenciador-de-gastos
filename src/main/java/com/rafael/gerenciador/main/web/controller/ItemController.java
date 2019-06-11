package com.rafael.gerenciador.main.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/item")
public class ItemController {

	
	@GetMapping("/list")
	public String list() {
		return "/item/list";
	}
}
