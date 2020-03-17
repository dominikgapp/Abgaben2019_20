import java.util.Scanner;

public class State4 implements IState {

	@Override
	public void goNext(Context context) {
		
		 
		System.out.println("Geben Sie ihre Versicherungsnummer an. ");
		
		String number = Input.getInstance().scan("l"); 
		
		if (number.length() == 10 || number.length() == 11) {
			System.out.println("Vielen Dank, Nehmen Sie im Wartezimmer Platz.");
			context.setState(new State1());
			System.out.println(); 
			System.out.println("Nächster Patient! ");
			System.out.println();
			System.out.println();
			//context.setrunning(false);
		} else {
			System.out.println("Überprüfen Sie ihre eingabe.");
			System.out.println();
			context.setState(new State4());
		}
			
		
	}

}
