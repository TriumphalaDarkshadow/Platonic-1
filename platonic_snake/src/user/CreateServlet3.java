package user;

import java.sql.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
// import javax.resource.cci.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

 
//Neuen Eintrag anlegen
/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet3")
public class CreateServlet3 extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Resource(lookup="jdbc/MyTHIPool")
    private DataSource ds; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void persist(UserData form) throws ServletException {
        String [] generatedKeys = new String [] {"id"};
        try (Connection con = ds.getConnection(); 
                final Statement stmt = con.createStatement();
                PreparedStatement pstmt = con.prepareStatement(
                        "INSERT INTO Users (username, email, password, birthday, location, interests) VALUES (?,?,?,?,?,?)", 
                        generatedKeys)){
            

            pstmt.setString(1,form.getUsername());
            pstmt.setString(2, form.getEmail());
            pstmt.setString(3, form.getPassword());
            pstmt.setString(4, form.getBirthday());
            pstmt.setString(5, form.getLocation());
            pstmt.setString(6, form.getInterests());
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            while(rs.next()) {
                form.setId(rs.getLong(1));
            }
        }
        catch(Exception ex) {
            throw new ServletException(ex.getMessage());
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        UserData form = new UserData();
        form.setUsername(request.getParameter("username"));
        form.setEmail(request.getParameter("email"));
        form.setPassword(request.getParameter("password"));
        form.setBirthday(request.getParameter("birthday"));
        form.setLocation(request.getParameter("location"));
        form.setInterests(request.getParameter("interests"));
      //  form.setQuantity(Integer.valueOf(request.getParameter("quantity")));
        persist(form);
        
        final HttpSession session = request.getSession();
        session.setAttribute("form", form);
        
        final RequestDispatcher disp = request.getRequestDispatcher("jsp/Create/NextPage.jsp");
        disp.forward(request, response);
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
    

}
