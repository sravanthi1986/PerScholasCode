package org.raisingkids.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.raisingkids.dao.UserDAO;
import org.raisingkids.dao.UserDetailsDAO;
import org.raisingkids.model.User;
import org.raisingkids.model.UserDetails;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaseStudyController {

	private HttpSession session;

	@GetMapping("/")
	public String home(HttpSession session) {
		if (session.getAttribute("currentUserName") != null) {
			return "index";
			// return "home";
		} else
			return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "Login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("currentUserDetails");
		session.removeAttribute("currentUserName");
		session.removeAttribute("currentUserRole");
		return "redirect:/";
	}

	@PostMapping("/loginUser")
	public String loginUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
			HttpSession session) throws Exception {
		if (result.hasErrors()) {
			return "Login";
		}

		String returnPath = "redirect:/";
		UserDAO userDAO = new UserDAO();
		UserDetailsDAO detailsDAO = new UserDetailsDAO();
		User dbUser = userDAO.getuserByUserName(user.getUserName());
		if (dbUser.getUserPassword().equals(user.getUserPassword())) {
			UserDetails userDetails = detailsDAO.getUserDetailsByUserName(dbUser.getUserName());
			session.setAttribute("currentUserDetails", userDetails);
			session.setAttribute("currentUserName", dbUser.getUserName());
			session.setAttribute("currentUserRole", dbUser.getUserRole());
			returnPath = "redirect:/";
		} else {
			returnPath = "Login";
		}
		return returnPath;
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("userdetails", new UserDetails());
		return "registerMe";
	}

	@PostMapping("/registerUser")
	public String registerUser(@Valid @ModelAttribute("userdetails") UserDetails userDetails, BindingResult result,
			Model model, HttpSession session, @RequestParam String userName, @RequestParam String password)
			throws Exception {
		if (result.hasErrors()) {
			return "registerMe";
		}

		String returnPath = "redirect:/";
		UserDAO userDAO = new UserDAO();
		UserDetailsDAO detailsDAO = new UserDetailsDAO();
		int userId = userDAO.createUser(new User(userName, password, "user"));
		if (userId >= 1) {
			userDetails.setUserId(userId);
			int uid = detailsDAO.createUserDetails(userDetails);
			if (uid >= 1)
				return "redirect:/login";
			else {
				userDAO.removeUserbyId(userId);
				return "registerMe";
			}
		} else
			return "registerMe";
	}
	
	@GetMapping("/editprofile")
	public String editProfile(HttpSession session) throws Exception{
//session.removeAttribute("userUpdateSuccess");
//session.removeAttribute("userUpdateError");
		if (session.getAttribute("currentUserName") != null) {
			String userName = session.getAttribute("currentUserName") .toString();
			UserDetailsDAO detailsDAO = new UserDetailsDAO();
			UserDetails details = detailsDAO.getUserDetailsByUserName(userName);
			session.setAttribute("userDetails", details);
			return "editprofile"; 
		} else
			return "redirect:/login";
	}
	
	@PostMapping("/updateUser")
	public String updateUser(HttpSession session, @RequestParam String firstName,@RequestParam String lastName,
			@RequestParam String emailId,@RequestParam String contactNo)
			throws Exception {
		String userName = session.getAttribute("currentUserName") .toString();
		UserDetailsDAO detailsDAO = new UserDetailsDAO();
		UserDetails details = detailsDAO.getUserDetailsByUserName(userName);
		details.setFirstName(firstName);
		details.setLastName(lastName);
		details.setEmailId(emailId);
		details.setContactNo(contactNo);
		if(detailsDAO.updateUserDetails(details)) {
			session.setAttribute("userUpdateSuccess", "Your profile has been updated successfully !!");
		}else {
			session.setAttribute("userUpdateError", "Error in updating your profile. Try again !!");
		}
		return "redirect:/editprofile";
	}

}
