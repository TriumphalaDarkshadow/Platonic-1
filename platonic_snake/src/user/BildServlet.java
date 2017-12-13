package user;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class BildServlet
 */
@WebServlet("/BildServlet")
@MultipartConfig

public class BildServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BildServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT photo FROM users WHERE username = ?") ) {
			pstmt.setString(1, username);
			try (ResultSet rs = pstmt.executeQuery()) {
			
				if (rs != null && rs.next()) {
					Blob bild = rs.getBlob("photo");
					response.reset();
					long length = bild.length();
					response.setHeader("Content-Length",String.valueOf(length));
					
					try (InputStream in = bild.getBinaryStream()) {
						final int bufferSize = 256;
						byte[] buffer = new byte[bufferSize];
						
						ServletOutputStream out = response.getOutputStream();
						while ((length = in.read(buffer)) != -1) {
							out.write(buffer,0,(int) length);
						}
						out.flush();
					}
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
