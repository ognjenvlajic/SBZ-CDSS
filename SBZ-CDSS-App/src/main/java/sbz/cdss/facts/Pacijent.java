package sbz.cdss.facts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Pacijent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String jmbg;
	
	@Column(nullable = false)
	private String ime;
	
	@Column(nullable = false)
	private String prezime;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Dijagnoza> karton;
	
	@ManyToMany
	private List<Lek> alergijaLekovi;
	
	@ElementCollection
	private List<String> alergijaSastojci; 
	
	public Pacijent() {}
	
	public Pacijent(String jMBG, String ime, String prezime, List<Lek> alergijaLekovi,
			List<String> alergijaSastojci) {
		super();
		this.jmbg = jMBG;
		this.ime = ime;
		this.prezime = prezime;
		this.karton = new ArrayList<Dijagnoza>();
		this.alergijaLekovi = alergijaLekovi;
		this.alergijaSastojci = alergijaSastojci;
	}

	public Pacijent(String jMBG, String ime, String prezime, List<Dijagnoza> karton, List<Lek> alergijaLekovi,
			List<String> alergijaSastojci) {
		super();
		this.jmbg = jMBG;
		this.ime = ime;
		this.prezime = prezime;
		this.karton = karton;
		this.alergijaLekovi = alergijaLekovi;
		this.alergijaSastojci = alergijaSastojci;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJMBG() {
		return jmbg;
	}

	public void setJMBG(String jMBG) {
		this.jmbg = jMBG;
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

	public List<Dijagnoza> getKarton() {
		return karton;
	}

	public void setKarton(List<Dijagnoza> karton) {
		this.karton = karton;
	}

	public List<Lek> getAlergijaLekovi() {
		return alergijaLekovi;
	}

	public void setAlergijaLekovi(List<Lek> alergijaLekovi) {
		this.alergijaLekovi = alergijaLekovi;
	}

	public List<String> getAlergijaSastojci() {
		return alergijaSastojci;
	}

	public void setAlergijaSastojci(List<String> alergijaSastojci) {
		this.alergijaSastojci = alergijaSastojci;
	}

}
