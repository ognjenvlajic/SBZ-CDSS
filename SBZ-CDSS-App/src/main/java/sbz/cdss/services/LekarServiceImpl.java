package sbz.cdss.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbz.cdss.DTO.DTOUpitBolest;
import sbz.cdss.exceptions.BadRequestException;
import sbz.cdss.exceptions.NotFoundException;
import sbz.cdss.facts.Bolest;
import sbz.cdss.facts.Dijagnoza;
import sbz.cdss.facts.Korisnik;
import sbz.cdss.facts.Pacijent;
import sbz.cdss.facts.Rezoner;
import sbz.cdss.facts.Sastojak;
import sbz.cdss.facts.Simptom;
import sbz.cdss.facts.SimptomVrednost;
import sbz.cdss.facts.Validacija;
import sbz.cdss.repositories.BolestRepository;
import sbz.cdss.repositories.DijagnozaRepository;
import sbz.cdss.repositories.KorisnikRepository;
import sbz.cdss.repositories.PacijentRepository;
import sbz.cdss.repositories.SastojakRepository;
import sbz.cdss.repositories.SimptomRepository;
import sbz.cdss.repositories.SimptomVrednostRepository;


@Service
public class LekarServiceImpl implements LekarService {
	
	private static Logger log = LoggerFactory.getLogger(LekarService.class);

    private final KieContainer kieContainer;
    
    private HashMap<String, KieSession> sesije = new HashMap<String, KieSession>();
    
    @Autowired
    public LekarServiceImpl(KieContainer kieContainer) {
        log.info("Inicijalizacija kontejnera");
        this.kieContainer = kieContainer;
    }
    
    @Autowired
    private KorisnikRepository korisnikRepository;
    
    @Autowired
    private PacijentRepository pacijentRepoistory;
    
    @Autowired
    private BolestRepository bolestRepository;
    
    @Autowired
    private DijagnozaRepository dijagnozaRepository;
    
    @Autowired
    private SastojakRepository sastojakRepositoy;
    
    @Autowired
    private SimptomRepository simptomRepository;
    
    @Autowired
    private SimptomVrednostRepository simptomVrednostRepository;
    

	public void dodajSesiju(String email) {
		Korisnik korisnik = this.korisnikRepository.findByEmail(email);
		if (korisnik.getAuthorities().equals("LEKAR")) {
			KieSession kieSession = kieContainer.newKieSession();
			sesije.put(email, kieSession);
			log.info("Dodata sesija za lekara sa emailom: " + email);
			return;
		}
	}

	public void ukloniSesiju(String email) {
		Korisnik korisnik = this.korisnikRepository.findByEmail(email);
		if (korisnik.getAuthorities().equals("LEKAR")) {	
			KieSession kieSession = sesije.get(email);
			kieSession.dispose();
			sesije.remove(email);
			log.info("Uklonjena sesija za lekara sa emailom: " + email);
			return;
		}
	}

	public List<Bolest> rezoner(String email, Long pacijentId, List<SimptomVrednost> simptomi) {
		KieSession kieSession = sesije.get(email);
		Pacijent p = this.pacijentRepoistory.findById(pacijentId);
		if (p == null) {
			throw new BadRequestException("Pacijent sa id-em: " + pacijentId + " ne postoji!");
		}
		kieSession.insert(p);
		for (Bolest b: this.bolestRepository.findAll()) {
			kieSession.insert(b);
		}
		for (SimptomVrednost sv: simptomi) {
			kieSession.insert(sv);
		}
		Rezoner rezoner = new Rezoner();
		kieSession.insert(rezoner);
		kieSession.getAgenda().getAgendaGroup("bolesti").setFocus();
		kieSession.fireAllRules();
		List<Bolest> bolesti = ubaciBolesti(rezoner);
		Collection<FactHandle> handleri = kieSession.getFactHandles();
		for (FactHandle fc: handleri) {
			kieSession.delete(fc);
		}
		return bolesti;
	}
	
	private List<Bolest> ubaciBolesti(Rezoner r) {
		List<Bolest> bolesti = new ArrayList<>();
		if (r.getPrvaGrupa() != null) {
			bolesti.add(r.getPrvaGrupa());
		}
		if (!(r.getDrugaGrupa().isEmpty())) {
			bolesti.addAll(r.getDrugaGrupa());
		}
		if (r.getTrecaGrupa() != null) {
			bolesti.add(r.getTrecaGrupa());
		}
		return bolesti;
	}

