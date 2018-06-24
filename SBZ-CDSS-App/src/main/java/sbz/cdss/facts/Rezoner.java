package sbz.cdss.facts;

import java.util.ArrayList;
import java.util.List;

public class Rezoner {

	private Bolest prvaGrupa;
	private List<Bolest> drugaGrupa;
	private Bolest trecaGrupa;
	
	public Rezoner() {
		this.drugaGrupa = new ArrayList<>();
	}
	
	public Rezoner(Bolest prvaGrupa, List<Bolest> drugaGrupa, Bolest trecaGrupa) {
		super();
		this.prvaGrupa = prvaGrupa;
		this.drugaGrupa = drugaGrupa;
		this.trecaGrupa = trecaGrupa;
	}

	public Bolest getPrvaGrupa() {
		return prvaGrupa;
	}

	public void setPrvaGrupa(Bolest prvaGrupa) {
		this.prvaGrupa = prvaGrupa;
	}

	public List<Bolest> getDrugaGrupa() {
		return drugaGrupa;
	}

	public void setDrugaGrupa(List<Bolest> drugaGrupa) {
		this.drugaGrupa = drugaGrupa;
	}

	public Bolest getTrecaGrupa() {
		return trecaGrupa;
	}

	public void setTrecaGrupa(Bolest trecaGrupa) {
		this.trecaGrupa = trecaGrupa;
	}
	
}
