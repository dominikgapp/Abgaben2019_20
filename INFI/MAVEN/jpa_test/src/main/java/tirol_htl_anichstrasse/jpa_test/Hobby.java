package tirol_htl_anichstrasse.jpa_test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Entity
public class Hobby {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	private long id; 
	@Getter
	@Setter
	private String name; 
	@Getter
	@Setter
	private int hoursPerWeek; 
	@Getter
	@Setter
	private double expenses; 
	
	public Hobby() {
		super(); 
	}
	
	public Hobby (String name, int hpw, double expenses) { 
		this.name = name; 
		this.hoursPerWeek = hpw; 
		this.expenses = expenses; 
	}

}
