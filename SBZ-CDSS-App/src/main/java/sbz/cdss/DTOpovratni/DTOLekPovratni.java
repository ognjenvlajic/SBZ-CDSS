package sbz.cdss.DTOpovratni;

import java.util.ArrayList;
import java.util.List;

import sbz.cdss.facts.Lek;
import sbz.cdss.facts.Sastojak;

public class DTOLekPovratni {

	private Long id;
	private String naziv;
	private String grupa;
	private List<String> sastojci;
	
	public DTOLekPovratni() {}

	public DTOLekPovratni(Long id, String naziv, String grupa, List<String> sastojci) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.grupa = grupa;
		this.sastojci = sastojci;
	}
	
	public static DTOLekPovratni konvertuj(Lek l) {
		List<String> sastojci = new ArrayList<String>();
		for (Sastojak s: l.getSastojci()) {
			sastojci.add(s.getNaziv());
		}
		DTOLekPovratni dtoLP = new DTOLekPovratni(l.getId(), l.getNaziv(), l.getGrupa().toString(), sastojci);
		return dtoLP;
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

	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	public List<String> getSastojci() {
		return sastojci;
	}

	public void setSastojci(List<String> sastojci) {
		this.sastojci = sastojci;
	}
	
}
