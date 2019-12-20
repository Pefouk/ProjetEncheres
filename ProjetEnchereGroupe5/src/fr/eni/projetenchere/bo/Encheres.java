/**
 * 
 */
package fr.eni.projetenchere.bo;

import java.sql.Date;

public class Encheres {

	private Date dateEnchere;
	private int montantEnchere;
	private ArticlesVendus article;
	private int noUtilisateur;

	/**
	 * @{inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Encheres [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", article=" + article
				+ ", noUtilisateur=" + noUtilisateur + "]";
	}

	public Encheres() {}
	
	public Encheres(Date dateEnchere, int montantEnchere, int noUtilisateur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noUtilisateur = noUtilisateur;
	}

	public Encheres(Date dateEnchere, int montantEnchere, ArticlesVendus article, int noUtilisateur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.article = article;
		this.noUtilisateur = noUtilisateur;
	}



	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public ArticlesVendus getArticle() {
		return article;
	}

	public void setArticle(ArticlesVendus article) {
		this.article = article;
	}
	
	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	

}
