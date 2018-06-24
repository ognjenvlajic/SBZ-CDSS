package sbz.cdss.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sbz.cdss.facts.Bolest;
import sbz.cdss.facts.Lek;
import sbz.cdss.facts.Lekar;
import sbz.cdss.facts.Pacijent;
import sbz.cdss.facts.Simptom;

public interface AdministratorService {
	
	Lekar dodajLekara(Lekar lekar);
	Lekar lekar(Long id);
	Page<Lekar> lekari(Pageable pageable, String filter);
	
	Pacijent dodajPacijenta(Pacijent pacijent);
	Pacijent pacijent(Long id);
	Page<Pacijent> pacijenti(Pageable pageable, String filter);
	Pacijent izmeniPacijenta(Long id, Pacijent pacijent);
	
	Simptom dodajSimptom(Simptom simptom);
	Page<Simptom> simptomi(Pageable pageable, String filter);
	void obrisiSimptom(Long id);
	
	Bolest dodajBolest(Bolest bolest);
	Bolest bolest(Long id);
	Page<Bolest> bolesti(Pageable pageable, String filter);
	Bolest izmeniBolest(Long id, Bolest bolest);
	void obrisiBolest(Long id);
	
	Lek dodajLek(Lek lek);
	Lek lek(Long id);
	Page<Lek> lekovi(Pageable pageable, String filter);
	Lek izmeniLek(Long id, Lek lek);
	void obrisiLek(Long id);

}
