package formation.ecommerce.presentation.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import formation.ecommerce.metier.ProduitMetier;
import formation.ecommerce.persistance.dao.ProduitDao;
import formation.ecommerce.persistance.dao.jdbc.ProduitDaoJdbc;
import formation.ecommerce.presentation.datas.PanierDTO;
import formation.ecommerce.presentation.datas.ProduitDTO;
import formation.ecommerce.transverse.MyFactory;

/**
 * Classe qui affiche le catalogue des produit
 * 
 * @author Dimitri Leclercq
 */
@Controller
@RequestMapping(CatalogueController.PATH)
public class CatalogueController {

	/**
	 * Chemin qui redirige vers le controller
	 */
	public static final String PATH = "catalogue.do";
	final ProduitMetier produitMetier = (ProduitMetier) MyFactory.getInstance(ProduitMetier.class);
	
	/**
	 * Méthode par défault pour afficher le catalogue
	 * 
	 * @param session
	 * @param req
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(final HttpSession session, final HttpServletRequest req) {
		req.setAttribute("listProduit", produitMetier.getAllProduit());
		final PanierDTO panier = (PanierDTO) session.getAttribute("panier");
		req.setAttribute("panier", session.getAttribute("panier"));
		req.setAttribute("nbProduitPanier", panier.getMapPanier().size());
		req.setAttribute("totalPanier", panier.getMontant());
		session.setAttribute("redirection", "redirect:catalogue.do");
		return "catalogue";
	}

}
