package com.perscholas.spirng.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String helloPerscholas() {
		return "Hello";
	}

	@RequestMapping("/HeloQE")
	public String helloQE() {
		return "HeloQE";
	}
}
