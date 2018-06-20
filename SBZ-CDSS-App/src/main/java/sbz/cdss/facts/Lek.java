package sbz.cdss.facts;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lek implements Serializable {
	
	public enum Grupa {
		ANTIBIOTIK, ANELGETIK, OSTALO
	};

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String naziv;
	
	@Column(nullable = false)
	private Grupa grupa;
	
	@ElementCollection
	private List<String> sastojci;
	
	public Lek() {}

	public Lek(String naziv, Grupa grupa, List<String> sastojci) {
		super();
		this.naziv = naziv;
		this.grupa = grupa;
		this.sastojci = sastojci;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Grupa getGrupa() {
		return grupa;
	}

	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
	}

	public List<String> getSastojci() {
		return sastojci;
	}

	public void setSastojci(List<String> sastojci) {
		this.sastojci = sastojci;
	}

}
