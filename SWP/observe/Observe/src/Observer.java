
public class Observer implements IObserver {

	private int IntValue; 
	private String name; 
	
	
	
	public Observer(int sv, String n) {
		this.IntValue = sv; 
		this.name = n; 
	}
	
	@Override
	public int getIntValue() {
		return this.IntValue; 
		
	}
	
	@Override
	public void update(int i) {
		System.out.println("hey "+ name+ " value has changed: " +i);	
	}
	
	
}