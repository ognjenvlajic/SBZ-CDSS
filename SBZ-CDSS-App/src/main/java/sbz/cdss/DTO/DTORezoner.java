package sbz.cdss.DTO;

import java.util.List;

import sbz.cdss.facts.SimptomVrednost;

public class DTORezoner {
	
	private String email;
	private Long pacijentId;
	private List<SimptomVrednost> simptomi;
	
	public DTORezoner() {}

	public DTORezoner(String email, Long pacijentId, List<SimptomVrednost> simptomi) {
		super();
		this.email = email;
		this.pacijentId = pacijentId;
		this.simptomi = simptomi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPacijentId() {
		return pacijentId;
	}

	public void setPacijentId(Long pacijentId) {
		this.pacijentId = pacijentId;
	}

	public List<SimptomVrednost> getSimptomi() {
		return simptomi;
	}

	public void setSimptomi(List<SimptomVrednost> simptomi) {
		this.simptomi = simptomi;
	}

}
