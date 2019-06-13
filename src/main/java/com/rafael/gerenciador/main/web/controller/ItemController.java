package com.rafael.gerenciador.main.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rafael.gerenciador.main.domain.Items;
import com.rafael.gerenciador.main.services.ItemService;

@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemServices;
	
	@GetMapping("/list")
	public String list(Items item) {
		return "/item/list";
	}
	
	@GetMapping("/add")
	public String add(Items item) {
		return "/item/add";
	}
	
	@GetMapping("/save")
	public String save(Items item) {
		itemServices.salvar(item);
		return "redirect:/item/add";
	}
}
