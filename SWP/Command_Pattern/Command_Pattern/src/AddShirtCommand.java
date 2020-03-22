
public class AddShirtCommand implements ICommand {
	
	Stock stock; 
	
	public AddShirtCommand (Stock s) {
		this.stock = s; 	
	}
	
	
	public void execute () {
		stock.addOne();
		System.out.println("Shirt added to the stock, the stock is now: " + stock.getStock());
	}
	
	
	public void undo () {
		stock.takeOne();
		System.out.println("UNDO: the stock is now: " + stock.getStock());
	}
	

	public void redo () {
		this.execute();
	}
}
