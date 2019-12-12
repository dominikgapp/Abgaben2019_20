package singleton;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import singleton.Logger.LogLevel;

public class Main {

	
	public static void main(String[] args) throws IOException, SQLException{
		
		/*Logger.getInstance().setLvl(LogLevel.INFO);
		
		Logger.getInstance().log("ERROR", LogLevel.ERROR);
		Logger.getInstance().log("INFO", LogLevel.INFO);
		Logger.getInstance().log("DEBUG", LogLevel.DEBUG);
		Logger.getInstance().log("WARNING", LogLevel.WARN);
		*/
		Logger.getInstance().calculate(5, 4);
		
		
		
		
	}
	
	 
	
}
