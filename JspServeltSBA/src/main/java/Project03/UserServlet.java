package Project03;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   public UserServlet() {
       super();
   }
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("WEB-INF/views/User.jsp").forward(request, response);
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String username = request.getParameter("userName");
       String password = request.getParameter("password");
      UserDAO userDao = new UserDAO();
       System.out.println("UserName: " + username);
       System.out.println("password: " + password);
       UserClass user = null;
        try {
            user = userDao.getUserByName(username);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       if(user.getUserName().equals(username) && user.getPassword().equals(password)) {
           request.setAttribute("userName", user.getUserName());
           request.getRequestDispatcher("WEB-INF/views/Welcome.jsp").forward(request, response);
       }else {
           request.getRequestDispatcher("WEB-INF/views/User.jsp").forward(request, response);
       }
   }
}
