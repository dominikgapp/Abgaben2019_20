
public class Main {

	public static void main(String[] args) {
		
		Observer student = new Observer(45,"Toni"); 
		Observable heizung = new Observable(); 
		Observer teacher = new Observer(65,"Ali");
		
		
		heizung.subscribe(student);
		heizung.subscribe(teacher);
		
		heizung.setValue(50);
		heizung.setValue(100);
		
	}	
}
