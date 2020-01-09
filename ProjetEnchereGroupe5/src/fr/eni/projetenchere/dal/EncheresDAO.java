/**
 * 
 */
package fr.eni.projetenchere.dal;

import java.util.List;

import fr.eni.projetenchere.bo.ArticlesVendus;
import fr.eni.projetenchere.bo.Categories;
import fr.eni.projetenchere.bo.Encheres;
import fr.eni.projetenchere.bo.Retraits;

public interface EncheresDAO {

	
	Encheres createEnchere(Retraits r, ArticlesVendus a, Encheres e, Categories c) throws DALException;
	Encheres selectEnchere(int noArticle)throws DALException;
	List<Encheres> selectAll() throws DALException;
	List<Encheres> selectEnCours() throws DALException;
	List<Encheres> selectByCategorie(int noCategorie) throws DALException;
 	
	List<Categories> selectCategories() throws DALException;
	List<Encheres> selectByUser(int Utilisateurs) throws DALException;
	List<Encheres> selectEnchGagne(Categories c) throws DALException;
	List<Encheres> selectByMotCle(String nomArticle) throws DALException;
	
}
//INSERT CATEGORIES ( libelle) values ('trop bien')
//
//INSERT RETRAITS (rue, code_postal, ville) values ('rue de la conterie', 35000, 'Rennes')
//
//INSERT ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, no_retrait) 
//values ('Fauteuil', 'Neuf 3 places', '25/05/2018', '02/06/2018', 200, 260, 1, 1, 1)
//
//INSERT ENCHERES (no_article ,date_enchere, montant_enchere, no_utilisateur) values (1, GETDATE(), 210, 1)
//
//INSERT UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) 
//VALUES ('YatiFheng', 'Dupres', 'Michel', 'Michel.dupres@gmail.fr', 0908070605, 'rue des collerets', 35000, 'Rennes', 'Michel', 350, 'false')
//SELECT * FROM ARTICLES_VENDUS where nom_article= 'Fauteuil'
//
//SELECT * FROM CATEGORIES
//SELECT * FROM RETRAITS
//SELECT * FROM ARTICLES_VENDUS
//SELECT * FROM UTILISATEURS
//
//SELECT * FROM ARTICLES_VENDUS where nom_article= 'Fauteuil'