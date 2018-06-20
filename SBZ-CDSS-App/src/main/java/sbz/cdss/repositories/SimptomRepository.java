package sbz.cdss.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sbz.cdss.facts.Simptom;

public interface SimptomRepository extends CrudRepository<Simptom, Long> {
	
	public List<Simptom> findAll();
	public Page<Simptom> findAll(Pageable pageable);
	public Simptom findById(Long id);
	public Simptom findByNaziv(String naziv);
	public void delete(Long id);
	
	@Query(value = "SELECT s FROM Simptom s WHERE UPPER(s.naziv) LIKE CONCAT('%',UPPER(:filter),'%') ",
			countQuery = "SELECT COUNT(s) FROM Simptom s WHERE UPPER(s.naziv) LIKE CONCAT('%',UPPER(:filter),'%') ")
	public Page<Simptom> search(@Param("filter") String filter, Pageable pageable);

}
