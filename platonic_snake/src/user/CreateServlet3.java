package user;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.DataSource;

/**
 * Servlet implementation class UserCreationServlet
 */
@WebServlet("/UserCreationServlet")
@MultipartConfig

public class UserCreationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Resource(lookup="jdbc/MyTHIPool")
    private DataSource ds;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        
        UserBean user = new UserBean();
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setBirthday(request.getParameter("birthday"));
        user.setLocation(request.getParameter("location"));
        user.setInterests(request.getParameter("interests"));
        Part filePart = request.getPart("photo");
        user.setFilename(filePart.getSubmittedFileName());
        
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                InputStream in = filePart.getInputStream()){
                int i = 0;
                while ((i = in.read()) != -1) {
                    baos.write(i);
                }
                user.setPhoto(baos.toByteArray());
                baos.flush();
            }
            catch(IOException ex) {
                throw new ServletException(ex.getMessage());
            }
        persist(user);
        
        final HttpSession session = request.getSession();
        session.setAttribute("user", user);
        
        final RequestDispatcher disp = request.getRequestDispatcher("jsp/Create/SaveData.jsp");
        disp.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
    public void persist(UserBean user) throws ServletException {
        try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement("INSERT INTO users (username,email,password,birthday,location,interests,photo) VALUES (?,?,?,?,?,?,?)")){
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getBirthday());
            pstmt.setString(5, user.getLocation());
            pstmt.setString(6, user.getInterests());
            //pstmt.setString(7, user.getFilename());
            pstmt.setBytes(7, user.getPhoto());
            pstmt.executeUpdate();
            
        }
        catch(Exception ex) {
            throw new ServletException(ex.getMessage());
        }
        
    }

}



