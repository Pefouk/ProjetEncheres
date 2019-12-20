package fr.eni.projetenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetenchere.bo.Utilisateurs;
import fr.eni.projetenchere.dal.ConnectionProvider;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.UtilisateursDAO;

public class UtilisateursDAOJDBCIMPL implements UtilisateursDAO {

	private final String CONNEXION = "select * from Utilisateurs where (email=? OR pseudo=?) AND mot_de_passe =  convert(varchar(256),HASHBYTES('SHA2_256', ? ),2)";
	private final String INSCRIPTION = "INSERT Utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) values (? , ? , ? , ? , ? , ? , ? , ? , convert(varchar(256),HASHBYTES('SHA2_256', ? ),2) , ?, ?);";
	private final String GETHASHMDP = "select mot_de_passe from utilisateurs where no_utilisateur = ?";
	private final String UPDATEUSER = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = convert(nvarchar(256),HASHBYTES('SHA2_256', ? ), 2) WHERE no_utilisateur = ?";
	private final String UNIQUEUSER = "SELECT * FROM UTILISATEURS WHERE email = ? OR pseudo = ?";
	private final String VERIFICATIONMOTDEPASSE = "select * from Utilisateurs where no_utilisateur=? AND mot_de_passe =  convert(varchar(256),HASHBYTES('SHA2_256', ? ),2)";
	
	@Override
	public Utilisateurs createUtilisateur(Utilisateurs u) throws DALException {
		ResultSet rs = null;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement(INSCRIPTION, PreparedStatement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, u.getPseudo());
			ps.setString(2, u.getNom());
			ps.setString(3, u.getPrenom());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getTelephone());
			ps.setString(6, u.getRue());
			ps.setString(7, u.getCodePostal());
			ps.setString(8, u.getVille());
			ps.setString(9, u.getMotDePasse());
			ps.setInt(10, u.getCredit());
			ps.setBoolean(11, false);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			rs.next();
			u.setNoUtilisateur(rs.getInt(1));
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Erreur lors de la cr�ation de l'utilisateur : 1000");
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				throw new DALException("Erreur lors de la fermeture de du resultset : 1001");
			}
		}
		u.setMotDePasse(getHashMDP(u.getNoUtilisateur()));
		return (u);
	}

	@Override
	public Utilisateurs connectUtilisateur(String email, String motDePasse) throws DALException {
		ResultSet rs = null;
		Utilisateurs u = new Utilisateurs();

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement(CONNEXION)) {
			ps.setString(1, email);
			ps.setString(2, email);
			ps.setString(3, motDePasse);
			rs = ps.executeQuery();
			if (rs.next()) {
				u = recupererUtilisateur(rs);
			} else
				throw new DALException("Conection �chou�e, mot de passe ou email invalide");
		} catch (Exception e) {
			throw new DALException("Erreur lors de la connection : 40000");
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				throw new DALException("Erreur lors de la fermeture de du resultset : 4001");
			}
		}
		return u;
	}

	private Utilisateurs recupererUtilisateur(ResultSet rs) throws SQLException {
		Utilisateurs u = new Utilisateurs();

		u.setAdministrateur(rs.getBoolean("administrateur"));
		u.setCodePostal(rs.getString("code_postal"));
		u.setCredit(rs.getInt("credit"));
		u.setEmail(rs.getString("email"));
		u.setMotDePasse(rs.getString("mot_de_passe"));
		u.setNom(rs.getString("nom"));
		u.setNoUtilisateur(rs.getInt("no_utilisateur"));
		u.setPrenom(rs.getString("prenom"));
		u.setRue(rs.getString("rue"));
		u.setTelephone(rs.getString("telephone"));
		u.setVille(rs.getString("ville"));
		u.setPseudo(rs.getString("pseudo"));
		return u;
	}

	private String getHashMDP(int id) throws DALException {
		ResultSet rs = null;
		String res = null;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement(GETHASHMDP);) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				res = rs.getString("mot_de_passe");
			else
				throw new DALException("Pas de hash de mot de passe trouv� : 2002");
		} catch (Exception e) {
			throw new DALException("Erreur lors de la r�cuperation du hash de mot de passe : 2000");
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				throw new DALException("Erreur lors de la fermeture de du resultset : 2001");
			}
		}
		return (res);
	}

	@Override
	public Utilisateurs modifierUtilisateur(Utilisateurs u) throws DALException {
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement(UPDATEUSER)) {
			ps.setString(1, u.getPseudo());
			ps.setString(2, u.getNom());
			ps.setString(3, u.getPrenom());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getTelephone());
			ps.setString(6, u.getRue());
			ps.setString(7, u.getCodePostal());
			ps.setString(8, u.getVille());
			ps.setString(9, u.getMotDePasse());
			ps.setInt(10, u.getNoUtilisateur());
			int res = ps.executeUpdate();
			if (res != 1)
				throw new DALException("Erreur lors de la modification du profil : 3001");
		} catch (Exception e) {
			throw new DALException("Erreur lors de la modification du profil : 3000");
		}
		return u;
	}

	public boolean pseudoOuEmailDejaPris(String email, String pseudo) throws DALException {
		ResultSet rs = null;
		Boolean res = false;
		int i = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement(UNIQUEUSER)) {
			ps.setString(1, email);
			ps.setString(2, pseudo);
			rs = ps.executeQuery();
			for (;rs.next(); i++) {
				if (!email.equals(rs.getString("email")) && !pseudo.equals(rs.getString("pseudo")))
					res = true;
			}
			if (i > 1)
				res = true;
		} catch (Exception e) {
			throw new DALException("Erreur lors de la verification de l'unicité du compte : 5002");
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				throw new DALException("Erreur lors de la fermeture de du resultset : 5001");
			}
		}
		return (res);
	}
	
	public boolean verifierCompte(int noUtilisateur, String motDePasse) throws DALException {
		ResultSet rs = null;
		boolean res = false;
		
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement(VERIFICATIONMOTDEPASSE)) {
			ps.setInt(1, noUtilisateur);
			ps.setString(2, motDePasse);
			rs = ps.executeQuery();
			if (rs.next())
				res = true;
		} catch (Exception e) {
			throw new DALException("Mot de passe invalide !");
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				throw new DALException("Erreur lors de la fermeture de du resultset : 6001");
			}
		}
		return res;
	}
}