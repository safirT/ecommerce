package formation.ecommerce.presentation.springmvc.form;

/**
 * @author Dimitri Leclercq
 *
 */
public class LoginForm {
	/**
	 * Identifiant du champ login.
	 */
	public static final String FIELD_LOGIN = "nomUtilisateur";

	/**
	 * Identifiant du champ password.
	 */
	public static final String FIELD_PASSWORD = "mdpUtilisateur";

	private String nomUtilisateur;
	private String mdpUtilisateur;

	/**
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	/**
	 * @param nomUtilisateur
	 *            the nomUtilisateur to set
	 */
	public void setNomUtilisateur(final String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	/**
	 * @return the mdpUtilisateur
	 */
	public String getMdpUtilisateur() {
		return mdpUtilisateur;
	}

	/**
	 * @param mdpUtilisateur
	 *            the mdpUtilisateur to set
	 */
	public void setMdpUtilisateur(final String mdpUtilisateur) {
		this.mdpUtilisateur = mdpUtilisateur;
	}
}