package formation.ecommerce.presentation.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Classe qui permet d'afficher le panier
 * 
 * 
 * @author Dimitri Leclercq
 *
 */
@Controller
@RequestMapping(AfficherPanierController.PATH)
public class AfficherPanierController {

	/**
	 * Chemin qui redirige vers le controller
	 */
	public static final String PATH = "afficherPanier.do";

	/**
	 * Méthode par défault appeler pour afficher la page
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(final HttpSession session, final HttpServletRequest req) {
		session.setAttribute("redirection", "redirect:afficherPanier.do");
		req.setAttribute("panier", session.getAttribute("panier"));
		return "panier";
	}

}