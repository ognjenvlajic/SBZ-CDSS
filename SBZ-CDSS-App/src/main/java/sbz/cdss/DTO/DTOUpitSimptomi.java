package sbz.cdss.DTO;

import sbz.cdss.facts.Bolest;

public class DTOUpitSimptomi {

	private String email;
	private Bolest bolest;
	
	public DTOUpitSimptomi() {}

	public DTOUpitSimptomi(String email, Bolest bolest) {
		super();
		this.email = email;
		this.bolest = bolest;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Bolest getBolest() {
		return bolest;
	}

	public void setBolest(Bolest bolest) {
		this.bolest = bolest;
	}
	
}
