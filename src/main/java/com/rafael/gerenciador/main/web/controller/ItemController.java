package com.rafael.gerenciador.main.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rafael.gerenciador.main.entity.Items;
import com.rafael.gerenciador.main.repository.ItemRepository;
import com.rafael.gerenciador.main.services.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/list")
	public String list(Items item) {
		return "/item/list";
	}
	
	@GetMapping("/add")
	public ModelAndView add(Items item) {
		return new ModelAndView("/item/add");
	}
	
	@GetMapping("/save")
	public String save(Items item) {
		itemRepository.save(item);
		return "redirect:/item/add";
	}
}
