package org.raisingkids.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.raisingkids.dao.CommentsDAO;
import org.raisingkids.model.Comments;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	@GetMapping("/parents")
	public String parents(HttpSession session) throws Exception {
		if (session.getAttribute("currentUserName") != null) { //  check user session 
			session.setAttribute("artcleURL", "parents");
			return "Parents";

		} else {

			return "redirect:/login";
		}
	}

	@GetMapping("/tips")
	public String tips(HttpSession session)
			throws ClassNotFoundException, SQLException, IOException {
		if (session.getAttribute("currentUserName") != null) { //  check user session 
			CommentsDAO commentsDAO = new CommentsDAO();
			List<Comments> comments = commentsDAO.getAllCommentsByArticleId(17);
			session.setAttribute("artcleURL", "tips");
			session.setAttribute("comments", comments);
			return "tips";

		} else {

			return "redirect:/login";
		}
	}

	@GetMapping("/education")
	public String education(HttpSession session) throws Exception {

		if (session.getAttribute("currentUserName") != null) { //  check user session 
			return "education";

		} else {

			return "redirect:/login";
		}

	}
	
	@GetMapping("/behavior")
	public String behavior(HttpSession session)
			throws ClassNotFoundException, SQLException, IOException {
		if (session.getAttribute("currentUserName") != null) { //  check user session 
			return "behavior";

		} else {

			return "redirect:/login";
		}
	}
	
	@GetMapping("/contactus")
	public String contactus(HttpSession session)
			throws ClassNotFoundException, SQLException, IOException {
		return "contactus";
	}

}
