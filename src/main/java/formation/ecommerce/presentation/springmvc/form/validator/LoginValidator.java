package formation.ecommerce.presentation.springmvc.form.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import formation.ecommerce.presentation.springmvc.form.LoginForm;

/**
 * Classe qui valide les champ du formulaire de login
 * @author Dimitri Leclercq
 *
 */
public class LoginValidator implements Validator {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(final Class<?> clazz) {
		// Déclare les classes supportées par ce validateur
		return LoginForm.class.isAssignableFrom(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(final Object target, final Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, LoginForm.FIELD_LOGIN, "global.erreur.champ.vide",
				new Object[] { LoginForm.FIELD_LOGIN });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, LoginForm.FIELD_PASSWORD, "global.erreur.champ.vide",
				new Object[] { LoginForm.FIELD_PASSWORD });
	}
}