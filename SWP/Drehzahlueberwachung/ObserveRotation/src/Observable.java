import java.util.ArrayList;

public class Observable {
	
	private ArrayList<IObserver> observers; 
	private int value; 

	
	public Observable () {
		observers = new ArrayList<IObserver>(); 
	}
	
	
	public void addSubscriber (IObserver o) {
		observers.add(o); 
	}
	
	public void deleteSubscriber (IObserver o) {
		observers.remove(o); 
	}
	
	public void notifyAllObservers (int value) {
		
		for (int i = 0; i < observers.size(); i++) {
			
			if (observers.get(i).getLimit() < value) {
				observers.get(i).update(value);
			}
		}
	}
	
	
	public void setValue (int i) {
		this.value = i; 
		notifyAllObservers(i);
	}
}