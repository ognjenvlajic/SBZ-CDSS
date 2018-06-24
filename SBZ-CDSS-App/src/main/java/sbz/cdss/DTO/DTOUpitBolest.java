package sbz.cdss.DTO;

import java.util.List;

import sbz.cdss.facts.Simptom;

public class DTOUpitBolest {

	private String email;
	private List<Simptom> simptomi;
	
	public DTOUpitBolest() {}
	
	public DTOUpitBolest(String email, List<Simptom> simptomi) {
		super();
		this.email = email;
		this.simptomi = simptomi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Simptom> getSimptomi() {
		return simptomi;
	}

	public void setSimptomi(List<Simptom> simptomi) {
		this.simptomi = simptomi;
	}

}
