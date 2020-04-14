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

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
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
		
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/...", "postgres", "DataPost123!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String Query = "SELECT * FROM benutzer WHERE username = ?"; 
		String ent = "INSERT into benutzer (username, admin, password, isblocked) VALUES (?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(Query);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery(); 
			
			if (rs.next()) {
				response.sendRedirect("registrieren.jsp");
			}else {
				PreparedStatement ps = con.prepareStatement(ent); 
				ps.setString(1, name); 
				ps.setBoolean(2, false);
				ps.setString(3, password);
				ps.setBoolean(4, false);
				ps.executeUpdate(); 
				
				RequestDispatcher d = request.getRequestDispatcher("login.jsp"); 
				d.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
