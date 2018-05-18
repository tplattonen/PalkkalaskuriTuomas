package laskuri.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import laskuri.model.Palkka;
import laskuri.model.dao.PalkkaDAO;

public class Palkkatest {

	
	
	
	@Test
	public void testAddPalkka() throws SQLException{
		
		PalkkaDAO palkkadao = new PalkkaDAO();
		Palkka palkka = new Palkka(0, "Testeri", 1000, 800);
		palkkadao.addPalkka(palkka);
		
		List<Palkka> palkat = palkkadao.findAll();
		Assert.assertEquals(palkka.getNimi(), palkat.get(0).getNimi());
	
		
		
	}

}
