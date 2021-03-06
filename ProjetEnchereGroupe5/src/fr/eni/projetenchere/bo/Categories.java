/**
 * 
 */
package fr.eni.projetenchere.bo;

public class Categories {

	/**
	 * @{inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Categories [noCategorie=" + noCategorie + ", libelle=" + libelle + "]";
	}

	private int noCategorie;
	private String libelle;

	public Categories() {
	}

	public Categories(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	public Categories(String libelle) {
		super();
		this.libelle = libelle;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
	
}
