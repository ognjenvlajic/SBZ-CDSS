package sbz.cdss.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbz.cdss.DTO.DTOBolest;
import sbz.cdss.DTO.DTOLek;
import sbz.cdss.DTO.DTOLekar;
import sbz.cdss.DTO.DTOPacijent;
import sbz.cdss.DTO.DTOSimptom;
import sbz.cdss.DTOpovratni.DTOBolestPovratni;
import sbz.cdss.DTOpovratni.DTOLekPovratni;
import sbz.cdss.DTOpovratni.DTOLekarPovratni;
import sbz.cdss.DTOpovratni.DTOPacijentPovratni;
import sbz.cdss.DTOpovratni.DTOSimptomPovratni;
import sbz.cdss.facts.Bolest;
import sbz.cdss.facts.Lek;
import sbz.cdss.facts.Lekar;
import sbz.cdss.facts.Pacijent;
import sbz.cdss.facts.Sastojak;
import sbz.cdss.facts.Simptom;
import sbz.cdss.services.AdministratorService;

@RestController
public class AdministratorController {
	
	@Autowired
	private AdministratorService administratorService;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
			value = "/lekar/dodaj",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> dodajLekara(@Validated @RequestBody DTOLekar dtoLekar, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		
		Lekar lekar = new Lekar(dtoLekar.getEmail(), dtoLekar.getLozinka(), "LEKAR", dtoLekar.getIme(), dtoLekar.getPrezime());
		Lekar l = this.administratorService.dodajLekara(lekar);
		DTOLekarPovratni dtoLP = DTOLekarPovratni.konvertuj(l);
		
		return new ResponseEntity<DTOLekarPovratni>(dtoLP, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
			value = "/lekar/{lekarId}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> lekar(@PathVariable("lekarId") Long lekarId) {
		Lekar l = this.administratorService.lekar(lekarId);
		DTOLekarPovratni dtoLP = DTOLekarPovratni.konvertuj(l);
		
		return new ResponseEntity<DTOLekarPovratni>(dtoLP, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
			value = "/lekari",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> lekari(Pageable page,
			@RequestParam(value="filter", required=false) String filter) {
		Page<Lekar> lekariPage = this.administratorService.lekari(page, filter);
		List<DTOLekarPovratni> dtoLekari = new ArrayList<DTOLekarPovratni>();
		for (Lekar l : lekariPage.getContent()) {
			dtoLekari.add(DTOLekarPovratni.konvertuj(l));
		}
		
		HttpHeaders header = new HttpHeaders();
		header.add("Ukupno-Strana", Integer.toString(lekariPage.getTotalPages()));
		
		return new ResponseEntity<List<DTOLekarPovratni>>(dtoLekari, header, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAnyAuthority('ADMIN, LEKAR')")
	@RequestMapping(
			value = "/pacijent/dodaj",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> dodajPacijenta(@Validated @RequestBody DTOPacijent dtoPacijent, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		
		Pacijent pacijent = new Pacijent(dtoPacijent.getJMBG(), dtoPacijent.getIme(), dtoPacijent.getPrezime());
		Pacijent p = this.administratorService.dodajPacijenta(pacijent);
		DTOPacijentPovratni dtoPP = DTOPacijentPovratni.konvertuj(p);
		
		return new ResponseEntity<DTOPacijentPovratni>(dtoPP, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAnyAuthority('ADMIN, LEKAR')")
	@RequestMapping(
			value = "/pacijent/{pacijentId}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> pacijent(@PathVariable("pacijentId") Long pacijentId) {
		Pacijent p = this.administratorService.pacijent(pacijentId);
		DTOPacijentPovratni dtoPP = DTOPacijentPovratni.konvertuj(p);
		
		return new ResponseEntity<DTOPacijentPovratni>(dtoPP, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAnyAuthority('ADMIN, LEKAR')")
	@RequestMapping(
			value = "/pacijenti",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> pacijenti(Pageable page,
			@RequestParam(value="filter", required=false) String filter) {
		Page<Pacijent> pacijentiPage = this.administratorService.pacijenti(page, filter);
		List<DTOPacijentPovratni> dtoPacijenti = new ArrayList<DTOPacijentPovratni>();
		for (Pacijent p : pacijentiPage.getContent()) {
			dtoPacijenti.add(DTOPacijentPovratni.konvertuj(p));
		}
		
		HttpHeaders header = new HttpHeaders();
		header.add("Ukupno-Strana", Integer.toString(pacijentiPage.getTotalPages()));
		
		return new ResponseEntity<List<DTOPacijentPovratni>>(dtoPacijenti, header, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
			value = "/simptom/dodaj",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> dodajSimptom(@Validated @RequestBody DTOSimptom dtoSimptom, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		
		System.out.println(dtoSimptom.getMinVrednost() + " " + dtoSimptom.getMaxVrednost());
		
		Simptom simptom = new Simptom(dtoSimptom.getNaziv(), dtoSimptom.getMinVrednost(), dtoSimptom.getMaxVrednost());
		Simptom s = this.administratorService.dodajSimptom(simptom);
		DTOSimptomPovratni dtoSP = DTOSimptomPovratni.konvertuj(s);
		
		return new ResponseEntity<DTOSimptomPovratni>(dtoSP, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAnyAuthority('ADMIN, LEKAR')")
	@RequestMapping(
			value = "/simptomi",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> simptomi(Pageable page,
			@RequestParam(value="filter", required=false) String filter) {
		Page<Simptom> simptomiPage = this.administratorService.simptomi(page, filter);
		List<DTOSimptomPovratni> dtoSimptomi = new ArrayList<DTOSimptomPovratni>();
		for (Simptom s : simptomiPage.getContent()) {
			dtoSimptomi.add(DTOSimptomPovratni.konvertuj(s));
		}
		
		HttpHeaders header = new HttpHeaders();
		header.add("Ukupno-Strana", Integer.toString(simptomiPage.getTotalPages()));
		
		return new ResponseEntity<List<DTOSimptomPovratni>>(dtoSimptomi, header, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
			value = "/bolest/dodaj",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> dodajBolest(@Validated @RequestBody DTOBolest dtoBolest, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		
		Bolest bolest = new Bolest(dtoBolest.getNaziv(), dtoBolest.getOpstiSimptomi(), dtoBolest.getSpecificniSimptomi());
		Bolest b = this.administratorService.dodajBolest(bolest);
		DTOBolestPovratni dtoBP = DTOBolestPovratni.konvertuj(b);
		
		return new ResponseEntity<DTOBolestPovratni>(dtoBP, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
			value = "/bolest/{bolestId}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> bolest(@PathVariable("bolestId") Long bolestId) {
		Bolest b = this.administratorService.bolest(bolestId);
		DTOBolestPovratni dtoBP = DTOBolestPovratni.konvertuj(b);
		
		return new ResponseEntity<DTOBolestPovratni>(dtoBP, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAnyAuthority('ADMIN, LEKAR')")
	@RequestMapping(
			value = "/bolesti",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> bolesti(Pageable page,
			@RequestParam(value="filter", required=false) String filter) {
		Page<Bolest> bolestiPage = this.administratorService.bolesti(page, filter);
		List<DTOBolestPovratni> dtoBolesti = new ArrayList<DTOBolestPovratni>();
		for (Bolest b : bolestiPage.getContent()) {
			dtoBolesti.add(DTOBolestPovratni.konvertuj(b));
		}
		
		HttpHeaders header = new HttpHeaders();
		header.add("Ukupno-Strana", Integer.toString(bolestiPage.getTotalPages()));
		
		return new ResponseEntity<List<DTOBolestPovratni>>(dtoBolesti, header, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
			value = "/lek/dodaj",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> dodajLek(@Validated @RequestBody DTOLek dtoLek, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		
		List<Sastojak> sastojci = new ArrayList<Sastojak>();
		for (String s: dtoLek.getSastojci()) {
			Sastojak sastojak = new Sastojak(s);
			sastojci.add(sastojak);
		}
		Lek lek = new Lek(dtoLek.getNaziv(), Lek.Grupa.valueOf(dtoLek.getGrupa()), sastojci);
		Lek l = this.administratorService.dodajLek(lek);
		DTOLekPovratni dtoLP = DTOLekPovratni.konvertuj(l);
		
		return new ResponseEntity<DTOLekPovratni>(dtoLP, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
			value = "/lek/{lekId}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> lek(@PathVariable("lekId") Long lekId) {
		Lek l = this.administratorService.lek(lekId);
		DTOLekPovratni dtoLP = DTOLekPovratni.konvertuj(l);
		
		return new ResponseEntity<DTOLekPovratni>(dtoLP, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAnyAuthority('ADMIN, LEKAR')")
	@RequestMapping(
			value = "/lekovi",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> lekovi(Pageable page,
			@RequestParam(value="filter", required=false) String filter) {
		Page<Lek> lekoviPage = this.administratorService.lekovi(page, filter);
		List<DTOLekPovratni> dtoLekovi = new ArrayList<DTOLekPovratni>();
		for (Lek l : lekoviPage.getContent()) {
			dtoLekovi.add(DTOLekPovratni.konvertuj(l));
		}
		
		HttpHeaders header = new HttpHeaders();
		header.add("Ukupno-Strana", Integer.toString(lekoviPage.getTotalPages()));
		
		return new ResponseEntity<List<DTOLekPovratni>>(dtoLekovi, header, HttpStatus.OK);
	}
	
}
