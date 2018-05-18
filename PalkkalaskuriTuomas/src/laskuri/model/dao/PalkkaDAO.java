package laskuri.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import laskuri.model.Palkka;

public class PalkkaDAO extends DataAccessObject {
	
	/**
	 * lisää Palkan tiedot tietokantaan
	 * 
	 * @param palkka
	 *            Palkka-luokan olio
	 * @throws SQLException 
	 */
	public void addPalkka(Palkka palkka) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
	

		try {
			// Luodaan yhteys ja aloitetaan transaktio:
			connection = getConnection();
			//Luodaan uusi palkka tietokantaan:
			String sqlInsert = "INSERT INTO laskuri(palkkaid, nimi, brutto, netto) VALUES (?, ?, ?, ?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setInt(1, palkka.getPalkkaId());
			stmtInsert.setString(2, palkka.getNimi());
			stmtInsert.setDouble(3, palkka.getBrutto());
			stmtInsert.setDouble(4, palkka.getNetto());
			
			stmtInsert.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); // Suljetaan statement ja yhteys
		}
	}
	/**
	 * Hakee tietokannan taulusta kaikki palkat ja luo ja palauttaa tiedot Palkka-tyyppisten olioiden listana (ArrayList) 
	 * 
	 * @return ArrayList<Palkka> Lista palkkoja
	 */
	public ArrayList<Palkka> findAll() {	
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Palkka> palkat = new ArrayList<Palkka>();
		Palkka palkka = null;
		try {
			// Luodaan yhteys
			conn = getConnection();
			// Luodaan komento: haetaan kaikki rivit palkka-taulusta
			String sqlSelect = "SELECT palkkaid, nimi, netto, brutto FROM laskuri;";
			// Valmistellaan komento:
			stmt = conn.prepareStatement(sqlSelect);
			// Lähetetään komento:
			rs = stmt.executeQuery();
			// Käydään tulostaulun rivit läpi ja luetaan readPalkka()-metodilla:
			while (rs.next()) {
				palkka = readPalkka(rs);
				// lisätään palkka listaan
				palkat.add(palkka);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn); // Suljetaan
		}
	
		return palkat;
	}

	/**
	 * Lukee tietokannasta taulusta yhden tietorivin (palkan tiedot). Luo ja palauttaa tietojen perusteella Palkka-tyyppisen olion
	 * 
	 * @param rs
	 *            tietokannasta kyselyllä haettu tulostaulu
	 * @return Palkka palkka-olio
	 */
	private Palkka readPalkka(ResultSet rs) {	
		try {
			// Haetaan yhden palkan tiedot kyselyn tulostaulun (ResultSet-tyyppinen rs-olion) aktiiviselta tietoriviltä
			int palkkaId = rs.getInt("palkkaid");
			String nimi = rs.getString("nimi");
			double netto = rs.getDouble("netto");
			double brutto = rs.getDouble("brutto");
		
			//  Luodaan ja palautetaan uusi palkka
			return new Palkka(palkkaId, nimi, netto, brutto);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void removePalkka(int palkkaid) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtDelete = null;

		try {
			// Luodaan yhteys
			connection = getConnection();
			//Poistetaan pizza tietokantasta:
			
			String sqlInsert = "DELETE FROM laskuri WHERE palkkaid = ?";
			stmtDelete = connection.prepareStatement(sqlInsert);
			stmtDelete.setInt(1, palkkaid);
			stmtDelete.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtDelete, connection); // Suljetaan statement ja yhteys
		}
	}
	
	public void updatePalkka(Palkka palkka) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtUpdate = null;
		
		try {
		
		connection = getConnection();
		
		String sql = "UPDATE laskuri SET nimi = ?, brutto = ?, netto = ? WHERE palkkaid = ?";
       
        
        stmtUpdate = connection.prepareStatement(sql);
        stmtUpdate.setInt(1, palkka.getPalkkaId());
        stmtUpdate.setString(2, palkka.getNimi());
        stmtUpdate.setDouble(3, palkka.getBrutto());
        stmtUpdate.setDouble(4, palkka.getNetto());
        
        stmtUpdate.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtUpdate, connection); // Suljetaan statement ja yhteys
		}   
    }
	
}


