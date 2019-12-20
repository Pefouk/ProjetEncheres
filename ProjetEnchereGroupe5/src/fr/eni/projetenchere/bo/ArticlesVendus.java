/**
 * 
 */
package fr.eni.projetenchere.bo;

import java.sql.Date;

public class ArticlesVendus {

	private int noArticle;
	private String nomArticle;
	private String description;
	private Date debutEncheres;
	private Date finEncheres;
	private int prixInitial;
	private int prixVente;
	private int noUtilisateur;
	private Categories categorie;
	private Retraits retrait;

	public ArticlesVendus() {
	}

	public ArticlesVendus(int noArticle, String nomArticle, String description, Date debutEncheres, Date finEncheres,
			int prixInitial, int prixVente, int noUtilisateur, Categories categorie, Retraits retrait) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEncheres = debutEncheres;
		this.finEncheres = finEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.categorie = categorie;
		this.retrait = retrait;
	}

	/**
	 * @{inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ArticlesVendus [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", debutEncheres=" + debutEncheres + ", finEncheres=" + finEncheres + ", prixInitial=" + prixInitial
				+ ", prixVente=" + prixVente + ", noUtilisateur=" + noUtilisateur + ", categorie=" + categorie
				+ ", retrait=" + retrait + "]";
	}

	/**
	 * Constructeur.
	 * @param nomArticle
	 * @param description
	 * @param debutEncheres
	 * @param finEncheres
	 * @param prixInitial
	 * @param prixVente
	 * @param noUtilisateur
	 */
	public ArticlesVendus(String nomArticle, String description, Date debutEncheres, Date finEncheres, int prixInitial,
			int prixVente, int noUtilisateur) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEncheres = debutEncheres;
		this.finEncheres = finEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
	}

	/**
	 * Constructeur.
	 * @param nomArticle
	 * @param description
	 * @param debutEncheres
	 * @param finEncheres
	 * @param prixInitial
	 * @param prixVente
	 * @param noUtilisateur
	 * @param categorie
	 * @param retrait
	 */
	public ArticlesVendus(String nomArticle, String description, Date debutEncheres, Date finEncheres, int prixInitial,
			int prixVente, int noUtilisateur, Categories categorie, Retraits retrait) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEncheres = debutEncheres;
		this.finEncheres = finEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.categorie = categorie;
		this.retrait = retrait;
	}

	public int getNoArticle() {
		return noArticle;
	}
	
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	
	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDebutEncheres() {
		return debutEncheres;
	}

	public void setDebutEncheres(Date debutEncheres) {
		this.debutEncheres = debutEncheres;
	}

	public Date getFinEncheres() {
		return finEncheres;
	}

	public void setFinEncheres(Date finEncheres) {
		this.finEncheres = finEncheres;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public Categories getCategorie() {
		return categorie;
	}

	public void setCategorie(Categories categorie) {
		this.categorie = categorie;
	}

	public Retraits getRetrait() {
		return retrait;
	}

	public void setNoRetrait(Retraits retrait) {
		this.retrait = retrait;
	}
	
	
	
	
}
