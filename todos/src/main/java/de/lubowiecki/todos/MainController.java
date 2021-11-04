package de.lubowiecki.todos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// MVC = Model View Controller
// MainController ist der Controller
// TaskRepository und Task sind das Model
// standard.jsp und andere Templates sind View

@Controller
public class MainController {
	
	@Autowired // Spring baut automatisch ein Objekt und weist es hier zu
	private TaskRepository repo;
	
	@RequestMapping("/") // Methode wird verarbeitet, wenn http://localhost:8080/ aufgerufen wird
	public String home(Model model) {
		// Über model kann man Werte an das Template weitergeben
		// Namen für Attribute sind frei wählbar
		model.addAttribute("title", "Home");
		model.addAttribute("headline", "Neuer Task");
		
		//TODO Task mit Daten aus dem Formular bauen und in die DB speichern
		Task t = new Task("Dies und das", "Bla bla bla bla bla...");
		repo.save(t);
		
		return "standard_form"; // sucht standard_form.jsp im WEB-INF/tpl-Ordner
	}
	
	@RequestMapping("/open") // Methode wird verarbeitet, wenn http://localhost:8080/open aufgerufen wird
	public String showOpen(Model model) {
		model.addAttribute("title", "Open");
		model.addAttribute("headline", "Das sind die noch offenen Tasks");
		
//		List<Task> openList = new ArrayList<>();
//		openList.add(new Task("Steuererklärung", "..."));
//		openList.add(new Task("Schuhe kleben", "Sohle richtig rankleben"));
//		openList.add(new Task("Flaschen wegbringen", "Alle Flaschen zum Container bringen"));
//		model.addAttribute("tasks", openList);
		
		//model.addAttribute("tasks", repo.findAll()); // Liefert alle Datensätze
		model.addAttribute("tasks", repo.findByDoneAtIsNull());
		
		return "standard"; // Auswahl des Templates
	}
	
	@RequestMapping("/done")
	public String showDone(Model model) {
		model.addAttribute("title", "Done");
		model.addAttribute("headline", "Das sind die erledigten Tasks");
//		
//		List<Task> openList = new ArrayList<>();
//		openList.add(new Task("Kinder von Kita abholen", "..."));
//		openList.add(new Task("Handy reparieren", "..."));
//		model.addAttribute("tasks", openList);
		model.addAttribute("tasks", repo.findByDoneAtIsNotNull());
		
		return "standard";
	}
	
	@RequestMapping("/all")
	public String showAll(Model model) {
		model.addAttribute("title", "All");
		model.addAttribute("headline", "Das sind alle Tasks");
		model.addAttribute("tasks", repo.findAll());
		return "standard";
	}
}