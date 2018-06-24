package sbz.cdss.DTO;

import java.util.List;

public class DTOLek {

	private Long id;
	private String naziv;
	private String grupa;
	private List<String> sastojci;
	
	public DTOLek() {}

	public DTOLek(Long id, String naziv, String grupa, List<String> sastojci) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.grupa = grupa;
		this.sastojci = sastojci;
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
