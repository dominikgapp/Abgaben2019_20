package maven;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Kunde {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	@Getter
	@Setter
	private String titelV; 
	@Getter
	@Setter
	private String vorname; 
	@Getter
	@Setter
	private String nachname; 
	@Getter
	@Setter
	private String titelN; 
	
	
	
	public Kunde() {
		super(); 
	}
	
	public Kunde (int id, String tv, String vn, String nn, String tn) {
		this.id = id; 
		this.titelV = tv; 
		this.vorname = vn; 
		this.nachname = nn; 
		this.titelN = tn; 
	}
	
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setTitelN(String titelN) {
		this.titelN = titelN;
	}
	
	public void setTitelV(String titelV) {
		this.titelV = titelV;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public long getId() {
		return id;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public String getTitelN() {
		return titelN;
	}
	
	public String getTitelV() {
		return titelV;
	}
	
	public String getVorname() {
		return vorname;
	}

}
