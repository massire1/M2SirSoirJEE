package sn.ucad.master2.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sn.ucad.master2.entities.Produit;
import sn.ucad.master2.repository.ICatalogueDaoRepository;

/**
 * Servlet implementation class ProduitServletControleur
 */
@Controller
public class ProduitSpringControleur {

	@Autowired
	private ICatalogueDaoRepository catalogueRepository;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProduitSpringControleur() {
		super();
		// myDaoCatalogue = new CatalogueDaoImpl();
	}

	@RequestMapping(value = "/rechercher")
	public ModelAndView rechercherProduits(HttpServletRequest request) throws IOException {
		String designation = request.getParameter("designation");
		List<Produit> mesProduits = catalogueRepository.findByDesignation(designation);
		ModelAndView model = new ModelAndView();
		model.addObject("produits", mesProduits);
		model.setViewName("listProduit");
		return model;
	}

	@RequestMapping(value = "/listProduits", method = RequestMethod.GET)
	public ModelAndView listProduits(ModelAndView model) throws IOException {
		List<Produit> mesProduits = catalogueRepository.findAll();
		model.addObject("produits", mesProduits);
		model.setViewName("listProduit");
		return model;
	}

	@RequestMapping(value = "/addProduits", method = RequestMethod.GET)
	public ModelAndView newProduit(ModelAndView model) {
		Produit produit = new Produit();
		model.addObject("produit", produit);
		model.setViewName("addProduit");
		return model;
	}

	@RequestMapping(value = "/saveProduit", method = RequestMethod.POST)
	public ModelAndView saveProduit(@ModelAttribute Produit produit) {
		catalogueRepository.saveAndFlush(produit);
		return new ModelAndView("redirect:/listProduits.mvc");
	}

	@RequestMapping(value = "/deleteProduit", method = RequestMethod.GET)
	public ModelAndView deleteProduit(HttpServletRequest request) {
		String reference = request.getParameter("reference");
		catalogueRepository.delete(catalogueRepository.findByReference(reference));
		return new ModelAndView("redirect:/listProduits.mvc");
	}

	@RequestMapping(value = "/editProduit", method = RequestMethod.GET)
	public ModelAndView editProduit(HttpServletRequest request) {
		String reference = request.getParameter("reference");
		Produit produit = catalogueRepository.findByReference(reference);
		ModelAndView model = new ModelAndView("addProduit");
		model.addObject("produit", produit);

		return model;
	}

	@RequestMapping(value = "/listProduits{ref}", method = RequestMethod.GET)
	public ModelAndView getProduitByRef(@PathVariable("ref") String ref) {
		ModelAndView model = new ModelAndView("listProduit");
		model.addObject("produits", catalogueRepository.findByReference(ref));
		model.setViewName("listProduit");
		return model;
	}

}
