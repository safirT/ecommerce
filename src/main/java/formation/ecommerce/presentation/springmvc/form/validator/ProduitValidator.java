package formation.ecommerce.presentation.springmvc.form.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import formation.ecommerce.presentation.springmvc.form.ProduitForm;

/**
 * Classes qui valide le formulaire des produits
 * @author gfiuser
 *
 */
public class ProduitValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProduitForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ProduitForm.FIELD_ID, "global.erreur.champ.vide",
				new Object[] { ProduitForm.FIELD_ID });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ProduitForm.FIELD_LIBELLE, "global.erreur.champ.vide",
				new Object[] { ProduitForm.FIELD_LIBELLE });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ProduitForm.FIELD_PRIX, "global.erreur.champ.vide",
				new Object[] { ProduitForm.FIELD_PRIX });

	}

}
