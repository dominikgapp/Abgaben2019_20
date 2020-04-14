package web;

public class DBManager {
	
	
	private String pw; 
	private String name; 
	private String driver; 
	private String url; 
	private static DBManager instance; 
	
	public static DBManager getInstance() {
		
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
	
	
	public static void getConnection() {
		
	}
	
	public static void releaseConnection() {
		
	}

}
