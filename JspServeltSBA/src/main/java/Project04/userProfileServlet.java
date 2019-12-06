package Project04;
import java.io.IOException;
import java.sql.SQLException;
//import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project03.UserClass;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet({"/userProfileServlet", "/userProfileServlet/*"})
public class userProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
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
                case "/LoginServlet":
                    showLogin(request, response);
                    break;
                case "/LoginServlet/loginUser":
                    loginUser(request, response);
                    break;
                case "/LoginServlet/showWelcomePage":
                    showWelcomePage(request, response);
                    break;
                case "/LoginServlet/showProfile":
                    showProfile(request, response);
                    break;
                case "/LoginServlet/showUpdatePage":
                    showUpdatePage(request, response);
                    break;
                    
                case "/LoginServlet/updateUser":
                    updateUser(request, response);
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
    
    
        //response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    
        private void updateUser(HttpServletRequest request, HttpServletResponse response) 
                throws ClassNotFoundException, SQLException, IOException, ServletException {
            HttpSession session = request.getSession();
            
            String name = request.getParameter("userName");
            String password = request.getParameter("password");
            
            User user =new User();
            user.setUserName(name);
            user.setPassword(password);
            
            User currentUser = (User)session.getAttribute("currentUser");
            user.setUserId(currentUser.getUserId());
            
            UpadateDAO u_dao = new UpadateDAO();
            u_dao.updateUser(user);
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/EditProfile.jsp");
            rd.forward(request, response);
        }
    
    private void showUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/EditProfile.jsp");
        rd.forward(request, response);
        
    }
    private void showProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/EditProfile.jsp");
        rd.forward(request, response);
    }
    private void showWelcomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp");
        rd.forward(request, response);
        
    }
    private void loginUser(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String name = request.getParameter("userName");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();
        
        UpadateDAO u_dao = new UpadateDAO();
        UserClass u=u_dao.getUserByName(name);
        
        if (u != null ) {
            if (password.equals(u.getPassword())) {
                session.setAttribute("currentUser", u);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Invalid login-password");
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp");
                rd.forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Invalid login-user name");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp");
            rd.forward(request, response);
        }
    }
    private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp");
        rd.forward(request, response);
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
