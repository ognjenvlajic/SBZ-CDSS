package sbz.cdss.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sbz.cdss.facts.Pacijent;

public interface PacijentRepository extends CrudRepository<Pacijent, Long> {
	
	public List<Pacijent> findAll();
	public Page<Pacijent> findAll(Pageable pageable);
	public Pacijent findById(Long id);
	public Pacijent findByJmbg(String JMBG);
	public void delete(Long id);
	
	@Query(value = "SELECT p FROM Pacijent p WHERE CONCAT(UPPER(p.ime),' ',UPPER(p.prezime)) LIKE CONCAT('%',UPPER(:filter),'%') ",
			countQuery = "SELECT COUNT(p) FROM Pacijent p WHERE CONCAT(UPPER(p.ime),' ',UPPER(p.prezime)) LIKE CONCAT('%',UPPER(:filter),'%') ")
	public Page<Pacijent> search(@Param("filter") String filter, Pageable pageable);

}
