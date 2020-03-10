package sn.ucad.master2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import sn.ucad.master2.entities.Produit;
import sn.ucad.master2.service.UserService;

@Controller
public class DeclarationController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/listDeclarations")
	public ModelAndView listDeclarations(ModelAndView model) {
		Produit produit = new Produit();
		model.addObject("produit", produit);
		model.setViewName("listDeclarations");
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
