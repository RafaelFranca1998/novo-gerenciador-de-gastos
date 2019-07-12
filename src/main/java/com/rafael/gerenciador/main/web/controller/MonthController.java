package com.rafael.gerenciador.main.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rafael.gerenciador.main.entity.Month;
import com.rafael.gerenciador.main.entity.Month.MonthList;
import com.rafael.gerenciador.main.entity.Year;
import com.rafael.gerenciador.main.services.MonthService;
import com.rafael.gerenciador.main.services.YearService;

@Controller
@RequestMapping("/month")
public class MonthController {

	@Autowired
	YearService yearService;
	
	@Autowired
	MonthService monthService;
	
	@GetMapping("/list")
	public ModelAndView list(Model model, HttpSession session,Month monthObject) {
		model.addAttribute("year",monthObject);
		return new  ModelAndView("/month/list");
	}
	
	@GetMapping("/add")
	public ModelAndView add(Model model, HttpSession session, @ModelAttribute("month") Month month, RedirectAttributes attr) {
		ArrayList<Year>yearList = new ArrayList<>(yearService.findAll());
		MonthList[]monthList =  Month.MonthList.values();

		model.addAttribute("month",new Month(""));
		model.addAttribute("yearList",yearList);
		model.addAttribute("monthList",monthList);
		return  new  ModelAndView("/month/add");
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("month") Month month, RedirectAttributes attr) {
		
		if (monthService.saveMonth(month)) {
			attr.addFlashAttribute("success", "Mês inserido com sucesso.");
		}else {
			attr.addFlashAttribute("fail", "Mês não foi inserido.");
		}
		return "redirect:/month/add";
	}
}
