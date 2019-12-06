package com.perscholas.hibernate_validation_repository.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.perscholas.hibernate_validation_repository.models.User;
import com.perscholas.hibernate_validation_repository.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public String showSignIn(Model model) throws SQLException {
		
		model.addAttribute("user", new User());
		return "SignIn";
	}
	
	@GetMapping("/showRegisterPage")
	public String showRegisterPage(Model model) {
		model.addAttribute("user2", new User());
		return "Register";
	}
	
	@PostMapping("/registerUser")
	public String addUser(@Valid @ModelAttribute("user2") User user, 
			BindingResult result, Model model) 
					throws ClassNotFoundException, SQLException, IOException {
		if (result.hasErrors()) {
			
			return "SignIn";
		}
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		Integer addId = userRepository.addUser(user);

		if (addId == -1) {
			
			return "SignIn";
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/verifyUser")
	public String verifyUser(@Valid @ModelAttribute("user") User user, 
			BindingResult result, Model model) 
					throws ClassNotFoundException, SQLException, IOException {
		if (result.hasErrors()) {
			
			return "SignIn";
		}
		User foundUser = userRepository.findUserByUsername(user);
		
		if(Objects.isNull(foundUser)) {
	
			return "SignIn";
		}
		else {
			
			if(foundUser.getPassword().equals(user.getPassword())) {
				return "redirect:/addController";
			}
			else {
				return "SignIn";
			}
		
		}
		
		
	}
	
	
}