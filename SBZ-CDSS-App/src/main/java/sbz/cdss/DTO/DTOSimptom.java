package sbz.cdss.DTO;

import java.util.List;

import sbz.cdss.facts.Simptom;

public class DTOSimptom {

	private Long id;
	private String naziv;
	private int minVrednost;
	private int maxVrednost;
	
	public DTOSimptom() {}

	public DTOSimptom(Long id, String naziv, int minVrednost, int maxVrednost) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.minVrednost = minVrednost;
		this.maxVrednost = maxVrednost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getMinVrednost() {
		return minVrednost;
	}

	public void setMinVrednost(int minVrednost) {
		this.minVrednost = minVrednost;
	}

	public int getMaxVrednost() {
		return maxVrednost;
	}

	public void setMaxVrednost(int maxVrednost) {
		this.maxVrednost = maxVrednost;
	}
	
}
