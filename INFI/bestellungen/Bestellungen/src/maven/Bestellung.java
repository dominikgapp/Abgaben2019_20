package maven;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Bestellung {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OneToMany(mappedBy = "bestell_id")
	@Getter
	@Setter
	private int id; 
	@ManyToOne
	@Getter
	@Setter
	private Kunde kunde; 
	@ManyToOne
	@JoinColumn(name ="adresse_rechnung")
	@Getter
	@Setter
	private Adresse adresse_rechnung_id;
	@ManyToOne
	@JoinColumn(name="adresse_lieferung")
	@Getter
	@Setter
	private Adresse  adresse_lieferung_id; 
	
	public  Bestellung() {
		super(); 
	}
	
	public Bestellung(int id, Kunde k, Adresse lid, Adresse rid) {
		this.id= id; 
		this.kunde = k; 
		this.adresse_lieferung_id = lid; 
		this.adresse_rechnung_id = rid; 
	}
	
	public void setAdresse_lieferung_id(Adresse adresse_lieferung_id) {
		this.adresse_lieferung_id = adresse_lieferung_id;
	}
	
	public void setAdresse_rechnung_id(Adresse adresse_rechnung_id) {
		this.adresse_rechnung_id = adresse_rechnung_id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	
	public Adresse getAdresse_lieferung_id() {
		return adresse_lieferung_id;
	}
	
	public Adresse getAdresse_rechnung_id() {
		return adresse_rechnung_id;
	}
	
	public Kunde getKunde() {
		return kunde;
	}
	
	public int getId() {
		return id;
	}

}
