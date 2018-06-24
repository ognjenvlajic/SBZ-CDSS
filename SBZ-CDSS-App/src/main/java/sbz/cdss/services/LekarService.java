package sbz.cdss.services;

import java.util.List;
import java.util.Map;

import sbz.cdss.DTO.DTOUpitBolest;
import sbz.cdss.facts.Bolest;
import sbz.cdss.facts.Dijagnoza;
import sbz.cdss.facts.Pacijent;
import sbz.cdss.facts.Simptom;
import sbz.cdss.facts.SimptomVrednost;

public interface LekarService {
	
	void dodajSesiju(String email);
	void ukloniSesiju(String email);
	List<Bolest> rezoner(String email, Long pacijentId, List<SimptomVrednost> simptomi);
	Pacijent alergije(Pacijent p);
	String dijagnoza(String email, Long pacijentId, Dijagnoza dijagnoza);
	void izvestavanje(String email);
	Map<Bolest, Integer> upitBolest(DTOUpitBolest dtoUpit);
    List<Simptom> upitSimptomi(String email, Bolest bolest);
}
