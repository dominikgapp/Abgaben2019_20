import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
	
	private static String pw; 
	private static String name; 
	private static String driver; 
	private static String url; 
	private static DBManager instance; 
	static Connection con; 
	
	
	private DBManager () throws SQLException {
		
	}
	
	public static DBManager getInstance() throws SQLException {
		
		if (instance == null) {
			instance = new DBManager(); 
		}
		return instance; 
	}
	
	
	public void init(String pw, String name, String driver, String url) {
		
		this.pw = pw; 
		this.name = name; 
		this.driver = driver; 
		this.url = url; 
		
	}
	
	
	public static void aConnection() throws SQLException {
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/comments", "postgres", "DataPost123!"); 
	}
	
	public static void getConnection() throws SQLException {
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/comments", "postgres", "DataPost123!"); 
	}
	
	public static void releaseConnection() throws SQLException {
		
		if (con != null && ! con.isClosed()) {
			con.close();
		}
	}

}
