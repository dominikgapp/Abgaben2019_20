package maven;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Bestellung_Artikel {
	
	
	@Getter
	@Setter
	private int menge; 
	@ManyToOne
	@JoinColumn(name="bestell_id")
	@Getter
	@Setter
	private int bestell_id; 
	@ManyToOne 
	@JoinColumn(name = "artikel_id")
	@Getter
	@Setter
	private int artikel_id; 
	
	
	public Bestellung_Artikel() {
		super(); 
	}
	
	public Bestellung_Artikel(int menge, int bid, int aid) {
		this.menge = menge; 
		this.artikel_id=aid; 
		this.bestell_id=bid; 
	}

}
