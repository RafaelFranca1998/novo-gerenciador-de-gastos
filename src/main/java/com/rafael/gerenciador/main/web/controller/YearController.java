package com.rafael.gerenciador.main.web.controller;

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

import com.rafael.gerenciador.main.entity.Year;
import com.rafael.gerenciador.main.services.YearService;

@Controller
@RequestMapping("/year")
public class YearController {

	@Autowired
	YearService yearService;
	
	@GetMapping("/list")
	public String list() {
		return "/year/list";
	}

	@GetMapping("/add")
	public ModelAndView add(Model model, HttpSession session,Year yearObject) {
		model.addAttribute("year",yearObject);
		return new ModelAndView("/year/add");
	}

	@PostMapping("/save")
	public String save(Model model, HttpSession session, @ModelAttribute("year") Year year, RedirectAttributes attr) {
		
		if (yearService.saveYear(year)) {
			attr.addFlashAttribute("success", "Ano inserido com sucesso.");
		}else {
			attr.addFlashAttribute("fail", "Ano não foi inserido.");
		}
		return "redirect:/year/add";
	}

	/*
	 * @ModelAttribute("year") public ArrayList<Year> getUFs() { return
	 * Year.getYEARLIST(); }
	 */
}
