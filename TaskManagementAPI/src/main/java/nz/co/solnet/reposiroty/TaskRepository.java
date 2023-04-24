package nz.co.solnet.reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nz.co.solnet.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	@Query("select t from Task t where t.due_date < current_date()")
	List<Task> findAllDueTasks();

}
