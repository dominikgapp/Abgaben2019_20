
public class Client {
	
	public static void main(String[] args) {
		
	
	Stock stock = new Stock(); 
	
	ICommand takeShirt = new TakeShirtCommand(stock); 
	ICommand addShirt = new AddShirtCommand(stock); 
	
	Invoker Lager = new Invoker(); 
	
	
	System.out.println(stock.getStock());
	Lager.setCommand(takeShirt);
	Lager.executeCommand();
	System.out.println(stock.getStock());
	Lager.redoCommand();
	System.out.println(stock.getStock());
	
	}
}
