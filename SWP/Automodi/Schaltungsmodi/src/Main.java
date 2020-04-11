
public class Main {

	
	public static void main(String[] args) {
		
		
		Context contextSport = new Context(new Sportmodus()); 
		Context contextStandart = new Context (new Standartmodus()); 
		
		
		System.out.println("Schalten im Sportmodus:");
		contextSport.executeStrategy();
		System.out.println();
		
		System.out.println("Schalten im Standartmodus: ");
		contextStandart.executeStrategy();
	}
}
