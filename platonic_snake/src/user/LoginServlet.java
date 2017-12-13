package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Resource(lookup="jdbc/MyTHIPool")
	    private DataSource ds; 
	
    /**
     * 
     * 
     * @see HttpServlet#HttpServlet()
     */
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	    
	  ///  try {
	    //    UserBean user = new UserBean();
	      //  user.setUsername(request.getParameter("username"));
	        //user.setPassword(request.getParameter("password"));
	        
	        //user=LoginData.login(user);
	    //}
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    System.out.println("[LOG] Login Servlet called");      
	    String u =request.getParameter("username");  
	    String p =request.getParameter("password");  
	    
	    HttpSession session = request.getSession(false);
	    if(session!=null){
	        session.setAttribute("name", u);
	    }
	      
	    try {
            Connection con = ds.getConnection();
                       
            
            boolean status=false;  
            System.out.println("[LOG] checkUser called");
         //   try (Connection con = ds.getConnection(); //DB-Zugriff
              String sql = "SELECT * from users WHERE username=? and password=?";
              PreparedStatement pstmt = con.prepareStatement(sql);
              System.out.println("[LOG] checkUser DB connection okay");
              System.out.println("[LOG]User: "+u);
              System.out.println("[LOG]Password: "+ p);
              
            pstmt.setString(1,u);  
            pstmt.setString(2,p);  
            //pstmt.executeUpdate(); //bei einem Select Statement kein execute update    
            ResultSet rs=pstmt.executeQuery();  
            //status=rs.next();  


            if (rs.first() ) { //da stand vorher ein ! vor dem rs
                status = true; 
                System.out.println("[LOG] pw is correct");
            }
            
              
            
            if(status){  
                System.out.println("[LOG] Correct User");
                RequestDispatcher rd=request.getRequestDispatcher("jsp/Login/WelcomePage.jsp");  //in"" stand vorher WelcomeServlet
                rd.forward(request,response); 
                System.out.println("Username:" + u); //Erg
                System.out.println("Password:" + p); //E
                    }  
            else{  
                System.out.println("[LOG] Wrong User");
                System.out.println(u); //E
                System.out.println(p); //E
                out.print("Sorry username or password error");  
                RequestDispatcher rd=request.getRequestDispatcher("jsp/Login/LogIn.jsp");  
                rd.include(request,response);  
            } 
	    
	    } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
	    
	    
	  
	          
	    out.close();  
	    }  
	}  