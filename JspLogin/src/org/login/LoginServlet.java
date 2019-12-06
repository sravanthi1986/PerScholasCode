package org.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/Login.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting values from login page
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String cUserName = null;
		String cPwd = null;
		String cDob = null;
		String cFirstName = null;
		//retriving values from cookie
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("userName")) {
				cUserName = cookie.getValue();
			}else if(cookie.getName().equals("userPassword")) {
				cPwd = cookie.getValue();
			}else if(cookie.getName().equals("dob")) {
				cDob = cookie.getValue();
			}else if(cookie.getName().equals("firstName")) {
				cFirstName = cookie.getValue();
			}
		}
		//im validating userame and paasword with registration form data
		if (userName.equals(cUserName) && userPassword.equals(cPwd)) {
			request.setAttribute("firstName", cFirstName);
			request.setAttribute("dob", cDob);
			request.getRequestDispatcher("WEB-INF/views/Sucess.jsp")
			.forward(request, response);
		} else {
			request.setAttribute("error", "Invalid Login");
			request.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(request, response);
		}
	}
}