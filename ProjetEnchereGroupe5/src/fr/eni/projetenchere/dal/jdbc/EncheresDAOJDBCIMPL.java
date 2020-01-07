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

	private final String SELECT_ENCHERES = "SELECT * FROM ENCHERES";
	private final String SELECT_MOT_CLE = "SELECT * FROM ARTICLES_VENDUS where nom_article= ?";
	private final String SELECT_CATEGORIES = "SELECT * FROM CATEGORIES where";
	private final String INSERT_ENCHERES = "INSERT ENCHERES (no_article ,date_enchere, montant_enchere, no_utilisateur) values (?, GETDATE(), ?, ?)";
	private final String INSERT_ARTICLE = "INSERT ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, no_retrait) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String INSERT_RETRAIT = "INSERT RETRAITS (rue, code_postal, ville) values (?, ?, ?)";

	// INSERT CATEGORIES ( libelle) values ('trop bien')
	// SELECT * FROM RETRAITS
	// SELECT * FROM ARTICLES_VENDUS
	//
	// SELECT * FROM ARTICLES_VENDUS where nom_article= 'Fauteuil'
	// mettre arrayslist ici

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
			stm2.setDate(3, a.getDebutEncheres());
			stm2.setDate(4, a.getFinEncheres());
			stm2.setInt(5, a.getPrixInitial());
			stm2.setInt(6, a.getPrixVente());
			stm2.setInt(7, a.getNoUtilisateur());
			stm2.setInt(8, a.getCategorie().getNoCategorie());
			stm2.setInt(9, a.getRetrait().getNoRetrait());
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
				throw new DALException(
						"Erreur lors de la fermeture de la connexion, du resultset ou du preparedStatement");
			}
		}

		return e;
	}

	@Override
	public List<Encheres> selectAll(Encheres e) throws DALException {
		List<Encheres> listeRepas = new ArrayList<Encheres>();
		Connection con = null;
		PreparedStatement stm1 = null;
		ResultSet rslt = null;
		
		try {
			con = ConnectionProvider.getConnection();
			con.setAutoCommit(false);
			
		
			
		} catch (Exception e2) {

		}
		

		return null;
	}

	@Override
	public List<Encheres> selectByCategorie(Categories c) throws DALException {
		List<Encheres> listeRepas = new ArrayList<Encheres>();

		return null;
	}

	@Override
	public List<Encheres> selectByMotCle(String nomArticle) throws DALException {
		List<Encheres> listeRepas = new ArrayList<Encheres>();

		return null;
	}

	/**
	 * @{inheritDoc}
	 * @see fr.eni.projetenchere.dal.EncheresDAO#selectCategories()
	 */
	@Override
	public List<Categories> selectCategories() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @{inheritDoc}
	 * @see fr.eni.projetenchere.dal.EncheresDAO#selectByUser(int)
	 */
	@Override
	public List<Encheres> selectByUser(int Utilisateurs) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @{inheritDoc}
	 * @see fr.eni.projetenchere.dal.EncheresDAO#selectEnchGagne(fr.eni.projetenchere.bo.Categories)
	 */
	@Override
	public List<Encheres> selectEnchGagne(Categories c) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
