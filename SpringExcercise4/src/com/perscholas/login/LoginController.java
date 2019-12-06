package com.perscholas.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController {
	@GetMapping("/")
	public String helologin() {
		return "Login";
	}

	@GetMapping("/register")
	public String helloregister() {
		return "Register";
	}
	@PostMapping("/loginUser")
	public String loginUser(@RequestParam String userName,
			                @RequestParam String password) {
		System.out.println("Name: " +userName + ", Password: "+ password);
		return "Login";
	}
	@PostMapping("/registerUser")
	public String registerUser(@RequestParam String firstName,
			                @RequestParam String lastName,
			                @RequestParam String email,
			                @RequestParam String password,
			                @RequestParam String confirmpassword,
			                @RequestParam String dob
			                ) {
		System.out.println("Name: " +firstName + ", LastName: "+ lastName +" " + email + "  "+ password +" "
			                +confirmpassword +" " +dob);
		return "Login";
	}
	

}
