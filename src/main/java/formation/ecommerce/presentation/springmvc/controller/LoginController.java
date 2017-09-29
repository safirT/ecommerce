package formation.ecommerce.presentation.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import formation.ecommerce.presentation.datas.PanierDTO;
import formation.ecommerce.presentation.springmvc.form.LoginForm;
import formation.ecommerce.presentation.springmvc.form.validator.LoginValidator;

/**
 * @author Dimitri Leclercq Classe appeler pour la connexions
 */
@Controller
@RequestMapping(LoginController.PATH)
public class LoginController {

	/**
	 * Chemin qui redirige vers le controller
	 */
	public static final String PATH = "login.do";
	/**
	 * Identifiant Formulaire.
	 */
	public static final String LOGIN_FORM = "loginForm";

	private static final LoginValidator LOGIN_VALIDATOR = new LoginValidator();

	/**
	 * Paramètre pour obtenir le nom utilisateur stocké en session.
	 */
	public static final String SESSION_NOM_UTILISATEUR = "nomUtilisateur";
	/**
	 * Paramètre pour obtenir le pannier stocké en session.
	 */
	public static final String SESSION_PANIER = "panier";
	private static final String PAGE_CATALOGUE = "catalogue";
	private static final String PAGE_LOGIN = "login";

	/**
	 * Initialisation du validateur du formulaire d'authentification.
	 *
	 * @param dataBinder
	 */
	@InitBinder
	public void initBinder(final WebDataBinder dataBinder) {
		dataBinder.setValidator(LOGIN_VALIDATOR);
	}

	/**
	 * Initialisation de la vue. PAGE_LOGIN = nom de la vue LOGIN_FORM = nom du
	 * modèle Dernier paramètre = instance du modèle
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet() {
		return new ModelAndView(PAGE_LOGIN, LOGIN_FORM, new LoginForm());
	}

	/**
	 * Méthode qui va traiter le formulaire d'authentification.
	 *
	 * @param session
	 *            {@link HttpSession}
	 * @param loginForm
	 *            Formulaire d'authentification.
	 * @param bindingResult
	 *            Résultat d'une action. Sert pour la validation du formulaire
	 * @param modelMap
	 *            Map contenant le modele.
	 * @return La page de redirection à afficher.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String traiterFormulaire(final HttpSession session, final LoginForm loginForm,
			final BindingResult bindingResult, final ModelMap modelMap, final HttpServletRequest req) {
		String pageDeRedirection = PAGE_LOGIN;
		LOGIN_VALIDATOR.validate(loginForm, bindingResult);
		if ((!bindingResult.hasErrors()) && ("abc".equals(loginForm.getMdpUtilisateur()))
				&& ("xyz".equals(loginForm.getNomUtilisateur()))) {
			initialiserSession(session, loginForm.getNomUtilisateur());
			pageDeRedirection = PAGE_CATALOGUE;
		}
		else return pageDeRedirection;
		session.setAttribute("redirection", "redirect:catalogue.do");
		return "redirect:" + pageDeRedirection + ".do";
	}

	private void initialiserSession(final HttpSession session, final String nomUtilisateur) {
		session.setAttribute(SESSION_NOM_UTILISATEUR, nomUtilisateur);
		final PanierDTO panier = new PanierDTO();
		session.setAttribute(SESSION_PANIER, panier);

	}
}
