package laskuri.model;

public class Palkka {
	
	private int palkkaid;
	private String nimi;
	private double brutto;
	private double netto;
	
	public Palkka(int palkkaid, String nimi, double brutto, double netto) {
		super();
		this.palkkaid = palkkaid;
		this.nimi = nimi;
		this.brutto = brutto;
		this.netto = netto;
	}
	
	public Palkka() {
		this.palkkaid = 0;
		this.nimi = null;
		this.brutto = 0;
		this.netto = 0;
		
	}
	

	public String getNimi() {
		return nimi;
	}

	public int getPalkkaId() {
		return palkkaid;
	}

	public double getNetto() {
		return netto;
	}

	public double getBrutto() {
		return brutto;
	}
	
	

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public void setPalkkaId(int palkkaid) {
		this.palkkaid = palkkaid;
	}

	public void setNetto(double netto) {
		this.netto = netto;
	}

	public void setBrutto(double brutto) {
		this.brutto = brutto;
	}

	@Override
	public String toString() {
		return "Palkka [palkkaId=" + palkkaid + ", nimi=" + nimi + ", netto=" + netto + ", brutto=" + brutto + "]";
	}

	
	
}
