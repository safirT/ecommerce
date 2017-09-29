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
 * @author Dimitri Leclercq Classe pour ajouter un produit dans le pannier et
 *         re-afficher le catalogue
 */
@Controller
@RequestMapping(AjouterPanierController.PATH)
public class AjouterPanierController {

	/**
	 * Chemin qui redirige vers le controller
	 */
	public static final String PATH = "ajouterPanier.do";
	private Integer idProd;
	
	final PanierMetier panierMetier = (PanierMetier) MyFactory.getInstance(PanierMetier.class);
	final ProduitMetier produitMetier = (ProduitMetier) MyFactory.getInstance(ProduitMetier.class);
	/**
	 * Méthode par défault appeler pour ajouter un produit dans le panier
	 * 
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(final HttpSession session, final HttpServletRequest req,
			@RequestParam(value = "produit", required = false) final String id) {
		try {
			idProd = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			return "redirect:catalogue.do";
		}

		final PanierDTO panier = (PanierDTO) session.getAttribute("panier");
		final ProduitDTO produitAAjouter = produitMetier.getProduitById(idProd);

		session.setAttribute("panier", panierMetier.ajouterUnProduitAuPanier(panier, produitAAjouter, req));
		session.setAttribute("redirection", "redirect:catalogue.do");
		return "redirect:catalogue.do";
	}

}
