package sbz.cdss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sbz.cdss.exceptions.BadRequestException;
import sbz.cdss.exceptions.NotFoundException;
import sbz.cdss.facts.Bolest;
import sbz.cdss.facts.Korisnik;
import sbz.cdss.facts.Lek;
import sbz.cdss.facts.Lekar;
import sbz.cdss.facts.Pacijent;
import sbz.cdss.facts.Sastojak;
import sbz.cdss.facts.Simptom;
import sbz.cdss.repositories.BolestRepository;
import sbz.cdss.repositories.KorisnikRepository;
import sbz.cdss.repositories.LekRepository;
import sbz.cdss.repositories.LekarRepository;
import sbz.cdss.repositories.PacijentRepository;
import sbz.cdss.repositories.SastojakRepository;
import sbz.cdss.repositories.SimptomRepository;

@Service
public class AdministratorServiceImpl implements AdministratorService {
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private LekarRepository lekarRepository;
	
	@Autowired
	private PacijentRepository pacijentRepository;
	
	@Autowired
	private SimptomRepository simptomRepository;
	
	@Autowired
	private BolestRepository bolestRepository;
	
	@Autowired
	private LekRepository lekRepository;
	
	@Autowired
	private SastojakRepository sastojakRepository;
	

	public Lekar dodajLekara(Lekar lekar) {
		Korisnik k = this.korisnikRepository.findByEmail(lekar.getEmail());
		if (k != null) {
			throw new BadRequestException("Email adresa: " + lekar.getEmail() + " je zauzeta!");
		}
		
		this.lekarRepository.save(lekar);
		return lekar;
	}

	public Lekar lekar(Long id) {
		Lekar lekar = this.lekarRepository.findById(id);
		if (lekar == null) {
			throw new NotFoundException("Nepostojeci lekar!");
		}
		
		return lekar;
	}
	
	public Page<Lekar> lekari(Pageable pageable, String filter) {
		Page<Lekar> lekari;
		if (filter == null) {
			lekari = this.lekarRepository.findAll(pageable);
		} else {
			lekari = this.lekarRepository.search(filter, pageable);
		}
		
		return lekari;
	}

	public Pacijent dodajPacijenta(Pacijent pacijent) {
		Pacijent p = this.pacijentRepository.findByJmbg(pacijent.getJMBG());
		if (p != null) {
			throw new BadRequestException("Pacijent sa JMBG: " + pacijent.getJMBG() + " vec postoji!");
		}
		
		this.pacijentRepository.save(pacijent);
		return pacijent;
	}

	public Pacijent pacijent(Long id) {
		Pacijent pacijent = this.pacijentRepository.findById(id);
		if (pacijent == null) {
			throw new NotFoundException("Nepostojeci pacijent!");
		}
		
		return pacijent;
	}

	public Page<Pacijent> pacijenti(Pageable pageable, String filter) {
		Page<Pacijent> pacijenti;
		if (filter == null) {
			pacijenti = this.pacijentRepository.findAll(pageable);
		} else {
			pacijenti = this.pacijentRepository.search(filter, pageable);
		}
		
		return pacijenti;
	}

	public Pacijent izmeniPacijenta(Long id, Pacijent pacijent) {
		Pacijent p = this.pacijentRepository.findById(id);
		if (p == null) {
			throw new NotFoundException("Pacijent sa id-em: " + id + " ne postoji!");
		}
		p.setIme(pacijent.getIme());
		p.setPrezime(pacijent.getPrezime());
		p.setJMBG(pacijent.getJMBG());
		this.pacijentRepository.save(p);
		return p;
	}

	public Simptom dodajSimptom(Simptom simptom) {		
		this.simptomRepository.save(simptom);
		return simptom;
	}

	public Page<Simptom> simptomi(Pageable pageable, String filter) {
		Page<Simptom> simptomi;
		if (filter == null) {
			simptomi = this.simptomRepository.findAll(pageable);
		} else {
			simptomi = this.simptomRepository.search(filter, pageable);
		}
		
		return simptomi;
	}

	public void obrisiSimptom(Long id) {
		Simptom s = this.simptomRepository.findById(id);
		if (s == null) {
			throw new NotFoundException("Simptom ne postoji!");
		}
		this.simptomRepository.delete(id);
	}

	public Bolest dodajBolest(Bolest bolest) {
		Bolest b = this.bolestRepository.findByNaziv(bolest.getNaziv());
		if (b != null) {
			throw new BadRequestException("Bolest sa nazivom: " + bolest.getNaziv() + " vec postoji!");
		}
		
		this.bolestRepository.save(bolest);
		return bolest;
	}

	public Bolest bolest(Long id) {
		Bolest bolest = this.bolestRepository.findById(id);
		if (bolest == null) {
			throw new NotFoundException("Nepostojeca bolest!");
		}
		
		return bolest;
	}

	public Page<Bolest> bolesti(Pageable pageable, String filter) {
		Page<Bolest> bolesti;
		if (filter == null) {
			bolesti = this.bolestRepository.findAll(pageable);
		} else {
			bolesti = this.bolestRepository.search(filter, pageable);
		}
		
		return bolesti;
	}

	public Bolest izmeniBolest(Long id, Bolest bolest) {
		// TODO Auto-generated method stub
		return null;
	}

	public void obrisiBolest(Long id) {
		Bolest b = this.bolestRepository.findById(id);
		if (b == null) {
			throw new NotFoundException("Bolest sa id-em: " + id + " ne postoji!");
		}
		this.bolestRepository.delete(id);
	}

	public Lek dodajLek(Lek lek) {
		Lek l = this.lekRepository.findByNaziv(lek.getNaziv());
		if (l != null) {
			throw new BadRequestException("Lek sa nazivom: " + lek.getNaziv() + " vec postoji!");
		}
		
		for (Sastojak s : lek.getSastojci()) {
			this.sastojakRepository.save(s);
		}
		this.lekRepository.save(lek);
		return lek;
	}

	public Lek lek(Long id) {
		Lek lek = this.lekRepository.findById(id);
		if (lek == null) {
			throw new NotFoundException("Nepostojeci lek!");
		}
		
		return lek;
	}

	public Page<Lek> lekovi(Pageable pageable, String filter) {
		Page<Lek> lekovi;
		if (filter == null) {
			lekovi = this.lekRepository.findAll(pageable);
		} else {
			lekovi = this.lekRepository.search(filter, pageable);
		}
		
		return lekovi;
	}

	public Lek izmeniLek(Long id, Lek lek) {
		// TODO Auto-generated method stub
		return null;
	}

	public void obrisiLek(Long id) {
		Lek l = this.lekRepository.findById(id);
		if (l == null) {
			throw new NotFoundException("Lek sa id-em: " + id + " ne postoji!");
		}
		this.lekRepository.delete(id);
	}

}