	public Pacijent alergije(Pacijent p) {
		Pacijent pacijent = this.pacijentRepoistory.findById(p.getId());
		if (pacijent == null) {
			throw new NotFoundException("Pacijent sa id-em: " + p.getId() + " ne postoji!");
		}
		pacijent.setAlergijaLekovi(p.getAlergijaLekovi());
		pacijent.setAlergijaSastojci(p.getAlergijaSastojci());
		for (Sastojak s: p.getAlergijaSastojci()) {
			this.sastojakRepositoy.save(s);
		}
		this.pacijentRepoistory.save(pacijent);
		return pacijent;
	}
	
	public String dijagnoza(String email, Long pacijentId, Dijagnoza dijagnoza) {
		KieSession kieSession = sesije.get(email);
		Pacijent p = this.pacijentRepoistory.findById(pacijentId);
		if (p == null) {
			throw new NotFoundException("Pacijent sa id-em: " + pacijentId + " ne postoji!");
		}
		dijagnoza.setPacijent(p);
		kieSession.insert(p);
		kieSession.insert(dijagnoza);
		Validacija validacija = new Validacija();
		kieSession.insert(validacija);
		kieSession.getAgenda().getAgendaGroup("alergije").setFocus();
		kieSession.fireAllRules();
		String retVal = validacijaToString(validacija);
		if (retVal.length() < 1) {
			retVal = "Uspesno ste kreirali dijagnozu za pacijenta!";
			for (SimptomVrednost sv: dijagnoza.getSimptomi()) {
				this.simptomVrednostRepository.save(sv);
			}
			this.dijagnozaRepository.save(dijagnoza);
		}
		Collection<FactHandle> handleri = kieSession.getFactHandles();
		for (FactHandle fc: handleri) {
			kieSession.delete(fc);
		}
		return retVal;
	}
	
	private String validacijaToString(Validacija validacija) {
		String retVal = "";
		if (!(validacija.getLekovi().isEmpty())) {
			retVal += "Lekovi na koje je pacijent alergican: ";
			for (String s : validacija.getLekovi()) {
				retVal += s + "\n";
			}
		}
		if (!(validacija.getSastojci().isEmpty())) {
			retVal += "\nSastojci na koje je pacijent alergican: ";
			for (String s : validacija.getSastojci()) {
				retVal += s + "\n";
			}
		}
		return retVal;
	}

	public void izvestavanje(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Bolest, Integer> upitBolest(DTOUpitBolest dtoUpit) {
		KieSession kieSession = this.sesije.get(dtoUpit.getEmail());
		kieSession.getAgenda().getAgendaGroup("MAIN").setFocus();
		
		for (Bolest b: this.bolestRepository.findAll()) {
			kieSession.insert(b);
		}
		
		Map<Bolest, Integer> mapa = new HashMap<Bolest, Integer>();
		
		QueryResults rezultat = kieSession.getQueryResults( "upit bolesti", dtoUpit );
		for ( QueryResultsRow row : rezultat ) {
			Bolest b = (Bolest)row.get("$bolest");
		    Integer i = (Integer)row.get("$ukupno");
		    mapa.put(b, i);
        }
		
		Collection<FactHandle> handleri = kieSession.getFactHandles();
		for (FactHandle fc: handleri) {
			kieSession.delete(fc);
		}
		return mapa;
	}

	@Override
	public List<Simptom> upitSimptomi(String email, Bolest bolest) {
		KieSession kieSession = this.sesije.get(email);
		kieSession.getAgenda().getAgendaGroup("MAIN").setFocus();
		
		Bolest b = this.bolestRepository.findById(bolest.getId());
		
		for (Simptom s: this.simptomRepository.findAll()) {
			kieSession.insert(s);
		}
		
		List<Simptom> simptomi = new ArrayList<Simptom>();
		
		QueryResults rezultat = kieSession.getQueryResults( "specificni simptomi", b );
		for ( QueryResultsRow row : rezultat ) {
			Simptom s = (Simptom)row.get("$simptom");
		    simptomi.add(s);
        }
		
		rezultat = kieSession.getQueryResults( "opsti simptomi", b );
		for ( QueryResultsRow row : rezultat ) {
			Simptom s = (Simptom)row.get("$simptom");
		    simptomi.add(s);
        }
		
		Collection<FactHandle> handleri = kieSession.getFactHandles();
		for (FactHandle fc: handleri) {
			kieSession.delete(fc);
		}
		
		return simptomi;
	}
	
}
