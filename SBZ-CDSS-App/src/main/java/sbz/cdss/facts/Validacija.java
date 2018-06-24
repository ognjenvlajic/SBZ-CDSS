package sbz.cdss.facts;

import java.util.ArrayList;
import java.util.List;

public class Validacija {
	
	private List<String> lekovi;
	private List<String> sastojci;
	
	public Validacija() {
		this.lekovi = new ArrayList<>();
		this.sastojci = new ArrayList<>();
	}

	public Validacija(List<String> lekovi, List<String> sastojci) {
		super();
		this.lekovi = lekovi;
		this.sastojci = sastojci;
	}

	public List<String> getLekovi() {
		return lekovi;
	}

	public void setLekovi(List<String> lekovi) {
		this.lekovi = lekovi;
	}

	public List<String> getSastojci() {
		return sastojci;
	}

	public void setSastojci(List<String> sastojci) {
		this.sastojci = sastojci;
	}
	
}
