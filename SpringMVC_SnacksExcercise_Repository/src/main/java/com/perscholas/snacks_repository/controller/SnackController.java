package com.perscholas.snacks_repository.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.perscholas.snacks_repository.model.Snacks;
import com.perscholas.snacks_repository.repository.SnackRepository;

@Controller
public class SnackController {
	
	@Autowired
	SnackRepository snackRepository;
	
	@GetMapping("/")
	public String showSnacks(Model model) throws SQLException {
		List<Snacks> allSnacks = snackRepository.showSnacks();
		model.addAttribute("allSnacks", allSnacks);
		model.addAttribute("snack", new Snacks());
		return "Snacks";
	}
	
	@PostMapping("/addSnack")
	public String addSnack(@Valid @ModelAttribute("snack") Snacks snack, 
			BindingResult result, Model model) 
					throws ClassNotFoundException, SQLException, IOException {
		if (result.hasErrors()) {
			List<Snacks> allSnacks = snackRepository.showSnacks();
			model.addAttribute("allSnacks", allSnacks);
			return "Snacks";
		}
		
		Integer snacksid = snackRepository.addSnack(snack);

		if (snacksid == -1) {
			List<Snacks> allSnacks = snackRepository.showSnacks();
			model.addAttribute("allSnacks", allSnacks);
			model.addAttribute("errorMessage", "Add snack failed.");
			return "Snacks";
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/signup/{snacksid}")
	public String signupSnack(@PathVariable Integer snacksid) 
			throws IOException, SQLException {
		Boolean b = snackRepository.removeSnack(snacksid);
		System.out.println(b);
		return "forward:/";
	}
	
	@GetMapping("/cancelSignup/{snacksid}")
	public String cancelSignup(@PathVariable Integer snacksid) 
			throws IOException, SQLException {
		Boolean b = snackRepository.removeSnack(snacksid);
		System.out.println(b);
		return "forward:/";
	}
}