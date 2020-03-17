import java.util.Scanner;
import java.util.regex.Pattern;

public class State1 implements IState {

	@Override
	public void goNext(Context context) {
		
		
		System.out.println("Bitte geben Sie ihren Vornamen und Nachnamen an.");
		
		//String name = scanner.nextLine(); 
		
		String name = Input.getInstance().scan("l"); 
		
		boolean number = containsNumber(name); 
		//scanner.close();
		
		if (number == true) {
			System.out.println("Überprüfen Sie bitte Ihre Eingabe.");
			context.setState(new State1());
		}else if (number == false) {
			System.out.println("Hallo " +name);
			System.out.println();
			context.setState(new State2());
			
		}
			
	}
	
	
	public boolean containsNumber (String input) {
		
		return Pattern.compile( "[0-9]" ).matcher( input ).find();
	}

}
