package maven;

import java.sql.SQLException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class APP {
	
	public static void main(String[] args) throws SQLException {
		
		while(true)
		{
		
		int auswahl = 0; 
		
		do {
			
			
			Scanner input = new Scanner(System.in); 
			
			
			System.out.println("Menü: ");
			System.out.println("Bitte entscheiden Sie sich, was sie bearbeiten wollen. ");
			
			System.out.println("1: Kunde");
			System.out.println("2: Adresse");
			System.out.println("3: Bestellung");
			System.out.println("4: Artikel");
			System.out.println("");
			
			System.out.print("Eingabe: ");
			
			auswahl = input.nextInt(); 
				
		} while (auswahl < 1 && auswahl > 4 ); 
		
		
		switch (auswahl)
		{
		
			case 1: MenuErweit.method("Kunde"); break; 
			case 2: MenuErweit.method("Adresse"); break; 
			case 3: MenuErweit.method("Bestellung"); break; 
			case 4: MenuErweit.method("Artikel"); break; 
				
		
		}
		
	}
	}

}
