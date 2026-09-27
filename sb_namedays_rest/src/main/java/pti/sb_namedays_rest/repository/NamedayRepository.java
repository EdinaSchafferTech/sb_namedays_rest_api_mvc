package pti.sb_namedays_rest.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import pti.sb_namedays_rest.model.Nameday;

public interface NamedayRepository extends CrudRepository<Nameday, Integer> {

	@Query("SELECT * FROM namedays")
	List<Nameday> findAllNamedays();

}
