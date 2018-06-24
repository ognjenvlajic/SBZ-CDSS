package sbz.cdss.DTO;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import sbz.cdss.facts.Lek;

public class DTOPacijent {
	
	private Long id;
	
	private String JMBG;

	@NotNull(message = "Nije uneto ime!")
	@Size(min = 1, message = "Ime nije odgovarajuceg formata")
	private String ime;
	
	@NotNull(message = "Nije uneto prezime!")
	@Size(min = 1, message = "Prezime nije odgovarajuceg formata")
	private String prezime;
	
	private List<Lek> alergijaLekovi;
	
	private List<String> alergijaSastojci;
	
	public DTOPacijent() {}

	public DTOPacijent(Long id, String jMBG, String ime, String prezime, List<Lek> alergijaLekovi,
			List<String> alergijaSastojci) {
		super();
		this.id = id;
		JMBG = jMBG;
		this.ime = ime;
		this.prezime = prezime;
		this.alergijaLekovi = alergijaLekovi;
		this.alergijaSastojci = alergijaSastojci;
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
