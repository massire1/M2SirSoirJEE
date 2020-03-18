package sn.ucad.master2.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sn.ucad.master2.entities.Utilisateur;
import sn.ucad.master2.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public ModelAndView listProduits(ModelAndView model) throws IOException {
		List<Utilisateur> users = userService.findAllUsers();
		model.addObject("users", users);
		model.setViewName("listUsers");
		return model;
	}
}
