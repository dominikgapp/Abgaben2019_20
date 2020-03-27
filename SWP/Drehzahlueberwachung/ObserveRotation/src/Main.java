
public class Main {
	
	public static void main(String[] args) {
		
		
		Observer observer = new Observer(6000); 
		Observable rotSpeed = new Observable(); 
		
		rotSpeed.addSubscriber(observer);
		
		for (int i = 0; i < 20000; i = i+500) {
			
			rotSpeed.setValue(i);
			System.out.println(i);
			if (i == observer.getLimit()+500) break;
		}
		
	}

}
