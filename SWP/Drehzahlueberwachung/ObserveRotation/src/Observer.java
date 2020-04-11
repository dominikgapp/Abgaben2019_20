
public class Observer implements IObserver{

	private int limit; 
	
	
	public Observer(int i) {
		this.limit = i; 
	}
	
	@Override
	public int getLimit() {
		return this.limit;
	}

	@Override
	public void update(int i) {
		System.out.println("WARNING: the rotational speed exceeded the limit! Speed: " +i);
	}

	
	
}