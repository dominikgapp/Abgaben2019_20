package singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

	private static Logger instance; 
	PrintWriter writer; 
	LogLevel lvl; 
	public enum LogLevel {
		DEBUG,
		INFO,
		WARN,
		ERROR, 
	}
	 
	private Logger () throws IOException{
		writer = new PrintWriter(new FileWriter("log.txt"), true);
		lvl = LogLevel.DEBUG; 
	}
	
	
	public static Logger getInstance() throws IOException {
		
		if (instance == null) {
			instance = new Logger();  
		}
		
		return instance; 
	}
	
	
	public void log (String s, LogLevel level) {
		if (level.ordinal() >=  this.lvl.ordinal()) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy"); 
		writer.println(dtf.format(LocalDateTime.now()) + " " + s +" " + level.name()); 
		writer.flush();
		}
	}
	
	
	public void setLvl(LogLevel lvl) {
		this.lvl = lvl;
	}
	

	public void calculate(int a, int b) {
		System.out.println(a+b); 
	}
	
	
	
}
