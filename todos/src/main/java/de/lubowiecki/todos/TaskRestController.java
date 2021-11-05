package de.lubowiecki.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskRestController {
	
	@Autowired
	private TaskRepository repo;
	
	@GetMapping("/api/tasks/all")
	public Iterable<Task> getAll() {
		return repo.findAll();
	}
	
	@GetMapping("/api/tasks/done")
	public Iterable<Task> getDone() {
		return repo.findByDoneAtIsNotNull();
	}
	
	@GetMapping("/api/tasks/undone")
	public Iterable<Task> getUndone() {
		return repo.findByDoneAtIsNull();
	}
	
	@PostMapping("/api/tasks/save")
	public Iterable<Task> save(@RequestBody Task task) {
		repo.save(task);
		return repo.findAll();
	}
}
