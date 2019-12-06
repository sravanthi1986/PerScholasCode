package org.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.removeAttribute("error");
		request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//retriving values from registration page 
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dob = request.getParameter("dob");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		//if password and cpwd matches im storing the values in cookie
		if (userPassword.equals(confirmPassword)) {
			Cookie cf = new Cookie("firstName", firstName);// creating cookie object
			Cookie cl = new Cookie("lastName", lastName);// creating cookie object
			Cookie cDob = new Cookie("dob", dob);// creating cookie object
			Cookie cuserName = new Cookie("userName", userName);// creating cookie object
			Cookie cuserPassword = new Cookie("userPassword", userPassword);// creating cookie object
			Cookie cConfirmPassword = new Cookie("confirmPassword", confirmPassword);// creating cookie object
			//im setting cookies values
			response.addCookie(cf);
			response.addCookie(cl);
			response.addCookie(cDob);
			response.addCookie(cuserName);
			response.addCookie(cuserPassword);
			response.addCookie(cConfirmPassword);
			response.sendRedirect(request.getContextPath()+"/LoginServlet");
		} else {
			request.setAttribute("error", "Please make sure password and confirm password");
			request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request, response);
		}
	
	}
}