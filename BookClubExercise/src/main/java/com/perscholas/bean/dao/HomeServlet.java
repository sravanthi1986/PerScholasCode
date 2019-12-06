package com.perscholas.bean.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.perscholas.bean.dao.BookDAO;
import com.perscholas.bean.dao.MemberDAO;
import com.perscholas.bean.Book;
import com.perscholas.bean.Member;

@WebServlet({"/HomeServlet", "/HomeServlet/*"})
public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/* The action string will be assigned the URL route and determine which 
		 * servlet method gets called by using a switch block. */
		String action = null;
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		
		/* If there are no characters after the servlet path (pathInfo will be 
		 * null) or if the servlet path is followed by a single "/" then the action 
		 * string will be assigned only the servlet path. If there is a slash 
		 * followed by any characters, then the action string will be assigned the 
		 * servlet path plus the additional path information. */
		if (pathInfo == null || pathInfo.equals("/")) {
			action = servletPath;
		} else {
			action = servletPath + pathInfo;
		}
		// Verify the action string by printing to the console
		System.out.println(action);
		
		try
		{
			switch(action) {
				case "/HomeServlet":
					showLogin(request, response);
					break;
				case "/HomeServlet/loginMember":
					loginMember(request, response);
					break;
				case "/HomeServlet/showWelcomePage":
					showWelcomePage(request, response);
					break;
				case "/HomeServlet/showRegistration":
					showRegistration(request, response);
					break;
				case "/HomeServlet/registerMember":
					registerMember(request, response);
					break;
				case "/HomeServlet/showBooksPage":
					showEventsPage(request, response);
					break;
				case "/HomeServlet/createBook":
					createBook(request, response);
					break;
				case "/HomeServlet/logout":
					logout(request, response);
					break;
				default:
					showLogin(request, response);
					break;
			}
		}
		catch(IOException | SQLException | ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void showLogin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
		rd.forward(request, response);
	}
	
	private void loginMember(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		MemberDAO m_dao = new MemberDAO();
		Member m = m_dao.memberByName(name);
		
		if (m != null ) {
			if (password.equals(m.getPassword())) {
				session.setAttribute("currentMember", m);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Invalid login-password");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("errorMessage", "Invalid login-user name");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
			rd.forward(request, response);
		}
	}
	private void showWelcomePage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp");
		rd.forward(request, response);
	}
	
	private void showRegistration(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Register.jsp");
		rd.forward(request, response);
	}
	
	private void registerMember(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, IOException, ServletException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String favoriteGenre = request.getParameter("favoriteGenre");
		
		Member m = new Member();
		m.setName(name);
		m.setEmail(email);
		m.setPassword(password);
		m.setFavoriteGenre(favoriteGenre);
		
		MemberDAO m_dao = new MemberDAO();
		Integer i = m_dao.registerMember(m);
		System.out.println(i);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
		rd.forward(request, response); 
	}
	
	private void showEventsPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		BookDAO b_dao = new BookDAO();
		List<Book> allEvents = b_dao.getAllBooks();
		request.setAttribute("allEvents", allEvents);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/BookssPage.jsp");
		rd.forward(request, response);
	}
	private void createBook(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		
		String title = request.getParameter("title");
		String synopsis = request.getParameter("synopsis");
		String author = request.getParameter("author");
		String dateTimeString = request.getParameter("publicationDate");
		LocalDateTime ldt = (LocalDateTime.parse(dateTimeString));
		
		Book book = new Book();
		book.setTitle(title);
		book.setSynopsis(synopsis);
		book.setAuthor(author);
		book.setPublicationDate(ldt);
		Member currentMember = (Member)session.getAttribute("currentMember");
		book.setMemberId(currentMember.getMemberId());
		
		BookDAO b_dao = new BookDAO();
		b_dao.createBook(book);
		
		RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet/showBooksPage");
		rd.forward(request, response);
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet");
		rd.forward(request, response);
	}
}