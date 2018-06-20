package sbz.cdss.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sbz.cdss.facts.Lekar;

public interface LekarRepository extends CrudRepository<Lekar, Long> {

	public List<Lekar> findAll();
	public Page<Lekar> findAll(Pageable pageable);
	public Lekar findById(Long id);
	public Lekar findByEmail(String email);
	public void delete(Long id);
	
	@Query(value = "SELECT l FROM Lekar l WHERE CONCAT(UPPER(l.ime),' ',UPPER(l.prezime)) LIKE CONCAT('%',UPPER(:filter),'%') "
			+ "OR UPPER(l.email) LIKE CONCAT('%',UPPER(:filter),'%')",
			countQuery = "SELECT COUNT(l) FROM Lekar l WHERE CONCAT(UPPER(l.ime),' ',UPPER(l.prezime)) LIKE CONCAT('%',UPPER(:filter),'%') "
					+ "OR UPPER(l.email) LIKE CONCAT('%',UPPER(:filter),'%')")
	public Page<Lekar> search(@Param("filter") String filter, Pageable pageable);
}
