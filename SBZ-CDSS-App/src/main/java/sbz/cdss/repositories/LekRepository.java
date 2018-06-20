package sbz.cdss.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sbz.cdss.facts.Lek;

public interface LekRepository extends CrudRepository<Lek, Long> {
	
	public List<Lek> findAll();
	public Page<Lek> findAll(Pageable pageable);
	public Lek findById(Long id);
	public void delete(Long id);
	
	@Query(value = "SELECT l FROM Lek l WHERE UPPER(l.naziv) LIKE CONCAT('%',UPPER(:filter),'%') ",
			countQuery = "SELECT COUNT(l) FROM Lek l WHERE UPPER(l.naziv) LIKE CONCAT('%',UPPER(:filter),'%') ")
	public Page<Lek> search(@Param("filter") String filter, Pageable pageable);

}
