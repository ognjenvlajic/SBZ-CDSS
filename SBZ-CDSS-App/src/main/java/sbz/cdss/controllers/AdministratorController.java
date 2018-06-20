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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbz.cdss.DTO.DTOIzmeniLekara;
import sbz.cdss.DTO.DTOLekar;
import sbz.cdss.DTOpovratni.DTOLekarPovratni;
import sbz.cdss.facts.Lekar;
import sbz.cdss.services.AdministratorService;

@RestController
public class AdministratorController {
	
	@Autowired
	private AdministratorService administratorService;
	
	//@PreAuthorize("hasAuthority('ADMIN')")
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
	
	
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
			value = "/lekar/{lekarId}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> lekar(@PathVariable("lekarId") Long lekarId) {
		Lekar l = this.administratorService.lekar(lekarId);
		DTOLekarPovratni dtoLP = DTOLekarPovratni.konvertuj(l);
		
		return new ResponseEntity<DTOLekarPovratni>(dtoLP, HttpStatus.OK);
	}
	
	
	//@PreAuthorize("hasAuthority('ADMIN')")
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
	
	@RequestMapping(
			value = "/lekar/izmeni",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> izmeniLekara(@Validated @RequestBody DTOIzmeniLekara dtoIL, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		
		Lekar lekar = new Lekar();
		lekar.setIme(dtoIL.getIme());
		lekar.setPrezime(dtoIL.getPrezime());
		lekar.setLozinka(dtoIL.getLozinka());
		Lekar l = this.administratorService.izmeniLekara(dtoIL.getId(), lekar);
		DTOLekarPovratni dtoLP = DTOLekarPovratni.konvertuj(l);
		
		return new ResponseEntity<DTOLekarPovratni>(dtoLP, HttpStatus.OK);
	}
}
