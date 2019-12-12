import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionProvider {
	
	static Connection con = null; 
	
	public static Connection getCon() {
		
		try {
		// Class.forName("org.postgres.Driver"); 
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bestellungen", "postgres", "DataPost123!"); 
		
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return con; 
	}
	
	
	public static void addKunde(String titelV, String vorname, String nachname, String titelN) throws SQLException {
		
		PreparedStatement pstatement = null; 
		pstatement = con.prepareStatement("INSERT INTO Kunde (titelV, vorname, nachname, titelN) VALUES (?,?,?,?)"); 
		
		pstatement.setString(1,titelV);
		pstatement.setString(2,vorname);
		pstatement.setString(3,nachname);
		pstatement.setString(4,titelN);
		
		pstatement.executeUpdate(); 
	}
	
	
	public static void deleteKunde(String name) throws SQLException {
		
		PreparedStatement pstatement = null; 
		pstatement = con.prepareStatement("DELETE FROM Kunde WHERE vorname = ?"); 
		
		pstatement.setString(1,name);

		pstatement.executeUpdate(); 
	}
	
	
	public static void addArtikel(String name, double preis) throws SQLException {
		
		PreparedStatement pstatement = null; 
		pstatement = con.prepareStatement("INSERT INTO Artikel (name, preis) VALUES (?,?)"); 
		
		pstatement.setString(1,name);
		pstatement.setDouble(2,preis);

		pstatement.executeUpdate(); 
	}
	
	
	
	public static void deleteArtikel(String name) throws SQLException {
		
		PreparedStatement pstatement = null; 
		pstatement = con.prepareStatement("DELETE FROM Artikel WHERE name = ?"); 
		
		pstatement.setString(1,name);

		pstatement.executeUpdate(); 
	}
	
	
	public static void addAdresse(String stadt, String strasse, int plz, String hnr) throws SQLException {
		
		PreparedStatement pstatement = null; 
		pstatement = con.prepareStatement("INSERT INTO Adresse (stadt, strasse, plz, hnr) VALUES (?,?,?,?)");
		
		pstatement.setString(1,stadt);
		pstatement.setString(2,strasse);
		pstatement.setInt(3,plz);
		pstatement.setString(4,hnr);
		
		pstatement.executeUpdate(); 
	}
	
	
	public static void removeAdresse(String strasse, int plz, String hnr) throws SQLException {
	
		PreparedStatement pstatement = null; 
		pstatement = con.prepareStatement("DELETE FROM Adresse WHERE strasse = ? AND plz = ? AND hnr = ?");
		
		pstatement.setString(1,strasse);
		pstatement.setInt(2, plz);
		pstatement.setString(3, hnr);
		
		
		pstatement.executeUpdate();	
	}
	
	
	public static void getKunden() throws SQLException {
		
		Statement st = con.createStatement(); 
		String SQL = "Select * from Kunde"; 
		
		ResultSet rs = st.executeQuery(SQL); 
		
		while (rs.next()) {
			int id = rs.getInt("id"); 
			String titelV = rs.getString("titelV"); 
			String vorname = rs.getString("vorname"); 
			String nachname = rs.getString("nachname"); 
			String titelN = rs.getString("titelN"); 
			
			System.out.print(id +" ");
			System.out.print(titelV +" ");
			System.out.print(vorname +" ");
			System.out.print(nachname +" ");
			System.out.print(titelN +" ");
			
			System.out.println();
			
		}
	}
	
	public void changePrice (String artikel, double preis) throws SQLException {
	
		PreparedStatement pstatement = null;
		pstatement = con.prepareStatement("UPDATE artikel SET preis = ? WHERE name = ?"); 
		
		pstatement.setDouble(1, preis);
		pstatement.setString(2, artikel);	
		
		pstatement.executeUpdate();
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
		
		Statement st = con.createStatement(); 
		String SQL = "Select * from artikel"; 
		
		ResultSet rs = st.executeQuery(SQL); 
		
		while (rs.next()) {
			int id = rs.getInt("id"); 
			String name = rs.getString("name"); 
			double preis = rs.getDouble("preis"); 
			
			System.out.print(id +" ");
			System.out.print(name +" ");
			System.out.print(preis +" ");
			
			System.out.println();
			
		}
	}
	
	
	public void changeLastName (String vorname, String nachname, String newname) throws SQLException {
		
		PreparedStatement pstatement = null;
		pstatement = con.prepareStatement("UPDATE Kunde SET nachname = ? WHERE vorname = ? AND nachname = ?");
		
		pstatement.setString(1, newname);
		pstatement.setString(2, vorname);
		pstatement.setString(3, nachname);
		
		pstatement.executeUpdate();
	}
	
	
	public void changeTitelV (String vorname, String nachname, String newtitle) throws SQLException {
		
		PreparedStatement pstatement = null;
		pstatement = con.prepareStatement("UPDATE Kunde SET TitelV = ? WHERE vorname = ? AND nachname = ?");
		
		pstatement.setString(1, newtitle);
		pstatement.setString(2, vorname);
		pstatement.setString(3, nachname);
		
		pstatement.executeUpdate();
	}
	
	
	public void changeTitelN (String vorname, String nachname, String newtitle) throws SQLException {
		
		PreparedStatement pstatement = null;
		pstatement = con.prepareStatement("UPDATE Kunde SET TitelN= ? WHERE vorname = ? AND nachname = ?");
		
		pstatement.setString(1, newtitle);
		pstatement.setString(2, vorname);
		pstatement.setString(3, nachname);
		
		pstatement.executeUpdate();
	}
	
	
	public void newBestellung (String vorname, String nachname, String artikel, String adresse, int plz) throws SQLException {
		
		PreparedStatement pstatement = null;
		pstatement = con.prepareStatement("SELECT id FROM Kunde WHERE vorname = ? AND nachname = ?");
		
		pstatement.setString(1, vorname);
		pstatement.setString(2, nachname);
		
		ResultSet rs = pstatement.executeQuery(); 
		int Kunden_id = -100;  
		while (rs.next()) {
			Kunden_id = rs.getInt("id"); 
		}
		
		PreparedStatement prstatement = null;
		prstatement = con.prepareStatement("SELECT id FROM adresse WHERE strasse = ? AND plz = ?");
		
		prstatement.setString(1, adresse);
		prstatement.setInt(2, plz);
		
		ResultSet rs1 = prstatement.executeQuery(); 
		
		int adresse_id = -100; 
		while (rs1.next()) {
			adresse_id = rs1.getInt("id"); 
		}
		
		
		PreparedStatement ps = null; 
		ps = con.prepareStatement("INSERT INTO bestellung (kunde_id, adresse_rechnung_id, adresse_liefer_id) VALUES (?,?,?)"); 
		
		ps.setInt(1, Kunden_id);
		ps.setInt(2, adresse_id);
		ps.setInt(3, adresse_id);
		
		ps.executeUpdate(); 
	}
}
