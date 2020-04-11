
public class Context {

	private IStrategy strategy; 
	
	public Context (IStrategy s) {
		this.strategy = s; 
	}
	
	
	public void executeStrategy () {
		strategy.changeGear();
	}
}
