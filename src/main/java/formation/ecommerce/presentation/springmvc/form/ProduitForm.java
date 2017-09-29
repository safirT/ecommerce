package formation.ecommerce.presentation.springmvc.form;

import java.math.BigDecimal;

/**
 * Classe qui gére le formulaire pour l'insertion d'un produit
 * @author gfiuser
 *
 */
public class ProduitForm {
	/**
	 * Identifiant du champ id.
	 */
	public static final String FIELD_ID = "idProduit";

	/**
	 * Identifiant du champ libelle.
	 */
	public static final String FIELD_LIBELLE = "libelleProduit";

	/**
	 * Identifiant du champ prix.
	 */
	public static final String FIELD_PRIX = "prixProduit";

	private int idProduit;
	private String libelleProduit;
	private BigDecimal prixProduit;

	/**
	 * @return the idProduit
	 */
	public int getIdProduit() {
		return idProduit;
	}

	/**
	 * @param idProduit
	 *            the idProduit to set
	 */
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	/**
	 * @return the libelleProduit
	 */
	public String getLibelleProduit() {
		return libelleProduit;
	}

	/**
	 * @param libelleProduit
	 *            the libelleProduit to set
	 */
	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}

	/**
	 * @return the prixProduit
	 */
	public BigDecimal getPrixProduit() {
		return prixProduit;
	}

	/**
	 * @param prixProduit
	 *            the prixProduit to set
	 */
	public void setPrixProduit(BigDecimal prixProduit) {
		this.prixProduit = prixProduit;
	}

}
