package de.lubowiecki.todos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

	// Repository ist die Umsetzung des EntityManagers der JPA
	
	List<Task> findByDoneAtIsNull();
	
	List<Task> findByDoneAtIsNotNull();
	
}
