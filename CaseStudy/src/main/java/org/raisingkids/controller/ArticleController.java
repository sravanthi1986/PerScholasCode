package org.raisingkids.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.raisingkids.dao.ArticleDAO;
import org.raisingkids.dao.CategoryDAO;
import org.raisingkids.dao.CommentsDAO;
import org.raisingkids.model.Article;
import org.raisingkids.model.Category;
import org.raisingkids.model.Comments;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {
	@GetMapping("/article")
	public String article(HttpSession session) throws Exception {
		String userRole = session.getAttribute("currentUserRole") != null
				? session.getAttribute("currentUserRole").toString()
				: "";
		if (userRole.equalsIgnoreCase("admin")) {
			session.setAttribute("isAdmin", true);

		} else {
			session.setAttribute("isAdmin", false);
			session.setAttribute("notAuthorized", "You don't have access for this page !!");
			return "Article";
		}
		CategoryDAO dao = new CategoryDAO();
		List<Category> categoryList = dao.getAllCategories();
		session.setAttribute("categoryList", categoryList);
		return "Article";
	}

	@PostMapping("/createArticle")
	public String createArticle(@RequestParam String articleTitle, @RequestParam String articleContent,
			@RequestParam String categoryId, HttpSession session)
			throws ClassNotFoundException, SQLException, IOException {
		session.removeAttribute("articleSuccess");
		session.removeAttribute("articleError");
		String userRole = session.getAttribute("currentUserRole").toString();
		if (userRole.equalsIgnoreCase("admin")) {
			session.setAttribute("isAdmin", true);

		} else {
			session.setAttribute("isAdmin", false);
			session.setAttribute("notAuthorized", "You don't have access for this page !!");
			return "redirect:/article";
		}
		String author = (String) session.getAttribute("currentUserName");
		ArticleDAO dao = new ArticleDAO();
		int articleId = dao
				.createArticle(new Article(articleTitle, author, articleContent, Integer.parseInt(categoryId), ""));
		if (articleId > 1) {
			session.removeAttribute("articleError");
			session.setAttribute("articleSuccess", "Article " + articleTitle + " Successfully !");
		} else {
			session.removeAttribute("articleSuccess");
			session.setAttribute("articleError", "Error in creation of " + articleTitle + " . Please try again");
		}
		return "redirect:/article";

	}

	@GetMapping("/articles/{articlePath}")
	public String articles(@PathVariable String articlePath, HttpSession session) throws Exception {

		if (session.getAttribute("currentUserName") != null) { //  check user session 
			System.out.println("articlePath==========>"+articlePath);
			ArticleDAO dao = new ArticleDAO();
			Article article = dao.getarticleByPath(articlePath);
			if (article != null) {
				session.setAttribute("article", article);
				session.removeAttribute("articleURL");
				session.setAttribute("articleURL", articlePath );
				CommentsDAO commentsDAO = new CommentsDAO();
				List<Comments> comments = commentsDAO.getAllCommentsByArticleId(article.getArticleId());
				System.out.println("Comments Length==========>"+comments.size());
				session.removeAttribute("comments");
				session.setAttribute("comments", comments); 
				return articlePath;
			} else {
				return "redirect:/404";
			}

		} else {

			return "redirect:/login";
		}

	}
	@PostMapping("/comments")
	public String comments(@RequestParam String comments, @RequestParam String articleUrl,HttpSession session) throws Exception {
		ArticleDAO dao = new ArticleDAO();
		Article article = dao.getarticleByPath(articleUrl);
		CommentsDAO commentsDAO = new CommentsDAO();
		commentsDAO.createCommentDetails(new Comments(comments,article.getArticleId(),1));
		return "redirect:/articles/"+articleUrl;
	}

}
