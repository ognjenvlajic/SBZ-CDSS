package sbz.cdss.facts;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Simptom implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column
	private int minVrednost;
	
	@Column
	private int maxVrednost;
    
    public Simptom() {}

	public Simptom(String naziv, int minVrednost, int maxVrednost) {
		super();
		this.naziv = naziv;
		this.minVrednost = minVrednost;
		this.maxVrednost = maxVrednost;
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

	public int getMinVrednost() {
		return minVrednost;
	}

	public void setMinVrednost(int minVrednost) {
		this.minVrednost = minVrednost;
	}

	public int getMaxVrednost() {
		return maxVrednost;
	}

	public void setMaxVrednost(int maxVrednost) {
		this.maxVrednost = maxVrednost;
	}
	
	public boolean pripada(List<Simptom> simptomi) {
		if (simptomi == null) {
			return false;
		}
		for (Simptom s: simptomi) {
			if (s.getNaziv().equalsIgnoreCase(this.naziv)) {
				return true;
			}
		}
		return false;
	}
	 
}
