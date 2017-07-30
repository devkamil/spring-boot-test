package pl.devkamil;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long>{
	
	public List<Task> findByDone(Boolean done);
	
	public List<Task> findByName(String name);
	
	@Query("select t from Task t where t.description like %?1%")
	public List<Task> getByDescriptionLike(String search);

}
