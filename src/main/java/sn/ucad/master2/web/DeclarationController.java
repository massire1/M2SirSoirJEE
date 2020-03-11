package sn.ucad.master2.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
		System.out.println("deleting...");
		String code = request.getParameter("code");
		habitationService.deleteHabitation(habitationService.findHabitationById(Long.parseLong(code)));
		
		ModelAndView model = new ModelAndView("redirect:/listDeclarations");
		return model;
	}
	
	@GetMapping(value = "/addDeclaration")
	public ModelAndView newProduit(ModelAndView model) {
		Produit produit = new Produit();
		model.addObject("produit", produit);
		model.setViewName("addDeclaration");
		return model;
	}
}
