import java.util.Scanner;

public class State2 implements IState {

	@Override
	public void goNext(Context context) {
		
		 
		System.out.println("Bitte geben Sie Ihr Alter an.");
		
		
		int age = Input.getInstance().scan(1); 
			
		if (age <= 0) {
			System.out.println("Überprüfen Sie bitte Ihre Eingabe.");
			context.setState(new State2());
			System.out.println();
		}else if (age > 0) {
			System.out.println("Vielen Dank, wir benötigen nur noch ein paar Informationen");
			System.out.println();
			context.setState(new State3());
		}
	}

}
