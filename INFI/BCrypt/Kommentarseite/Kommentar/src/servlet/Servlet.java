package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.DBManager;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	Connection con; 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("username"); 
		String pw = request.getParameter("password"); 
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
		String password = encoder.encode(pw); 
		
		if (name != null || pw != null) {
			
			
			
			try {
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/...", "postgres", "DataPost123!");
				String Query = "SELECT * FROM benutzer WHERE username = ?";
				PreparedStatement pst = con.prepareStatement(Query); 
				pst.setString(1, name);
			
				
				ResultSet rs = pst.executeQuery();
				
				if (rs.next() && encoder.matches(password, pw)) {
					RequestDispatcher d = request.getRequestDispatcher("file1.jsp"); 
					d.forward(request, response);
				}else {
					request.setAttribute("MSG", "Benutzername oder Password ist falsch!");
					RequestDispatcher d = request.getRequestDispatcher("login.jsp"); 
					d.forward(request, response);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
			
			
			
		}
		
		
		
	}

}