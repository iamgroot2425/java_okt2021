package de.lubowiecki.todos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {

	List<Task> findByDoneAtIsNull();
	
	List<Task> findByDoneAtIsNotNull();
	
}
