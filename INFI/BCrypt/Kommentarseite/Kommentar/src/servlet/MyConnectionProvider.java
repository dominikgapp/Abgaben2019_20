package servlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnectionProvider {

	static Connection con = null; 
	
	public static Connection getCon() {
		
		try {
			
			Class.forName("org.postgres.Driver"); 
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/comments", "postgres", "DataPost123!");
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return con; 
	}
}
