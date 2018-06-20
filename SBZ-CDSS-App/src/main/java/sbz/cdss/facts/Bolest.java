package sbz.cdss.facts;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Bolest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String naziv;
	
	@ManyToMany
	private List<Simptom> opstiSimptomi;
	
	@ManyToMany
	private List<Simptom> specificniSimptomi;
	
	public Bolest() {}

	public Bolest(String naziv, List<Simptom> opstiSimptomi, List<Simptom> specificniSimptomi) {
		super();
		this.naziv = naziv;
		this.opstiSimptomi = opstiSimptomi;
		this.specificniSimptomi = specificniSimptomi;
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

	public List<Simptom> getOpstiSimptomi() {
		return opstiSimptomi;
	}

	public void setOpstiSimptomi(List<Simptom> opstiSimptomi) {
		this.opstiSimptomi = opstiSimptomi;
	}

	public List<Simptom> getSpecificniSimptomi() {
		return specificniSimptomi;
	}

	public void setSpecificniSimptomi(List<Simptom> specificniSimptomi) {
		this.specificniSimptomi = specificniSimptomi;
	}

}
