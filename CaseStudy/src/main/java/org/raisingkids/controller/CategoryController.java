package org.raisingkids.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.raisingkids.dao.CategoryDAO;
import org.raisingkids.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {

	@GetMapping("/category")
	public String category(HttpSession session) {
		String userRole = session.getAttribute("currentUserRole").toString();
		if (userRole.equalsIgnoreCase("admin"))
			session.setAttribute("isAdmin", true);
		else {
			session.setAttribute("isAdmin", false);
			session.setAttribute("notAuthorized", "You don't have access for this page !!");
		}
		return "category";
	}

	@PostMapping("/createCategory")
	public String createCategory(@RequestParam String categoryTitle, @RequestParam String categoryDescription,
			HttpSession session) throws ClassNotFoundException, SQLException, IOException {
		session.removeAttribute("categorySuccess");
		session.removeAttribute("categoryError");
		String userRole = session.getAttribute("currentUserRole").toString();
		if (userRole.equalsIgnoreCase("admin")) {
			session.setAttribute("isAdmin", true);

			CategoryDAO dao = new CategoryDAO();
			int categoryId = dao.createCategory(new Category(categoryTitle));
			if (categoryId > 1) {
				session.removeAttribute("categoryError");
				session.setAttribute("categorySuccess", "Category " + categoryTitle + " Successfully !");
			} else {
				session.removeAttribute("categorySuccess");
				session.setAttribute("categoryError", "Error in creation of " + categoryTitle + " . Please try again");
			}
		} else {
			session.setAttribute("isAdmin", false);
			session.setAttribute("notAuthorized", "You don't have access for this page !!");
		}
		return "redirect:/category";

	}

}
