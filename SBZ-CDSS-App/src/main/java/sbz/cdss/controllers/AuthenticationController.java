package sbz.cdss.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sbz.cdss.DTO.DTOLogovanje;
import sbz.cdss.DTO.DTOToken;
import sbz.cdss.exceptions.BadRequestException;
import sbz.cdss.security.TokenUtils;
import sbz.cdss.services.LekarService;


@RestController
public class AuthenticationController {
	
	@Value("${token.header}")
    private String tokenHeader;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private LekarService lekarService;

    @Autowired
    private TokenUtils tokenUtils;
	

	@RequestMapping(value = "/ulogujSe", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> loginUser(@RequestBody @Valid DTOLogovanje logovanje, BindingResult bindingResult,
			Device device) {

		if (bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError()
					.getDefaultMessage(), HttpStatus.FORBIDDEN);
		}

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();

		//potencijalno kasnije potrebno
		if (!(auth instanceof AnonymousAuthenticationToken)) {

			return new ResponseEntity<Object>("#/pocetna",
					HttpStatus.MOVED_PERMANENTLY);
		}

		try {
			Authentication authentication = this.authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(logovanje
							.getEmail(), logovanje.getLozinka()));

			SecurityContextHolder.getContext()
					.setAuthentication(authentication);

			DTOToken token = new DTOToken();
			UserDetails userDetails = this.userDetailsService
					.loadUserByUsername(logovanje.getEmail());
			String tokenValue = this.tokenUtils.generateToken(userDetails,
					device);
			token.setToken(tokenValue);
			this.lekarService.dodajSesiju(logovanje.getEmail());
			return new ResponseEntity<DTOToken>(token, HttpStatus.OK);

		} catch (BadCredentialsException e) {
			throw new BadRequestException("Pogresan email ili lozinka!"); 
		} catch (AuthenticationException e) {
			return new ResponseEntity<String>(
					"Nešto je pošlo naopako!", HttpStatus.BAD_REQUEST);
		}

	}
	
	
	@RequestMapping(value = "/izlogujSe",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> logoutUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)){
        	this.lekarService.ukloniSesiju(auth.getName());
            SecurityContextHolder.clearContext();
            return new ResponseEntity<String>("Uspesno ste se izlogovali!", HttpStatus.OK);
        } else {
        	throw new BadRequestException("Korisnik nije autentifikovan!");
        }

    }

}
