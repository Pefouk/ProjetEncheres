/**
 * 
 */
package fr.eni.projetenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import fr.eni.projetenchere.bo.ArticlesVendus;
import fr.eni.projetenchere.bo.Categories;
import fr.eni.projetenchere.bo.Encheres;
import fr.eni.projetenchere.bo.Retraits;
import fr.eni.projetenchere.dal.ConnectionProvider;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.EncheresDAO;

public class EncheresDAOJDBCIMPL implements EncheresDAO {

	private final String SELECT_ENCHERES = "SELECT * FROM ENCHERES inner join ARTICLES_VENDUS on ARTICLES_VENDUS.no_article = ENCHERES.no_article inner join CATEGORIES on CATEGORIES.no_categorie = ARTICLES_VENDUS.no_categorie inner join RETRAITS on RETRAITS.no_retrait = ARTICLES_VENDUS.no_retrait where ENCHERES.no_article=?";
	private final String INSERT_ENCHERES = "INSERT ENCHERES (no_article ,date_enchere, montant_enchere, no_utilisateur) values (?, GETDATE(), ?, ?)";
	private final String INSERT_ARTICLE = "INSERT ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, no_retrait) values (?, ?, GETDATE(), ?, ?, ?, ?, ?, ?)";
	private final String INSERT_RETRAIT = "INSERT RETRAITS (rue, code_postal, ville) values (?, ?, ?)";
	private final String SELECT_ALL = "SELECT * FROM ENCHERES inner join ARTICLES_VENDUS on ARTICLES_VENDUS.no_article = ENCHERES.no_article inner join CATEGORIES on CATEGORIES.no_categorie = ARTICLES_VENDUS.no_categorie inner join RETRAITS on RETRAITS.no_retrait = ARTICLES_VENDUS.no_retrait";
	private final String SELECT_EN_COURS = "SELECT * FROM ENCHERES inner join ARTICLES_VENDUS on ARTICLES_VENDUS.no_article = ENCHERES.no_article inner join CATEGORIES on CATEGORIES.no_categorie = ARTICLES_VENDUS.no_categorie inner join RETRAITS on RETRAITS.no_retrait = ARTICLES_VENDUS.no_retrait where ARTICLES_VENDUS.date_debut_encheres <= GETDATE() and ARTICLES_VENDUS.date_fin_encheres >= GETDATE()";
	private final String SELECT_BY_CATEGORIE = "SELECT * FROM ENCHERES inner join ARTICLES_VENDUS on ARTICLES_VENDUS.no_article = ENCHERES.no_article inner join CATEGORIES on CATEGORIES.no_categorie = ARTICLES_VENDUS.no_categorie inner join RETRAITS on RETRAITS.no_retrait = ARTICLES_VENDUS.no_retrait where CATEGORIES.no_categorie = ?";
	@Override
	public Encheres createEnchere(Retraits r, ArticlesVendus a, Encheres e, Categories c) throws DALException {
		Connection con = null;
		PreparedStatement stm1 = null;
		PreparedStatement stm2 = null;
		PreparedStatement stm3 = null;
		ResultSet rslt = null;
		ResultSet rslt2 = null;

		try {
			con = ConnectionProvider.getConnection();
			con.setAutoCommit(false);
			stm1 = con.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
			stm2 = con.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			stm3 = con.prepareStatement(INSERT_ENCHERES, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stm1.setString(1, r.getRue());
			stm1.setString(2, r.getCodePostal());
			stm1.setString(3, r.getVille());
			stm1.executeUpdate();
			rslt = stm1.getGeneratedKeys();			
			rslt.next();
			r.setNoRetrait(rslt.getInt(1));
			
			stm2.setString(1, a.getNomArticle());
			stm2.setString(2, a.getDescription());
			stm2.setDate(3, a.getFinEncheres());
			stm2.setInt(4, a.getPrixInitial());
			stm2.setInt(5, a.getPrixVente());
			stm2.setInt(6, a.getNoUtilisateur());
			stm2.setInt(7, a.getCategorie().getNoCategorie());
			stm2.setInt(8, a.getRetrait().getNoRetrait());
			stm2.executeUpdate();
			rslt2 = stm2.getGeneratedKeys();	
			rslt2.next();
			a.setNoArticle(rslt2.getInt(1));
			
			stm3.setInt(1, e.getArticle().getNoArticle());
			stm3.setInt(2, e.getMontantEnchere());
			stm3.setInt(3, e.getNoUtilisateur());
			stm3.executeUpdate();
			a.setNoRetrait(r);
			e.setArticle(a);
			con.commit();
	
		} catch (Exception e2) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new DALException("Erreur lors du rollback");
			}
			e2.printStackTrace();
			throw new DALException("Echec lors de l'ajout de l'enchère en base de donnée");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stm1 != null) {
					stm1.close();
				}
				if (stm2 != null) {
					stm2.close();
				}
				if (stm3 != null) {
					stm3.close();
				}
				if (rslt != null) {
					rslt.close();
				}
				if (rslt2 != null) {
					rslt2.close();
				}
			} catch (Exception e3) {
				throw new DALException("Erreur lors de la fermeture de la connexion, du resultset ou du preparedStatement");
			}
		}
		return e;
	}
	
	
	@Override
	public Encheres selectEnchere(int noArticle) throws DALException {
		ResultSet rslt = null;
		Encheres en = new Encheres();
		
		try(Connection con = ConnectionProvider.getConnection();PreparedStatement stm1 = con.prepareStatement(SELECT_ENCHERES);)
		{
			stm1.setInt(1, noArticle);
			rslt = stm1.executeQuery();
			if (rslt.next()) {
				
				en = recupererEnchere(rslt);
				
			}else {
				throw new DALException("Pas d'encheres !");
			}
			
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}finally {
			try {
				if (rslt !=null) {
					rslt.close();
				}
			} catch (Exception e2) {
				throw new DALException("Erreur lors de la fermeture du resultstet !");
			}
		}
			
		
		return en;
	}
	
	private Encheres recupererEnchere(ResultSet rslt) throws SQLException{
		Categories c = new Categories();
		Retraits r = new Retraits();
		ArticlesVendus a = new ArticlesVendus();
		Encheres e = new Encheres();
		
		c.setLibelle(rslt.getString("libelle"));
		c.setNoCategorie(rslt.getInt("no_categorie"));
		
		r.setCodePostal(rslt.getString("code_postal"));
		r.setNoRetrait(rslt.getInt("no_retrait"));
		r.setRue(rslt.getString("rue"));
		r.setVille(rslt.getString("ville"));
		
		a.setCategorie(c);
		a.setDebutEncheres(rslt.getDate("date_debut_encheres"));
		a.setDescription(rslt.getString("description"));
		a.setFinEncheres(rslt.getDate("date_fin_encheres"));
		a.setNoArticle(rslt.getInt("no_article"));
		a.setNomArticle(rslt.getString("nom_article"));
		a.setNoRetrait(r);
		a.setNoUtilisateur(rslt.getInt("no_utilisateur"));
		a.setPrixInitial(rslt.getInt("prix_initial"));
		a.setPrixVente(rslt.getInt("prix_vente"));
		
		e.setArticle(a);
		e.setDateEnchere(rslt.getDate("date_enchere"));
		e.setMontantEnchere(rslt.getInt("montant_enchere"));
		e.setNoUtilisateur(rslt.getInt(4));
		
		return e;
	}

	@Override
	public List<Encheres> selectEnCours() throws DALException {
		List<Encheres> listeEnCours = new ArrayList<Encheres>();
		
		
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement stm = con.prepareStatement(SELECT_EN_COURS);
				ResultSet rs = stm.executeQuery();)
		{
			while (rs.next()) 
			{
				listeEnCours.add(recupererEnchere(rs));
			}
		} catch (Exception e2) {
			throw new DALException("Impossible de voir les listes en cours !");
		}
		return listeEnCours;
	}
	
	@Override
	public List<Encheres> selectAll() throws DALException {
		List<Encheres> listeAll = new ArrayList<Encheres>();
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement stm = con.prepareStatement(SELECT_ALL);
				ResultSet rs = stm.executeQuery();)
		{
			while (rs.next()) 
			{
				listeAll.add(recupererEnchere(rs));
			}
		} catch (Exception e2) {
			throw new DALException("Impossible de voir les listes !");
		}
		return listeAll;
	}

	@Override
	public List<Encheres> selectByCategorie() throws DALException {
		List<Encheres> listeByCategorie = new ArrayList<Encheres>();
			ResultSet rs = null;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement stm = con.prepareStatement(SELECT_BY_CATEGORIE);)
		{
			rs = stm.executeQuery();
			while (rs.next())
			{
				listeByCategorie.add(recupererEnchere(rs));
			}
			
		} catch (Exception e) {
			throw new DALException("Impossible de voir les listes par catégorie !");
		}
		
		
		//peut pas mettre le rs dans le try 
		return listeByCategorie;
	}

	@Override
	public List<Encheres> selectByMotCle(String nomArticle) throws DALException {
		List<Encheres> listeByMotCle = new ArrayList<Encheres>();

		return listeByMotCle;
	}

	@Override
	public List<Categories> selectCategories() throws DALException {
		List<Categories> listeCategorie = new ArrayList<Categories>();
		return listeCategorie;
	}

	@Override
	public List<Encheres> selectByUser(int Utilisateurs) throws DALException {
		List<Encheres> listeByUser = new ArrayList<Encheres>();
		return listeByUser;
	}

	@Override
	public List<Encheres> selectEnchGagne(Categories c) throws DALException {
		List<Encheres> listeEnchereGagnee = new ArrayList<Encheres>();
		return listeEnchereGagnee;
	}

}