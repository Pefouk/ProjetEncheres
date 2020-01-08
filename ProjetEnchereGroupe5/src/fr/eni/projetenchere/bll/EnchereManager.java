/**
 * 
 */
package fr.eni.projetenchere.bll;

import java.sql.Date;

import fr.eni.projetenchere.bo.ArticlesVendus;
import fr.eni.projetenchere.bo.Categories;
import fr.eni.projetenchere.bo.Encheres;
import fr.eni.projetenchere.bo.Retraits;
import fr.eni.projetenchere.dal.DAOFactory;
import fr.eni.projetenchere.dal.EncheresDAO;

/**
 * Classe en charge de
 * 
 * @author kreine2019
 * @version ProjetEncheresGIT - v1.0
 * @date 7 janv. 2020 - 11:27:50
 */
public class EnchereManager {
	private EncheresDAO dao;

	public EnchereManager() {
		this.dao = DAOFactory.getEncheresDAO();
	}

	public Encheres createEncheres(int noUtilisateur, String nomarticle, String description, String categorie,
			String miseaprix, String datefin, String rue, String codepostal, String ville) throws BLLException {
		// condition
		int categ;
		int prix;
		Date dateDeFin = Date.valueOf(datefin);

		if (nomarticle == null || description == null || categorie == null || miseaprix == null || datefin == null
				|| rue == null || codepostal == null || ville == null)
			throw new BLLException("Un des champs est vide !");

		if (nomarticle.length() > 30) {
			throw new BLLException("La taille maximum a été atteinte !");
		}

		if (description.length() > 300) {
			throw new BLLException("La taille maximum a été atteinte !");
		}

		try {
			categ = Integer.valueOf(categorie);

		} catch (Exception e) {
			throw new BLLException("Il faut mettre des chiffres !");
		}

		try {
			prix = Integer.valueOf(miseaprix);
		} catch (Exception e) {
			throw new BLLException("Il faut mettre des chiffres !");
		}

		if (codepostal.length() != 5)
			throw new BLLException("Code postal invalide !");
		try {
			Integer.getInteger(codepostal);
		} catch (Exception e) {
			throw new BLLException("Code postal invalide ! Il ne doit contenir que des chiffres !");
		}

		try {
			dateDeFin = Date.valueOf(datefin);

		} catch (Exception e) {
			throw new BLLException("Le date n'est pas valide !");
		}

		if (rue.length() > 30) {
			throw new BLLException("La taille maximum a été atteinte !");
		}

		if (ville.length() > 30) {
			throw new BLLException("La taille maximum a été atteinte !");
		}

		Encheres e = new Encheres();
		e.setMontantEnchere(prix);

		ArticlesVendus a = new ArticlesVendus();
		a.setNomArticle(nomarticle);
		a.setDescription(description);
		a.setFinEncheres(dateDeFin);
		a.setPrixInitial(prix);
		a.setPrixVente(prix);
		a.setNoUtilisateur(noUtilisateur);

		Retraits r = new Retraits();
		r.setRue(rue);
		r.setVille(ville);
		r.setCodePostal(codepostal);

		Categories c = new Categories();
		c.setNoCategorie(categ);

		a.setCategorie(c);
		a.setNoRetrait(r);
		e.setArticle(a);
		e.setNoUtilisateur(noUtilisateur);
		// BDD
		try {
			e = this.dao.createEnchere(r, a, e, c);
		} catch (Exception e2) {
			throw new BLLException("La création de l'enchère a échouée !");
		}
		return e;
	}

}
