package sbz.cdss.DTOpovratni;

import sbz.cdss.facts.Lekar;

public class DTOLekarPovratni {

	private Long id;
	private String email;
	private String ime;
	private String prezime;
	
	public DTOLekarPovratni() {}

	public DTOLekarPovratni(Long id, String email, String ime, String prezime) {
		super();
		this.id = id;
		this.email = email;
		this.ime = ime;
		this.prezime = prezime;
	}
	
	public static DTOLekarPovratni konvertuj(Lekar lekar) {
		DTOLekarPovratni dtoLP = new DTOLekarPovratni(lekar.getId(), lekar.getEmail(), lekar.getIme(), lekar.getPrezime());
		return dtoLP;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
}
