package org.perscholas.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
	@GetMapping("/")
	public String contact() {
		return "ContactPage";
	}
	@GetMapping("/welcome")
	public String Welcome() {
		return "Welcome";
	}
	@GetMapping("/aboutme")
	public String aboutme() {
		return "Aboutme";
	}
	@GetMapping("/contactme")
	public String contactme() {
		return "ContactPage";
	}
	@PostMapping("/contact")
	public String contact(@RequestParam String userName,
			                @RequestParam String message,
			                HttpSession session) {
		System.out.println("Name: " +userName + ", Password: "+ message);
		System.out.println(userName);
		session.setAttribute("currentUser", userName);

		return "Welcome";
	}
	
	
	

}
