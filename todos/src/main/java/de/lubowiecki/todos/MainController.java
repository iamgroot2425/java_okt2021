package de.lubowiecki.todos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// MVC = Model View Controller
// MainController ist der Controller
// TaskRepository und Task sind das Model
// standard.jsp und andere Templates sind View

@Controller
public class MainController {
	
	@Autowired // Spring baut automatisch ein Objekt und weist es hier zu
	private TaskRepository repo; // CDI-Container weist es automatisch zu
	
	// CDI = Context and Dependency Injection
	// Alles was @Component direkt oder indirekt hat wird von dem CDI-Container verwaltet
	
	@RequestMapping("/") // Methode wird verarbeitet, wenn http://localhost:8080/ aufgerufen wird
	public String home(Model model) {
		// Über model kann man Werte an das Template weitergeben
		// Namen für Attribute sind frei wählbar
		model.addAttribute("title", "Home");
		model.addAttribute("headline", "Neuer Task");
		model.addAttribute("page", "home");
		model.addAttribute("task", new Task());
		return "standard_form"; // sucht standard_form.jsp im WEB-INF/tpl-Ordner
	}
	
	// @RequestMapping bedeutet es kann eine GET, POST, PUT, DELETE Anfrage sein
	@PostMapping("/save") // Methode wird verarbeitet, wenn http://localhost:8080/ aufgerufen wird
	public String save(Task task) {
		// Das Task Objekt wird automatisch mit den POST-Daten gefüllt
		if(task.getId() > 0) {
			Task dbState = repo.findById(task.getId()).get();
			task.setCreatedAt(dbState.getCreatedAt());
			task.setDoneAt(dbState.getDoneAt());
		}
		repo.save(task);
		return "redirect:/all"; // Umleitung auf die Übersicht der offen Tasks
	}
	
	@RequestMapping("/open") // Methode wird verarbeitet, wenn http://localhost:8080/open aufgerufen wird
	public String showOpen(Model model) {
		model.addAttribute("title", "Open");
		model.addAttribute("headline", "Das sind die noch offenen Tasks");
		model.addAttribute("page", "open");
		model.addAttribute("tasks", repo.findByDoneAtIsNull());
		return "standard"; // Auswahl des Templates
	}
	
	@RequestMapping("/done")
	public String showDone(Model model) {
		model.addAttribute("title", "Done");
		model.addAttribute("headline", "Das sind die erledigten Tasks");
		model.addAttribute("page", "done");
		model.addAttribute("tasks", repo.findByDoneAtIsNotNull());
		return "standard";
	}
	
	@RequestMapping("/done/{id}")
	public String setDone(@PathVariable("id") int id) {
		
		// findById fragt ein Task Objekt aus der DB ab, liefert ein Optional für den Fall, 
		// dass nichts passendes gefunden wird
		Optional<Task> opt = repo.findById(id);
		if(opt.isPresent()) {
			Task task = opt.get(); // Fragt aus dem Optional den Task ab
			task.setDoneAt(LocalDate.now()); // Ändert die doneAt-Eigenschaft des Tasks
			repo.save(task); // Speichert den Task in der DB
		}
		return "redirect:/all";
	}
	
	@RequestMapping("/undone/{id}")
	public String setUndone(@PathVariable("id") int id) {
		Optional<Task> opt = repo.findById(id);
		if(opt.isPresent()) {
			Task task = opt.get();
			task.setDoneAt(null);
			repo.save(task);
		}
		return "redirect:/all";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		repo.deleteById(id); // Löscht einen Task aus der DB passend zu der id
		return "redirect:/all";
	}
	
	@RequestMapping("/edit/{id}")
	public String editTask(@PathVariable("id") int id, Model model) {
		model.addAttribute("title", "Bearbeiten");
		model.addAttribute("headline", "Task Bearbeiten");
		model.addAttribute("page", "all");
		
		Optional<Task> opt = repo.findById(id);
		if(opt.isPresent()) { // Wenn ein Task für die ID gefunden wurde
			// Wird der Task an das Template weitergegeben
			model.addAttribute("task", opt.get());
			return "standard_form";
		}
		// Wenn nicht, wird auf die Übersicht weitergeleitet
		return "redirect:/all";
	}
	
	@RequestMapping("/all")
	public String showAll(Model model) {
		model.addAttribute("title", "All");
		model.addAttribute("headline", "Das sind alle Tasks");
		model.addAttribute("page", "all");
		model.addAttribute("tasks", repo.findAll());
		return "standard";
	}
}