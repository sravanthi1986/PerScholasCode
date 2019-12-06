package com.perscholas.Classified.Spring.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.perscholas.Classified.Spring.model.User;
import com.perscholas.Classified.Spring.repository.UserRepository;

@Controller
public class AddController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/")
	public String login() {
		return "Login";
	}

	@PostMapping("/loginUser")
	public String loginUser(@RequestParam String UserName, @RequestParam String password, HttpSession session)
			throws Exception {
		System.out.println("Name: " + UserName + ", Password: " + password);
	
		return "ClassifiedAdds";

	}

	@GetMapping("/register")
	public String helloregister() {
		return "Register";
	}

	@PostMapping("/registerUser")
	public String registerUser(@RequestParam String userName, @RequestParam String password)
			throws ClassNotFoundException, SQLException, IOException {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		int id = userRepository.registerUser(user);
		if(id > 1) {
		return "redirect:/";
		}else {
			return "redirect:/register";
		}

	}

	@GetMapping("/showAdds")
	public String showAdds() {
		return "ClassifiedAdds";
	}

}
