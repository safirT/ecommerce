package formation.ecommerce.presentation.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import formation.ecommerce.metier.PanierMetier;
import formation.ecommerce.presentation.datas.PanierDTO;
import formation.ecommerce.transverse.MyFactory;

/**
 * Classe qui permet de vider le panier et rediriger vers la page actuel du
 * client
 * 
 * @author Dimitri Leclercq
 *
 */
@Controller
@RequestMapping(ViderPanierController.PATH)
public class ViderPanierController {

	/**
	 * Chemin qui redirige vers le controller
	 */
	public static final String PATH = "viderPanier.do";

	final PanierMetier panierMetier = (PanierMetier) MyFactory.getInstance(PanierMetier.class);

	/**
	 * Méthode par défaut pour vider le panier
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(final HttpSession session, final HttpServletRequest req) {

		session.setAttribute("panier", panierMetier.viderPanier((PanierDTO) session.getAttribute("panier")));
		return (String) session.getAttribute("redirection");
	}

}
