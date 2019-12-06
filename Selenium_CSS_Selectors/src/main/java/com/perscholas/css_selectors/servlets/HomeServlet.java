package com.perscholas.css_selectors.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/HomeServlet", "/HomeServlet/*" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Servelet is working ");
		String action = null;
		if (request.getPathInfo() == null || request.getServletPath().equals("/")) {
			action = request.getServletPath();
		} else {
			action = request.getServletPath() + request.getPathInfo();

		}
		try {
			switch (action) {
			case "/HomeServlet":
				showPageOne(request, response);
				break;
			case "/HomeServlet/showPage2":
				showPageTwo(request, response);
				break;
			case "/HomeServlet/xPtahOne":
				showxPathOne(request, response);
				break;
			case "/HomeServlet/xPtahTwo":
				showxPathTwo(request, response);
				break;
			case "/HomeServlet/hiddenElements":
				showHiddenElements(request, response);
				break;
			case "/HomeServlet/wait":
				showImplicitWait(request, response);
				break;
			case "/HomeServlet/formInputs":
				showFormInputs(request, response);
				break;
				default:showPageOne(request, response);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void showPageOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/SeleniumCSS.html");
		rd.forward(request, response);
	}

	private void showPageTwo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/SeleniumCSS2.html");
		rd.forward(request, response);
	}
	private void showxPathOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/SeleniumXPathMain.jsp");
		rd.forward(request, response);
	}
	private void showxPathTwo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/SelniumXPathSecond.jsp");
		rd.forward(request, response);
	}
	private void showHiddenElements(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/SeleniumHiddenElements.jsp");
		rd.forward(request, response);
	}
	private void showImplicitWait(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/SeleniumWait.jsp");
		rd.forward(request, response);
	}
	private void showFormInputs(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/FormInputs.jsp");
		rd.forward(request, response);
	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		doGet(request, response);
//	}

}
