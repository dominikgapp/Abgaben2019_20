package servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserImp {
	
	
	static Connection con; 
	static PreparedStatement ps; 
	
	public int InsertUser (User u) {
		
		int status = 0; 
		
		try {
			
			con = MyConnectionProvider.getCon(); 
			ps = con.prepareStatement("insert into user valued(?,?)"); 
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			
			status = ps.executeUpdate(); 
			con.close();
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return status; 
	}

}
