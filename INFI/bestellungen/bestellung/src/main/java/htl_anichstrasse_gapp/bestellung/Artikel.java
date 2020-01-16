package htl_anichstrasse_gapp.bestellung;

import javax.persistence.Entity;

@Entity
public class Artikel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO); 

}
