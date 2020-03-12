package sn.ucad.master2.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import sn.ucad.master2.entities.Habitation;
import sn.ucad.master2.entities.HabitationIndividuelle;
import sn.ucad.master2.entities.HabitationProffessionnelle;
import sn.ucad.master2.entities.Produit;
import sn.ucad.master2.service.HabitationService;

@Controller
public class DeclarationController {

	@Autowired
	private HabitationService habitationService;

	@GetMapping(value = "/listDeclarations")
	public ModelAndView listDeclarations(ModelAndView model) {
		
		List<HabitationIndividuelle> listeHabitIndivs = habitationService.findAllHabitationsIndiv();
		List<HabitationProffessionnelle> listeHabitPros = habitationService.findAllHabitationsPro();
		
		model.addObject("listeHabitIndivs", listeHabitIndivs);
		model.addObject("listeHabitPros", listeHabitPros);
		
		model.setViewName("listDeclarations");
		
		return model;
	}
	
	@GetMapping(value = "/deleteHabitation")
	public ModelAndView deleteHabitation(HttpServletRequest request) {
		
		String code = request.getParameter("code");
		habitationService.deleteHabitation(habitationService.findHabitationById(Long.parseLong(code)));
		
		ModelAndView model = new ModelAndView();
		model.addObject("successMessage", "Suppression effectuée avec succés");
		model.setViewName("redirect:/listDeclarations");
		return model;
	}
	
	@GetMapping(value = "/editHabitation")
	public ModelAndView editHabitation(HttpServletRequest request) {
		
		ModelAndView model = new ModelAndView("editDeclaration");
		
		String code = request.getParameter("code");
		Habitation habitation = habitationService.findHabitationById(Long.parseLong(code));
		Boolean isIndiv = false;
				
		if (habitation instanceof HabitationIndividuelle) {
			HabitationIndividuelle habitationIndividuelle = (HabitationIndividuelle) habitation;
			model.addObject("habitation", habitationIndividuelle);
			isIndiv = true;
		} else {
			HabitationProffessionnelle habitationProffessionnelle = (HabitationProffessionnelle) habitation;
			model.addObject("habitation", habitationProffessionnelle);
		}
		
		model.addObject("isHabitIndivBool", isIndiv);
		
		return model;
	}
	
	@PostMapping(value = "/saveHabitationIndiv")
	public ModelAndView saveHabitationIndiv(@ModelAttribute("habitation") @Valid HabitationIndividuelle habitation, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("editDeclaration");
			modelAndView.addObject("habitation", habitation);
			modelAndView.addObject("isHabitIndivBool", true);
		} else {
			habitationService.saveHabitation(habitation);
			modelAndView.addObject("successMessage", "Mise à jour effectuée avec succés");
			modelAndView.setViewName("redirect:/listDeclarations");
		}
		
		return modelAndView;
	}
	
	@PostMapping(value = "/saveHabitationPro")
	public ModelAndView saveHabitationIndiv(@ModelAttribute("habitation") @Valid HabitationProffessionnelle habitation, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("editDeclaration");
			modelAndView.addObject("habitation", habitation);
			modelAndView.addObject("isHabitIndivBool", false);
		} else {
			habitationService.saveHabitation(habitation);
			modelAndView.addObject("successMessage", "Mise à jour effectuée avec succés");
			modelAndView.setViewName("redirect:/listDeclarations");
		}
		return modelAndView;
	}
	
	@GetMapping(value = "/addHabitationIndiv")
	public ModelAndView addHabitationIndiv(ModelAndView model) {
		HabitationIndividuelle habitation = new HabitationIndividuelle();
		model.addObject("habitation", habitation);
		model.addObject("isHabitIndivBool", true);
		model.setViewName("editDeclaration");
		return model;
	}
	
	@GetMapping(value = "/addHabitationPro")
	public ModelAndView addHabitationPro(ModelAndView model) {
		HabitationProffessionnelle habitation = new HabitationProffessionnelle();
		model.addObject("habitation", habitation);
		model.addObject("isHabitIndivBool", false);
		model.setViewName("editDeclaration");
		return model;
	}
}
