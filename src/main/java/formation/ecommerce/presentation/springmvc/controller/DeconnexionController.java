package formation.ecommerce.presentation.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Dimitri Leclercq Classe qui permet de déconnecter l'utilisateur
 */
@Controller
@RequestMapping(DeconnexionController.PATH)
public class DeconnexionController {

	/**
	 * Chemin qui redirige vers le controller
	 */
	public static final String PATH = "deconnexion.do";

	/**
	 * Méthode appeller par défaut pour ce déconnecter
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(final HttpSession session) {
		session.invalidate();

		return "redirect:login.do";
	}

}
