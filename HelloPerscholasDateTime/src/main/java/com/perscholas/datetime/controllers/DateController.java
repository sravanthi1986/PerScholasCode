package com.perscholas.datetime.controllers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateController {

	@GetMapping("/")
	//model is injecting by spring
	public String date(Model model,HttpSession session) {
		model.addAttribute("datetime", LocalDateTime.now());
		session.setAttribute("currentUser", "sravs");
		return "Welcome";
	}

}
