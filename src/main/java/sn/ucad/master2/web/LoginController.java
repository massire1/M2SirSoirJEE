package sn.ucad.master2.web;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sn.ucad.master2.entities.Utilisateur;
import sn.ucad.master2.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping(value = { "/", "/login" })
	public ModelAndView login() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@GetMapping(value = {"/home"})
	public ModelAndView home(HttpServletRequest request) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null)
			return new ModelAndView("redirect:/login");
		
		else {			
			Utilisateur user = userService.findUserByEmail(auth.getName());
			
			if (user == null)
				return new ModelAndView("redirect:/login");
			
			request.getSession().setAttribute("userConnected", user);
			
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("userConnected", user);
			modelAndView.setViewName("home");
			return modelAndView;

		}

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

	@GetMapping(value = "/registration")
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		Utilisateur user = new Utilisateur();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@PostMapping(value = "/registration")
	public ModelAndView createNewUser (@ModelAttribute("user") @Valid Utilisateur user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Utilisateur userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"Cet email est a déjà été utilisé");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "Inscription effectuée avec succés!");
			modelAndView.setViewName("redirect:/login");

		}
		return modelAndView;
	}

	@GetMapping("/acces-interdit")
	public String accessDenied() {
		return "/acces-interdit";
	}

}
