package fr.eni.projetenchere.dal;

import fr.eni.projetenchere.bo.Utilisateurs;

public interface UtilisateursDAO {

	Utilisateurs createUtilisateur(Utilisateurs u) throws DALException;
	Utilisateurs connectUtilisateur(String email, String motDePasse) throws DALException;
	Utilisateurs modifierUtilisateur(Utilisateurs u) throws DALException;
	boolean pseudoOuEmailDejaPris(String email, String pseudo) throws DALException;
	public boolean verifierCompte(int noUtilisateur, String motDePasse) throws DALException;
}
