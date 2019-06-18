package com.rafael.gerenciador.main.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rafael.gerenciador.main.entity.Items;
import com.rafael.gerenciador.main.repository.ItemRepository;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/list")
	public String list(Model model, HttpSession session,Items item) {
		return "/item/list";
	}
	
	@GetMapping("/add")
	public ModelAndView add(Model model, HttpSession session,Items item) {
		return new ModelAndView("/item/add");
	}
	
	@GetMapping("/save")
	public ModelAndView save(Model model, HttpSession session,Items item) {
		itemRepository.save(item);
		return new ModelAndView("/item/add");
	}
}
