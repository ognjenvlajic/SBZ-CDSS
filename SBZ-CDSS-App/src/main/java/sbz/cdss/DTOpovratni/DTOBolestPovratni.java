package sbz.cdss.DTOpovratni;

import java.util.List;

import sbz.cdss.facts.Bolest;
import sbz.cdss.facts.Simptom;

public class DTOBolestPovratni {

	private Long id;
	private String naziv;
	private List<Simptom> opstiSimptomi;
	private List<Simptom> specificniSimptomi;
	
	public DTOBolestPovratni() {}

	public DTOBolestPovratni(Long id, String naziv, List<Simptom> opstiSimptomi, List<Simptom> specificniSimptomi) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opstiSimptomi = opstiSimptomi;
		this.specificniSimptomi = specificniSimptomi;
	}
	
	public static DTOBolestPovratni konvertuj(Bolest b) {
		DTOBolestPovratni dtoBP = new DTOBolestPovratni(b.getId(), b.getNaziv(), b.getOpstiSimptomi(), b.getSpecificniSimptomi());
		return dtoBP;
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

	public List<Simptom> getOpstiSimptomi() {
		return opstiSimptomi;
	}

	public void setOpstiSimptomi(List<Simptom> opstiSimptomi) {
		this.opstiSimptomi = opstiSimptomi;
	}

	public List<Simptom> getSpecificniSimptomi() {
		return specificniSimptomi;
	}

	public void setSpecificniSimptomi(List<Simptom> specificniSimptomi) {
		this.specificniSimptomi = specificniSimptomi;
	}
	
}
