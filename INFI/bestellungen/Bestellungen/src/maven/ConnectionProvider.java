package maven;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ConnectionProvider {
	
	static Connection con = null; 
	
	/*
	public static Connection getCon() {
		
		try {
		// Class.forName("org.postgres.Driver"); 
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bestellungen", "postgres", "DataPost123!"); 
		
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return con; 
	}
	*/ 
	
	public static void addKunde(String titelV, String vorname, String nachname, String titelN) throws SQLException {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager();
        
        Kunde neu = new Kunde(); 
        neu.setNachname(nachname);
        neu.setTitelN(titelN);
        neu.setTitelV(titelV);
        neu.setVorname(vorname);
        
        manager.getTransaction().begin();
        manager.persist(neu);
        manager.getTransaction().commit();
		
	}
	
	
	public static void deleteKunde(int id) throws SQLException {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager();
        
        Kunde k = manager.find(Kunde.class, id); 
        
        manager.getTransaction().begin(); 
        manager.remove(k);
        manager.getTransaction().commit();
		
	}
	
	
	public static void addArtikel(String name, double preis) throws SQLException {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager();
        
		Artikel neu = new Artikel(); 
		
		neu.setBezeichnung(name);
		neu.setPreis(preis);
		
		manager.getTransaction().begin(); 
		manager.persist(neu);
		manager.getTransaction().commit();
		
	}
	
	
	
	public static void deleteArtikel(int id) throws SQLException {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager();
        
        Artikel a = manager.find(Artikel.class, id); 
        
        manager.getTransaction().begin();
        manager.remove(a);
        manager.getTransaction().commit();
		
	}
	
	
	public static void addAdresse(String stadt, String strasse, int plz, String hnr) throws SQLException {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager();
        
        Adresse neu = new Adresse(); 
        
        neu.setHnr(hnr);
        neu.setPlz(plz);
        neu.setStadt(stadt);
        neu.setStrasse(strasse);
        
        manager.getTransaction().begin();
        manager.persist(neu);
        manager.getTransaction().commit();
	}
	
	
	public static void removeAdresse(int id) throws SQLException {
	
		
	}
	
	
	public static void getKunden() throws SQLException {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager();
        
		CriteriaBuilder cb = manager.getCriteriaBuilder(); 
		CriteriaQuery<Kunde> k = cb.createQuery(Kunde.class); 
		Root<Kunde> r = k.from(Kunde.class); 
		CriteriaQuery<Kunde> alle = k.select(r); 
		TypedQuery<Kunde> tq = manager.createQuery(alle); 
	
		System.out.println(tq.getResultList());

	}
	
	public static void changePrice (int id, double preis) throws SQLException {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager();
        
        Artikel a = manager.find(Artikel.class, id);
        
        a.setPreis(preis);
		
	}
	
	
	
	public void changeFirstName (String vorname, String nachname, String newname) throws SQLException {
		
		PreparedStatement pstatement = null;
		pstatement = con.prepareStatement("UPDATE Kunde SET vorname = ? WHERE vorname = ? AND nachname = ?");
		
		pstatement.setString(1, newname);
		pstatement.setString(2, vorname);
		pstatement.setString(3, nachname);
		
		pstatement.executeUpdate();
	}

	
	
	public static void getArtikel() throws SQLException {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager();
        
		CriteriaBuilder cb = manager.getCriteriaBuilder(); 
		CriteriaQuery<Artikel> k = cb.createQuery(Artikel.class); 
		Root<Artikel> r = k.from(Artikel.class); 
		CriteriaQuery<Artikel> alle = k.select(r); 
		TypedQuery<Artikel> tq = manager.createQuery(alle); 
	
		System.out.println(tq.getResultList());
			
		
	}
	
	
	public static void changeLastName (int id, String newname) throws SQLException {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager();
        
        Kunde k = manager.find(Kunde.class, id); 
        k.setNachname(newname);
	}
	
	
	public static void changeTitelV (String vorname, String nachname, String newtitle) throws SQLException {
		
		PreparedStatement pstatement = null;
		pstatement = con.prepareStatement("UPDATE Kunde SET TitelV = ? WHERE vorname = ? AND nachname = ?");
		
		pstatement.setString(1, newtitle);
		pstatement.setString(2, vorname);
		pstatement.setString(3, nachname);
		
		pstatement.executeUpdate();
	}
	
	
	public static void changeTitelN (int id, String newtitle) throws SQLException {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager();
        
        Kunde k = manager.find(Kunde.class, id); 
        k.setTitelN(newtitle);
	}
	
	
	public static void newBestellung (int id, int idal, int idar) throws SQLException {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager();
        
        Bestellung be = new Bestellung(); 
        
        Kunde k = manager.find(Kunde.class, id); 
        Adresse l = manager.find(Adresse.class, idal);
        Adresse r = manager.find(Adresse.class, idar); 
        
        be.setAdresse_lieferung_id(l);
        be.setAdresse_rechnung_id(r);
        be.setKunde(k);
        
        manager.getTransaction().begin();
        manager.persist(be);
        manager.getTransaction().commit();
		
		
		
	}


	public static void changeBezeichnung(int id, String neu) {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager();
        
        Artikel a = manager.find(Artikel.class, id);
        
        a.setBezeichnung(neu);
		
	}


	public static void getBestellungen() {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager();
        
		CriteriaBuilder cb = manager.getCriteriaBuilder(); 
		CriteriaQuery<Bestellung> k = cb.createQuery(Bestellung.class); 
		Root<Bestellung> r = k.from(Bestellung.class); 
		CriteriaQuery<Bestellung> alle = k.select(r); 
		TypedQuery<Bestellung> tq = manager.createQuery(alle); 
	
		System.out.println(tq.getResultList());
		
	}


	public static void getAdresse() {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit"); 
        EntityManager manager = f.createEntityManager();
        
		CriteriaBuilder cb = manager.getCriteriaBuilder(); 
		CriteriaQuery<Adresse> k = cb.createQuery(Adresse.class); 
		Root<Adresse> r = k.from(Adresse.class); 
		CriteriaQuery<Adresse> alle = k.select(r); 
		TypedQuery<Adresse> tq = manager.createQuery(alle); 
	
		System.out.println(tq.getResultList());
		
	}
}
