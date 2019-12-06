package com.perscholas.software_developer_club.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.perscholas.software_developer_club.dao.MemberDAO;
import com.perscholas.software_developer_club.models.Member;

@Controller
@SessionAttributes
public class MemberController {
	@GetMapping("/")
	public String showLogin() {
		return "LoginPage";
	}
	
	@PostMapping("/loginMember")
	public String loginMember(@RequestParam String name
			,@RequestParam String password,
			HttpSession session,
			Model model) throws ClassNotFoundException, IOException, SQLException {
		MemberDAO m_dao = new MemberDAO();
		Member m = m_dao.getMemberByName(name);
		if (m != null ) {
			if (password.equals(m.getPassword())) {
				session.setAttribute("currentMember", m);
				return "redirect:/showWelcomePage";
			} else {
				model.addAttribute("errorMessage", "Invalid login-password");
				return "LoginPage";
			}
		} else {
			model.addAttribute("errorMessage", "Invalid login-user name");
			return "LoginPage";
		}
		
	}
	@GetMapping("/showWelcomePage")
	public String showWelcomePage() {
		return "Welcome";
	}
	@GetMapping("/showRegistration")
	public String showRegistration() {
		return "RegistrationPage";
	}
	@PostMapping("/registerMember")
	
	public String registerMember(@RequestParam String name,
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String favoriteLanguage) throws ClassNotFoundException, SQLException, IOException{
		Member m = new Member();
		m.setName(name);
		m.setEmail(email);
		m.setPassword(password);
		m.setFavoriteLanguage(favoriteLanguage);
		
		MemberDAO m_dao = new MemberDAO();
		Integer i = m_dao.registerMember(m);
       return "redirect:/";
	}
}
