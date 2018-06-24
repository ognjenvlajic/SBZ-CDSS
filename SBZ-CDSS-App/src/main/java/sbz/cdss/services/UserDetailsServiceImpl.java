package sbz.cdss.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sbz.cdss.facts.Korisnik;
import sbz.cdss.facts.KorisnikFactory;
import sbz.cdss.repositories.KorisnikRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private KorisnikRepository korisnikRepository;

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Korisnik korisnik = this.korisnikRepository.findByEmail(email);

        if (korisnik == null) {
            throw new UsernameNotFoundException(String.format("Nije pronadjen korisnik sa tim emailom '%s'.", email));
        } else {
            return KorisnikFactory.create(korisnik);
        }
    }
	
}
