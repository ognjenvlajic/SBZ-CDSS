package sbz.cdss.facts;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Dijagnoza implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(optional = false)
	private Pacijent pacijent;
	
	@Column(nullable = false)
	private Date datum;
	
	@ManyToOne
	private Bolest bolest;
	
	@ManyToMany
	private List<SimptomVrednost> simptomi;
	
	@ManyToMany
	private List<Lek> pripisaniLekovi;
	
	public Dijagnoza() {}

	public Dijagnoza(Pacijent pacijent, Date datum, Bolest bolest, List<SimptomVrednost> simptomi, 
			List<Lek> pripisaniLekovi) {
		super();
		this.pacijent = pacijent;
		this.datum = datum;
		this.bolest = bolest;
		this.simptomi = simptomi;
		this.pripisaniLekovi = pripisaniLekovi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pacijent getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
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
	
	public boolean sadrziLekGrupe(Lek.Grupa lg) {
		for (Lek l : this.pripisaniLekovi) {
			if (l.getGrupa() == lg) {
				return true;
			}
		}
		return false;
	}
	
	public boolean sadrziSimptom(SimptomVrednost simptom) {
		for (SimptomVrednost sv: this.simptomi) {
			if (sv.getNaziv().equalsIgnoreCase(simptom.getNaziv())) {
				return true;
			}
		}
		return false;
	}
	
}
