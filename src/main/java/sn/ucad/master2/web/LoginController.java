package sn.ucad.master2.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sn.ucad.master2.entities.Utilisateur;
import sn.ucad.master2.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") long id) {
		// logger.info("Fetching User with id {}", id);
		Utilisateur user = userService.findById(id);
		if (user == null) {
			// logger.error("User with id {} not found.", id);
			return new ResponseEntity("", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Utilisateur>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		Utilisateur user = new Utilisateur();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser (@ModelAttribute("user") @Valid Utilisateur user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Utilisateur userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new Utilisateur());
			modelAndView.setViewName("listProduit");

		}
		return modelAndView;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null)
			return new ModelAndView("redirect:/login");
		else {
			// ModelAndView modelAndView = new ModelAndView();
//			Utilisateur user = userService.findUserByEmail(auth.getName());
//			modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
//			modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
			// modelAndView.setViewName("listProduit");
			return new ModelAndView("redirect:/listProduits");
		}

	}

	@GetMapping("/acces-interdit")
	public String accessDenied() {
		return "/acces-interdit";
	}

}
