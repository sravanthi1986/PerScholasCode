package com.perscholas.hibernate_validation_orm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.perscholas.hibernate_validation_orm.models.Book;

@Controller
public class BookController {
	
	@Autowired
	@Qualifier("hibernateSession")
	private Session session;
	
	@GetMapping("/")
	public String showBooks(Model model) throws SQLException {
		Query<Book> q = session.createQuery("from Book", Book.class);
		List<Book> allBooks = q.list();
		model.addAttribute("allBooks", allBooks);
		model.addAttribute("book", new Book());
		return "Books";
	}
	
	@PostMapping("/addBook")
	public String addBook(@Valid @ModelAttribute("book") Book book, 
			BindingResult result, Model model) 
					throws ClassNotFoundException, SQLException, IOException {
		if (result.hasErrors()) {
			return "Books";
		}
		Integer bookId;
		session.beginTransaction();
		bookId = (Integer) session.save(book);
		session.getTransaction().commit();
		System.out.println("Book ID: " + bookId);
		return "redirect:/";
	}
	
	@GetMapping("/removeBook/{bookId}")
	public String removeBook(@PathVariable Integer bookId) 
			throws IOException, SQLException {
		Book b = session.get(Book.class, bookId);
		session.beginTransaction();
		session.delete(b);
		session.getTransaction().commit();
		return "redirect:/";
	}
}