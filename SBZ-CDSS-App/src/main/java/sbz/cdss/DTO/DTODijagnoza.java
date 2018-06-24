package sbz.cdss.DTO;

import java.util.List;

import sbz.cdss.facts.Bolest;
import sbz.cdss.facts.Lek;
import sbz.cdss.facts.SimptomVrednost;

public class DTODijagnoza {

	private String email;
	private Long pacijentId;
	private Bolest bolest;
	private List<SimptomVrednost> simptomi;
	private List<Lek> pripisaniLekovi;
	
	public DTODijagnoza() {}

	public DTODijagnoza(String email, Long pacijentId, Bolest bolest, List<SimptomVrednost> simptomi,
			List<Lek> pripisaniLekovi) {
		super();
		this.email = email;
		this.pacijentId = pacijentId;
		this.bolest = bolest;
		this.simptomi = simptomi;
		this.pripisaniLekovi = pripisaniLekovi;
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

	public Bolest getBolest() {
		return bolest;
	}

	public void setBolest(Bolest bolest) {
		this.bolest = bolest;
	}

	public List<SimptomVrednost> getSimptomi() {
		return simptomi;
	}

	public void setSimptomi(List<SimptomVrednost> simptomi) {
		this.simptomi = simptomi;
	}

	public List<Lek> getPripisaniLekovi() {
		return pripisaniLekovi;
	}

	public void setPripisaniLekovi(List<Lek> pripisaniLekovi) {
		this.pripisaniLekovi = pripisaniLekovi;
	}
	
}
