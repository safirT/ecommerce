package formation.ecommerce.presentation.springmvc.controller;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import formation.ecommerce.metier.ProduitMetier;
import formation.ecommerce.presentation.datas.ProduitDTO;
import formation.ecommerce.presentation.springmvc.form.ProduitForm;
import formation.ecommerce.presentation.springmvc.form.validator.ProduitValidator;
import formation.ecommerce.transverse.MyFactory;

/**
 * Classe qui permet d'ajoutter un produit dans la liste
 * 
 * @author Dimitri Leclercq
 *
 */
@Controller
@RequestMapping(AjouterProduitController.PATH)
public class AjouterProduitController {

	/**
	 * Chemin qui redirige vers le controller
	 */
	public static final String PATH = "ajouterProduit.do";
	private static final ProduitValidator PRODUIT_VALIDATOR = new ProduitValidator();

	final ProduitMetier produitMetier = (ProduitMetier) MyFactory.getInstance(ProduitMetier.class);

	public static final String PRODUIT_FORM = "produitForm";

	public static final String PAGE_AJOUT_PRODUIT = "ajouterProduit";

	/**
	 * Méthode par défault appeler pour afficher la page
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get(final HttpSession session, final HttpServletRequest req) {
		return new ModelAndView(PAGE_AJOUT_PRODUIT, PRODUIT_FORM, new ProduitForm());
	}

	/**
	 * Méthode appeler lors de la validation du formulaire
	 * 
	 * @param session
	 * @param produitForm
	 * @param bindingResult
	 * @param modelMap
	 * @param req
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String traiterFormulaire(final HttpSession session, final ProduitForm produitForm,
			final BindingResult bindingResult, final ModelMap modelMap, final HttpServletRequest req) {
		PRODUIT_VALIDATOR.validate(produitForm, bindingResult);

		if (!bindingResult.hasErrors()) {
			if (estIdentifiantExistant(produitForm, req)) {
				return PAGE_AJOUT_PRODUIT;
			}

			if (produitForm.getIdProduit() < 0) {
				req.setAttribute("erreurIdNegatif", "Vous ne pouvez pas entrer d'id négatif.");
				return PAGE_AJOUT_PRODUIT;
			}

			if (produitForm.getPrixProduit().compareTo(BigDecimal.ZERO) == -1) {
				req.setAttribute("erreurPrixNégatif", "Vous ne pouvez pas entrer de prix négatif.");
				return PAGE_AJOUT_PRODUIT;
			}

			final Pattern patt = Pattern.compile("[a-zA-Z0-9]+");
			final Matcher m = patt.matcher(produitForm.getLibelleProduit());
			if (m.matches()) {

				produitMetier.ajouterUnProduit(new ProduitDTO(produitForm.getIdProduit(), produitForm
						.getLibelleProduit(), produitForm.getPrixProduit()));

				return "redirect:catalogue.do";
			} else {
				req.setAttribute("erreurLibelle", "Veuillez entrer un libelle sans caractères spéciaux");
			}

		} else {
			if (produitForm.getIdProduit() < 0) {
				req.setAttribute("erreurIdNegatif", "Vous ne pouvez pas entrer d'id négatif.");
			}

			if (bindingResult.getFieldError(ProduitForm.FIELD_ID) == null && estIdentifiantExistant(produitForm, req)) {
				return PAGE_AJOUT_PRODUIT;
			}

		}

		return PAGE_AJOUT_PRODUIT;
	}

	/**
	 * Méthode pour vérifier si avant de l'ajout d'un produit l'id est déja
	 * existant
	 * 
	 * @param produitForm
	 * @param req
	 */
	private boolean estIdentifiantExistant(final ProduitForm produitForm, final HttpServletRequest req) {
		for (final ProduitDTO p : produitMetier.getAllProduit()) {
			if (p.getId() == produitForm.getIdProduit()) {
				req.setAttribute("erreurProduitExistant", "Le produit associé a cet Id existe déja ! ");
				return true;
			}
		}
		return false;
	}
}
