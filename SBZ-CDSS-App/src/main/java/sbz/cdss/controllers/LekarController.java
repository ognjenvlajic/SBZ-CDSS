package sbz.cdss.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sbz.cdss.DTO.DTODijagnoza;
import sbz.cdss.DTO.DTOPacijent;
import sbz.cdss.DTO.DTORezoner;
import sbz.cdss.DTO.DTOUpitBolest;
import sbz.cdss.DTO.DTOUpitSimptomi;
import sbz.cdss.DTOpovratni.DTOBolestPovratni;
import sbz.cdss.DTOpovratni.DTOPacijentPovratni;
import sbz.cdss.DTOpovratni.DTOSimptomPovratni;
import sbz.cdss.DTOpovratni.DTOUpitBolestPovratni;
import sbz.cdss.facts.Bolest;
import sbz.cdss.facts.Dijagnoza;
import sbz.cdss.facts.Pacijent;
import sbz.cdss.facts.Sastojak;
import sbz.cdss.facts.Simptom;
import sbz.cdss.services.LekarService;

@RestController
public class LekarController {
	
	@Autowired
	private LekarService lekarService;
	
	@PreAuthorize("hasAuthority('LEKAR')")
	@RequestMapping(
			value = "/rezoner",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> rezoner(@Validated @RequestBody DTORezoner dtoRezoner, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		
		List<Bolest> bolesti = this.lekarService.rezoner(dtoRezoner.getEmail(), dtoRezoner.getPacijentId(),
				dtoRezoner.getSimptomi());
		List<DTOBolestPovratni> dtoBolesti = new ArrayList<>();
		for (Bolest b: bolesti) {
			dtoBolesti.add(DTOBolestPovratni.konvertuj(b));
		}
		
		return new ResponseEntity<List<DTOBolestPovratni>>(dtoBolesti, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('LEKAR')")
	@RequestMapping(
			value = "/validacijaIDijagnoza",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<?> validacijaIDijagnoza(@Validated @RequestBody DTODijagnoza dtoDijagnoza, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		
		Dijagnoza d = new Dijagnoza();
		d.setDatum(new Date());
		d.setBolest(dtoDijagnoza.getBolest());
		d.setSimptomi(dtoDijagnoza.getSimptomi());
		d.setPripisaniLekovi(dtoDijagnoza.getPripisaniLekovi());
		
		String s = this.lekarService.dijagnoza(dtoDijagnoza.getEmail(), dtoDijagnoza.getPacijentId(), d);
		
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('LEKAR')")
	@RequestMapping(
			value = "/pacijent/alergije",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alergije(@Validated @RequestBody DTOPacijent dtoPacijent, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		
		Pacijent pacijent = new Pacijent();
		pacijent.setId(dtoPacijent.getId());
		pacijent.setAlergijaLekovi(dtoPacijent.getAlergijaLekovi());
		List<Sastojak> sastojci = new ArrayList<Sastojak>();
		for (String s: dtoPacijent.getAlergijaSastojci()) {
			Sastojak sastojak = new Sastojak(s);
			sastojci.add(sastojak);
		}
		pacijent.setAlergijaSastojci(sastojci);
		Pacijent p = this.lekarService.alergije(pacijent);
		DTOPacijentPovratni dtoPP = DTOPacijentPovratni.konvertuj(p);
		
		return new ResponseEntity<DTOPacijentPovratni>(dtoPP, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('LEKAR')")
	@RequestMapping(
			value = "/upitBolest",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> upitBolesti(@Validated @RequestBody DTOUpitBolest dtoUpit, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		
		Map<Bolest, Integer> bolesti = this.lekarService.upitBolest(dtoUpit);
		DTOUpitBolestPovratni rezultatDto = new DTOUpitBolestPovratni();
		for (Map.Entry<Bolest, Integer> par: bolesti.entrySet()) {
			rezultatDto.getBolesti().add(DTOBolestPovratni.konvertuj(par.getKey()));
			rezultatDto.getBrojSimptoma().add(par.getValue());
		}
	
		return new ResponseEntity<DTOUpitBolestPovratni>(rezultatDto, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('LEKAR')")
	@RequestMapping(
			value = "/upitSimptomi",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> upitSimptoma(@Validated @RequestBody DTOUpitSimptomi dtoUpit, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
	
		List<Simptom> simptomi = this.lekarService.upitSimptomi(dtoUpit.getEmail(), dtoUpit.getBolest());
		List<DTOSimptomPovratni> simptomiDto = new ArrayList<>();
		for (Simptom s : simptomi) {
			simptomiDto.add(DTOSimptomPovratni.konvertuj(s));
		}
		
		return new ResponseEntity<List<DTOSimptomPovratni>>(simptomiDto, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('LEKAR')")
	@RequestMapping(
			value = "/izvestavanje",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> izvestavanje(String email) {
	
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
}
