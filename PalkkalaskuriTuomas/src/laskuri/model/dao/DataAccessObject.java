package laskuri.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataAccessObject {
	/**
	 * Antaa tietokantayhteyden
	 * 
	 * @return connTietokantayhteys
	 */
	protected static Connection getConnection() {
		Connection connection = null;			

		// Alkumääritykset
		String username = "a1704573";  
		// dbkäyttäjätunnuksesi on tässä a-alkuinen opiskelijanumerosi 
		
		String password = "fuDEMt92r";
		String url = "jdbc:mysql://localhost:3306/a1704573";
		// tietokantasi nimi on tässä a-alkuinen opiskelijanumerosi

		try {
			// Ladataan ajuri
			Class.forName("org.mariadb.jdbc.Driver").newInstance();

			// Avataan yhteys connection-nimiseen muuttujaan
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return connection;
	}

	/**
	 * Sulkee Statementin ja Connectionin
	 * 
	 * @param SQL
	 *            -statement
	 * @param Tietokantayhteys
	 */
	protected static void close(Statement stmt, Connection connection) {
		close(null, stmt, connection);
	}

	/**
	 * Sulkee ResultSetin, Statementin ja Connectionin
	 */
	protected static void close(ResultSet rs, Statement stmt, Connection conn) {

		try {
			if (rs != null) { // Suljetaan rs (palautettu tulostaulu), mik�li
								// olemassa
				rs.close();
			}
			if (stmt != null) { // Suljetaan stmt (SQL-statement), mik�li
								// olemassa
				stmt.close();
			}
			if (conn != null) { // Suljetaan conn (yhteys), mik�li olemassa
				conn.close();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

