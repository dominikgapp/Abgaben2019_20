package tirol_htl_anichstrasse.jpa_test;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Person {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private int age; 
	private String first_name; 
	private String last_name; 
	
	private Hobby hobby; 
	
	@Transient
	private long aliveSince; 
	
	public Person() {
		super(); 
	}
	
	public Person(long id, int age, String fn, String ln, Hobby h) {
		this.id = id; 
		this.age = age; 
		this.first_name = fn;
		this.last_name = ln; 
		this.aliveSince = System.currentTimeMillis(); 
		this.hobby = h; 
	}
	
	public int getAge() {
		return age;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public long getId() {
		return id;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	public long getAliveSince() {
		return aliveSince;
	}
	
	public Hobby getHobby() {
		return hobby;
	}
	
	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}
	
	
	
}
