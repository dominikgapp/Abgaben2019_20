package maven;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;


@Entity 
public class Artikel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OneToMany(mappedBy = "artikel_id")
	@Getter
	@Setter
	private long id;
	@Getter
	@Setter
	private String bezeichnung; 
	@Getter
	@Setter
	private double preis; 
	
	
	public Artikel() {
		super(); 
	}
	
	
	public Artikel (int id, String bez, double p) {
		this.id = id; 
		this.bezeichnung = bez; 
		this.preis = p; 
	}
	
	
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	public String getBezeichnung() {
		return bezeichnung;
	}
	
	public double getPreis() {
		return preis;
	}
	
	
	public long getId() {
		return id;
	}
	
	
}
