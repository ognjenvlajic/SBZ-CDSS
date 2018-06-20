package sbz.cdss.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sbz.cdss.facts.Bolest;

public interface BolestRepository extends CrudRepository<Bolest, Long> {
	
	public List<Bolest> findAll();
	public Page<Bolest> findAll(Pageable pageable);
	public Bolest findById(Long id);
	public Bolest findByNaziv(String naziv);
	public void delete(Long id);
	
	@Query(value = "SELECT b FROM Bolest b WHERE UPPER(b.naziv) LIKE CONCAT('%',UPPER(:filter),'%') ",
			countQuery = "SELECT COUNT(b) FROM Bolest b WHERE UPPER(b.naziv) LIKE CONCAT('%',UPPER(:filter),'%') ")
	public Page<Bolest> search(@Param("filter") String filter, Pageable pageable);

}
