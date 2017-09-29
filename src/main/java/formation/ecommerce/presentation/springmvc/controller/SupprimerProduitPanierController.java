package formation.ecommerce.presentation.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import formation.ecommerce.metier.PanierMetier;
import formation.ecommerce.metier.ProduitMetier;
import formation.ecommerce.metier.impl.ProduitMetierImpl;
import formation.ecommerce.presentation.datas.PanierDTO;
import formation.ecommerce.presentation.datas.ProduitDTO;
import formation.ecommerce.transverse.MyFactory;

/**
 * @author Dimitri Leclercq Classe pour supprimer un produit du pannier
 */
@Controller
@RequestMapping(SupprimerProduitPanierController.PATH)
public class SupprimerProduitPanierController {

	/**
	 * Chemin qui redirige vers le controller
	 */
	public static final String PATH = "supprimerProduitPanier.do";
	private Integer idProd;

	final PanierMetier panierMetier = (PanierMetier) MyFactory.getInstance(PanierMetier.class);
	final ProduitMetier produitMetier = (ProduitMetier) MyFactory.getInstance(ProduitMetier.class);
	/**
	 * Méthode par défaut pour suppirmer un produit du pannier
	 * 
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(final HttpSession session, final HttpServletRequest req,
			@RequestParam(value = "produit", required = false) final String id) {
		final PanierDTO panier = (PanierDTO) session.getAttribute("panier");

		try {
			idProd = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			return "redirect:afficherPanier.do";
		}

		final ProduitDTO produitASupprimer = produitMetier.getProduitById(idProd);

		session.setAttribute("panier", panierMetier.supprimerUnProduitDuPanier(panier, produitASupprimer, req));
		session.setAttribute("redirection", "redirect:afficherPanier.do");
		return "redirect:afficherPanier.do";
	}

}
