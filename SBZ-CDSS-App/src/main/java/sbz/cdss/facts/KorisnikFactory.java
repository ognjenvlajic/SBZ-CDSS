package sbz.cdss.facts;

import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import sbz.cdss.security.SecurityKorisnik;

public class KorisnikFactory {

	public static SecurityKorisnik create(Korisnik korisnik) {
        Collection<? extends GrantedAuthority> authorities;
        try {
            authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(korisnik.getAuthorities());
        } catch (Exception e) {
            authorities = null;
        }
        
        return new SecurityKorisnik(
                korisnik.getId(),
                korisnik.getEmail(),
                korisnik.getLozinka(),
                authorities
        );
    }
}
