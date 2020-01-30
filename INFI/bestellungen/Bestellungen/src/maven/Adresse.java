package maven;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

@Entity
public class Adresse {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	@Getter
	@Setter
	private String stadt; 
	@Getter
	@Setter
	private int plz; 
	@Getter
	@Setter
	private String strasse; 
	@Getter
	@Setter
	private String hnr; 
	
	
	
	public Adresse() {
		super(); 
	}
	
	public Adresse (int id, String stadt, int plz, String strasse, String hn) {
		this.id = id; 
		this.plz = plz; 
		this.stadt = stadt; 
		this.hnr = hn; 
		this.strasse = strasse; 
	}
	
	
	public String getHnr() {
		return hnr;
	}
	
	public long getId() {
		return id;
	}
	
	public int getPlz() {
		return plz;
	}
	
	public String getStadt() {
		return stadt;
	}
	
	public String getStrasse() {
		return strasse;
	}
	
	public void setHnr(String hnr) {
		this.hnr = hnr;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setPlz(int plz) {
		this.plz = plz;
	}
	
	public void setStadt(String stadt) {
		this.stadt = stadt;
	}
	
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

}
