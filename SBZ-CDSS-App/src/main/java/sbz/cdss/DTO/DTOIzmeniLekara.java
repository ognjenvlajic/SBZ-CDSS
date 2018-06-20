package sbz.cdss.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOIzmeniLekara {
	
	@NotNull(message = "Nije unet id!")
	private Long id;
	
	@NotNull(message = "Nije uneto ime!")
	@Size(min = 1, message = "Ime nije odgovarajuceg formata")
	private String ime;
	
	@NotNull(message = "Nije uneto prezime!")
	@Size(min = 1, message = "Prezime nije odgovarajuceg formata")
	private String prezime;
	
	@NotNull
	private boolean izmeniLozinku;
	
	//@PasswordValidation
	private String lozinka;
	
	public DTOIzmeniLekara() {}

	public DTOIzmeniLekara(Long id, String ime, String prezime, boolean izmeniLozinku, String lozinka) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.izmeniLozinku = izmeniLozinku;
		this.lozinka = lozinka;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isIzmeniLozinku() {
		return izmeniLozinku;
	}

	public void setIzmeniLozinku(boolean izmeniLozinku) {
		this.izmeniLozinku = izmeniLozinku;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

}
