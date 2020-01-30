package maven;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.eclipse.persistence.jpa.rs.util.CollectionProxy;

public class MenuErweit {

	
	public static void method (String auswahl) throws SQLException {
		
		
		
		
		while(true)
		{
			
		int eingabe = 0; 
		do {
			
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("");
			System.out.println("Erweitertes Menü für "+auswahl+": ");
			System.out.println("");
			System.out.println("Was wollen Sie durchführen?");
			
			System.out.println("1: " +auswahl+ " anlegen");
			System.out.println("2: " +auswahl+ " löschen");
			System.out.println("3: " +auswahl+ " auslesen");
			System.out.println("4: " +auswahl+ " ändern");
			System.out.println("");
			
			System.out.print("Eingabe: ");
			System.out.println("");
			
			eingabe = input.nextInt(); 
		
			
			} while (eingabe < 1 && eingabe > 4 ); 
		
		
		if (eingabe == 1) {
			if (auswahl.equals("Kunde")) kundenAnlegen(); 
			if (auswahl.equals("Artikel")) artikelAnlegen(); 
			if (auswahl.equals("Adresse")) adresseAnlegen(); 
			if (auswahl.equals("Bestellung")) bestellungAnlegen(); 
			
		}else if (eingabe == 2) {
			if (auswahl.equals("Kunden")) kundenLoeschen(); 
			if (auswahl.equals("Artikel")) artikelLoeschen(); 
			if (auswahl.equals("Adresse")) adresseLoeschen(); 
			if (auswahl.equals("Bestellung")) bestellungLoeschen(); 
			
		}else if (eingabe == 3) {
			if (auswahl.equals("Kunden")) getKunden(); 
			if (auswahl.equals("Artikel")) getArtikel(); 
			if (auswahl.equals("Adresse")) getAdresse(); 
			if (auswahl.equals("Bestellung")) getBestellungen(); 
			
		}else if (eingabe == 4) {
			if (auswahl.equals("Kunden")) updateKunde(); 
			if (auswahl.equals("Artikel")) updateArtikel();  
		}
		
		
		}
	}


	private static void updateArtikel() throws SQLException {
		
		while(true)
		{
		
		int id; 
		String bez; 
		double preis; 
		String neu; 
		int auswahl = 0; 
		do {
			Scanner input = new Scanner(System.in);

			System.out.println("Was möchten Sie abändern? ");
			System.out.println("1: Preis: "); 
			System.out.println("2: Bezeichnung: ");
			
			auswahl = input.nextInt(); 
			
			
			}while (auswahl < 1 && auswahl >2); 
		
		if (auswahl == 1) {
			Scanner input = new Scanner(System.in); 
			System.out.println("ID des Artikels: "); 
			id = input.nextInt(); 
			System.out.println("neuer Preis: "); 
			preis = input.nextDouble(); 
			
			ConnectionProvider.changePrice(id, preis);
			
		}else if (auswahl == 2) {
			Scanner input = new Scanner(System.in); 
			System.out.println("ID des Artikels: "); 
			id = input.nextInt(); 
			System.out.println("neue Bezeichnung: "); 
			neu = input.next(); 
			
			ConnectionProvider.changeBezeichnung(id, neu); 
		}
		
		}
		
	}

	private static void updateKunde() throws SQLException {
		
		while(true)
		{
		 
		int id; 
		String nn; 
		String nnn; 
		String tneu; 
		String vn;
		int auswahl = 0; 
		do {
		Scanner input = new Scanner(System.in);

		System.out.println("Was möchten Sie abändern? ");
		System.out.println("1: Nachname: "); 
		System.out.println("2: Titel nach: ");
		
		auswahl = input.nextInt(); 
		
		
		}while (auswahl < 1 && auswahl >2); 
		
		
		if (auswahl == 1) {
			Scanner input = new Scanner(System.in); 
			System.out.println("ID des Kunden: "); 
			id = input.nextInt(); 
			System.out.println("neuer Nachname: "); 
			nnn = input.next(); 
			
			ConnectionProvider.changeLastName(id, nnn);	
		}else if (auswahl == 2) {
			Scanner input = new Scanner(System.in);
			
			System.out.println("ID des Kunden: ");
			id = input.nextInt(); 
			System.out.println("neuer Titel: "); 
			tneu = input.next(); 
			
			
			
			ConnectionProvider.changeTitelN(id, tneu);
		}
		
		}
		
	}

