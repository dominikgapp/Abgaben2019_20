import java.util.Scanner;

public class Input {

	
	private static Input instance; 
	Scanner scanner; 
	
	private Input () {
		 scanner = new Scanner(System.in); 
	}
	
	
	public static Input getInstance () {
		
		if (instance == null) {
			instance = new Input(); 
		}
		
		return instance; 
	}
	
	
	public String scan(String n) {
		 
		
		String input = scanner.nextLine();
		return input; 
		
	}
	
	public int scan(int n) {
		
		int input = scanner.nextInt();
		return input; 
		
	}
}
