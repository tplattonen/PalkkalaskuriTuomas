package laskuri.test;

import java.sql.SQLException;

import laskuri.model.Palkka;
import laskuri.model.dao.PalkkaDAO;


public class PalkkaDAOTest {

	public static void main(String[] args) throws SQLException {
		PalkkaDAO palkkadao = new PalkkaDAO();
		
		//Palkka palkka = new Palkka();
		palkkadao.removePalkka(4);	
		System.out.println("Moikka");
		 
			//addPalkka metodin testaus
			//Palkka palkka = new Palkka(0, "TesteriKaksi", 2000, 1333.33);
			//palkkadao.addPalkka(palkka);
	
		
	}

}
