
public class TakeShirtCommand implements ICommand {
 
	Stock stock; 
	
	public TakeShirtCommand (Stock s) {
		this.stock = s; 
	}
	
	
	public void execute() {
		stock.takeOne();
		System.out.println("Shirt taken from the stock, the stock is now: " + stock.getStock());
	}
	
	public void undo () {
		stock.addOne();
		System.out.println("UNDO: the stock is now: " + stock.getStock());
	}
	
	public void redo () {
		this.execute();
	}
	
	

}