	private static void getBestellungen() {
		ConnectionProvider.getBestellungen(); 
		
	}

	private static void getAdresse() {

		ConnectionProvider.getAdresse(); 
	}

	private static void getArtikel() throws SQLException {
		ConnectionProvider.getArtikel();
		
	}

	private static void getKunden() throws SQLException {
		ConnectionProvider.getKunden();
		
	}

	private static void bestellungLoeschen() {
		 
		
	}

	private static void adresseLoeschen() throws SQLException {
		
		
		while (true) {
			
	
		int id;	
		
		Scanner input = new Scanner(System.in);
		 
		System.out.println("Welchen Adresse möchten Sie entfernen? ");
		System.out.println("ID der Adresse: ");
		id = input.nextInt(); 
		
		
		ConnectionProvider.removeAdresse(id);
		
		}
		
	}

	private static void artikelLoeschen() throws SQLException {
		
		
		while (true) {
		Scanner input = new Scanner(System.in);
		int id;  
		System.out.println("Welchen Artikel möchten Sie entfernen? ");
		System.out.println("ID: ");
		id = input.nextInt(); 
		
		ConnectionProvider.deleteArtikel(id);
		}
		
	}

	private static void kundenLoeschen() throws SQLException {
		
		while (true) {
		Scanner input = new Scanner(System.in);
		String vn; 
		String nn; 
		int id; 
		
		System.out.println("Welchen Kunden möchten Sie entfernen? ");
		System.out.println("ID des Kunden: ");
		id = input.nextInt();
		
		ConnectionProvider.deleteKunde(id); //enventuell noch Nachname hinzufügen! 
		}
	}

	private static void bestellungAnlegen() throws SQLException {
	

		while (true) {
		
			int id; 
			int idal; 
			int idar; 
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("ID des Kunden: ");
		id = input.nextInt();
		System.out.println("ID der Lieferdresse: ");
		idal = input.nextInt(); 
		System.out.println("ID der Rechnungsdresse: ");
		idar = input.nextInt(); 
		
		ConnectionProvider.newBestellung(id, idal, idar);
		
		
		}
		
	}

	private static void adresseAnlegen() throws SQLException {
		
		while (true) {
		String stadt; 
		int plz; 
		String strasse; 
		String hnr; 
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Straße: ");
		strasse = input.next();
		System.out.println("Stadt: ");
		stadt = input.next(); 
		System.out.println("PLZ: ");
		plz = input.nextInt(); 
		System.out.println("Hausnummer: ");
		hnr = input.next(); 
		
		ConnectionProvider.addAdresse(stadt, strasse, plz, hnr);
		
		}
		
	}

	private static void artikelAnlegen() throws SQLException {
		
		while (true) {
		String bezeichnung; 
		double preis; 
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Bezeichnung: ");
		bezeichnung = input.next();
		System.out.println("Preis: ");
		preis = input.nextDouble(); 
		
		ConnectionProvider.addArtikel(bezeichnung, preis);
		}
		
	}

	private static void kundenAnlegen() throws SQLException {
		
		while (true) {
		String vorname; 
		String nachname; 
		String tv; 
		String tn; 
		
		Scanner input = new Scanner(System.in);
		System.out.print("Titel vor: ");
		tv = input.next(); 
		System.out.println("Vorname: ");
		vorname = input.next();
		System.out.println("Nachname: ");
		nachname = input.next();
		System.out.println("Titel nach: ");
		tn = input.next();
		
		ConnectionProvider.addKunde(tv, vorname, nachname, tn);
		}
		
	}
}
