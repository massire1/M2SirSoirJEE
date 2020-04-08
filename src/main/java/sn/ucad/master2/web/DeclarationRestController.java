package sn.ucad.master2.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.ucad.master2.entities.Habitation;
import sn.ucad.master2.entities.HabitationIndividuelle;
import sn.ucad.master2.entities.HabitationProffessionnelle;
import sn.ucad.master2.service.HabitationService;

@RestController
@RequestMapping("/dec")
public class DeclarationRestController {

	@Autowired
	private HabitationService habitationService;

	@GetMapping("/ws_declarationsIndiv")
	public List<HabitationIndividuelle> listeDeclarationsImpotsIndiv() {
		return habitationService.findAllHabitationsIndiv();
	}

	@GetMapping("/ws_declarationsPro")
	public List<HabitationProffessionnelle> listeDeclarationsImpotsPro() {
		return habitationService.findAllHabitationsPro();
	}

	@GetMapping("/ws_declaration/{id}")
	public Habitation afficherHabitation(@PathVariable("id") Long codeHabitation) {
		return habitationService.findHabitationById(codeHabitation);
	}

	@DeleteMapping("/ws_deleteDeclaration/{id}")
	public void deleteHabitation(@PathVariable("id") Long codeHabitation) {
		habitationService.deleteHabitation(codeHabitation);
	}

	@GetMapping("/ws_calculerImpot/{id}")
	public Double calculImpot(@PathVariable("id") Long codeHabitation) {
		return habitationService.calculImpot(codeHabitation);
	}

	@PostMapping("/ws_saveHabitationIndiv")
	public Habitation saveHabitation(@RequestBody(required = true) HabitationIndividuelle habitation) {
		return habitationService.saveHabitation(habitation);
	}

	@PostMapping("/ws_saveHabitationPro")
	public Habitation saveHabitation(@RequestBody(required = true) HabitationProffessionnelle habitation) {
		return habitationService.saveHabitation(habitation);
	}

}
