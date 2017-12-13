package user;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Resource(lookup="jdbc/MyTHIPool")
	    private DataSource ds; 
    /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
  

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    
        //request.setCharacterEncoding("UTF-8";)
        String username = request.getParameter("username");
        
        //DB-Zugriff
        List<UserData> users = search(username);
        
        //Scope 
        request.setAttribute("users", users);
        
         //Weiterleiten an JSP
        final RequestDispatcher disp = request.getRequestDispatcher("jsp/Search/SearchPage.jsp");
        disp.forward(request, response);
        
    }   
    
    
        private List <UserData> search(String username) throws ServletException {
            username = (username == null || username == "") ? "%" : "%" + username + "%";
            List<UserData> users = new ArrayList<UserData>();
            System.out.println("Der User:" + username);
            
            //DB-Zugriff
            try (Connection con = ds.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("SELECT * from users WHERE username LIKE ?")){
                        
                        pstmt.setString(1, username);
                                    
                        try (ResultSet rs = pstmt.executeQuery()){
                            
                            while (rs.next()){
                                UserData user = new UserData();
                                
                             //   Long id = Long.valueOf(rs.getLong("id"));
                            //    user.setId(id);
                                
                                String location = rs.getString("location");
                                user.setLocation(location);
                                
                                String interests = rs.getString("interests");
                                user.setInterests(interests);
                                
                                users.add(user);
                                
                           
                            }
                        }
                      }catch (Exception ex){
                          throw new ServletException(ex.getMessage());
                      }
                      return users;
        }
        

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


