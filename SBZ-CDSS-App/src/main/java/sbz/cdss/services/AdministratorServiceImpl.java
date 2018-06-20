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
import sbz.cdss.facts.Simptom;
import sbz.cdss.repositories.BolestRepository;
import sbz.cdss.repositories.KorisnikRepository;
import sbz.cdss.repositories.LekRepository;
import sbz.cdss.repositories.LekarRepository;
import sbz.cdss.repositories.PacijentRepository;
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
	

	public Lekar dodajLekara(Lekar lekar) {
		Korisnik k = this.korisnikRepository.findByEmail(lekar.getEmail());
		if (k == null) {
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

	public Lekar izmeniLekara(Long id, Lekar lekar) {
		// TODO Auto-generated method stub
		return null;
	}

	public Pacijent dodajPacijenta(Pacijent pacijent) {
		// TODO Auto-generated method stub
		return null;
	}

	public Pacijent pacijent(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Pacijent> pacijenti(Pageable pageable, String filter) {
		// TODO Auto-generated method stub
		return null;
	}

	public Pacijent izmeniPacijenta(Long id, Pacijent pacijent) {
		// TODO Auto-generated method stub
		return null;
	}

	public void obrisiPacijenta(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Simptom dodajSimptom(Simptom simptom) {
		// TODO Auto-generated method stub
		return null;
	}

	public Simptom simptom(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Bolest> simptomi(Pageable pageable, String filter) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bolest izmeniSimptom(Long id, Simptom simptom) {
		// TODO Auto-generated method stub
		return null;
	}

	public void obrisiSimptom(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Bolest dodajBolest(Bolest bolest) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bolest bolest(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Bolest> bolesti(Pageable pageable, String filter) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bolest izmeniBolest(Long id, Bolest bolest) {
		// TODO Auto-generated method stub
		return null;
	}

	public void obrisiBolest(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Lek dodajLek(Lek lek) {
		// TODO Auto-generated method stub
		return null;
	}

	public Lek lek(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Lek> lekovi(Pageable pageable, String filter) {
		// TODO Auto-generated method stub
		return null;
	}

	public Lek izmeniLek(Long id, Lek lek) {
		// TODO Auto-generated method stub
		return null;
	}

	public void obrisiLek(Long id) {
		// TODO Auto-generated method stub
		
	}

}
