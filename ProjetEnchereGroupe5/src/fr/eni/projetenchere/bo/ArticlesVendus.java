/**
 * 
 */
package fr.eni.projetenchere.bo;

import java.util.Date;

public class ArticlesVendus {

	private int noArticle;
	private String nomArticle;
	private String description;
	private Date debutEncheres;
	private Date finEncheres;
	private int prixInitial;
	private int prixVente;
	private int noUtilisateur;
	private int noCategorie;
	private int noRetrait;

	public ArticlesVendus() {
	}

	public ArticlesVendus(int noArticle, String nomArticle, String description, Date debutEncheres, Date finEncheres,
			int prixInitial, int prixVente, int noUtilisateur, int noCategorie, int noRetrait) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEncheres = debutEncheres;
		this.finEncheres = finEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		this.noRetrait = noRetrait;
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

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public int getNoRetrait() {
		return noRetrait;
	}

	public void setNoRetrait(int noRetrait) {
		this.noRetrait = noRetrait;
	}
	
	
	
	
}
