package sbz.cdss.DTOpovratni;

import java.util.ArrayList;
import java.util.List;

import sbz.cdss.facts.Lek;
import sbz.cdss.facts.Pacijent;
import sbz.cdss.facts.Sastojak;

public class DTOPacijentPovratni {
	
	private Long id;	
	private String JMBG;
	private String ime;
	private String prezime;
	private List<Lek> alergijaLekovi;
	private List<String> alergijaSastojci;
	
	public DTOPacijentPovratni() {}

	public DTOPacijentPovratni(Long id, String jMBG, String ime, String prezime, List<Lek> alergijaLekovi,
			List<String> alergijaSastojci) {
		super();
		this.id = id;
		JMBG = jMBG;
		this.ime = ime;
		this.prezime = prezime;
		this.alergijaLekovi = alergijaLekovi;
		this.alergijaSastojci = alergijaSastojci;
	}
	
	public static DTOPacijentPovratni konvertuj(Pacijent p) {
		List<String> alergijaSastojci = new ArrayList<String>();
		for (Sastojak s: p.getAlergijaSastojci()) {
			alergijaSastojci.add(s.getNaziv());
		}
		DTOPacijentPovratni dtoPP = new DTOPacijentPovratni(p.getId(), p.getJMBG(), p.getIme(), p.getPrezime(), 
				p.getAlergijaLekovi(), alergijaSastojci);
		return dtoPP;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Lek> getAlergijaLekovi() {
		return alergijaLekovi;
	}

	public void setAlergijaLekovi(List<Lek> alergijaLekovi) {
		this.alergijaLekovi = alergijaLekovi;
	}

	public List<String> getAlergijaSastojci() {
		return alergijaSastojci;
	}

	public void setAlergijaSastojci(List<String> alergijaSastojci) {
		this.alergijaSastojci = alergijaSastojci;
	}
	
	
}
