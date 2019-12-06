package org.platform.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.perscholas.dao.MariadbConnection;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/login")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("about to collect data");
        String un=request.getParameter("username");
        String pw=request.getParameter("pwd");
        System.out.println("UserName:"+ un +  pw);
        // Connect to mysql and verify username password
        
        MariadbConnection mariadbConnection = new MariadbConnection();
        try
        {
            Connection cn= mariadbConnection.getConnection();
            System.out.println("Connected to MariaDB!");
             // create the java statement
            PreparedStatement ps = cn.prepareStatement("Select * from user where username=? and Pwd=?");
            ps.setString(1, un);
            ps.setString(2, pw);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                    response.sendRedirect("welcome.html");
                }
          
            else {
                response.sendRedirect("invalid user detials");
            }
            cn.close();
        }
        catch(Exception e)
        {
            System.out.println("Database connction failed.");
            e.printStackTrace();
        }
    }
	

}
