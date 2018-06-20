package sbz.cdss.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sbz.cdss.facts.Korisnik;

public interface KorisnikRepository extends CrudRepository<Korisnik, Long> {

	public List<Korisnik> findAll();
	public Korisnik findById(Long id);
	public Korisnik findByEmail(String email);
	public void delete(Long id);
}
