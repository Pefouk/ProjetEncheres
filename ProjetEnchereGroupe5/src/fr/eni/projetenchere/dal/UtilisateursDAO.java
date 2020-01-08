package fr.eni.projetenchere.dal;

import fr.eni.projetenchere.bo.Utilisateurs;

public interface UtilisateursDAO {

	Utilisateurs createUtilisateur(Utilisateurs u) throws DALException;
	Utilisateurs connectUtilisateur(String email, String motDePasse) throws DALException;
	Utilisateurs modifierUtilisateur(Utilisateurs u) throws DALException;
	Utilisateurs recupererVendeur(int noUtilisateur) throws DALException;
	boolean pseudoOuEmailDejaPris(String email, String pseudo) throws DALException;
	boolean verifierCompte(int noUtilisateur, String motDePasse) throws DALException;
	void supprimerCompte(int noUtilisateur) throws DALException;
	boolean motDePasseOublie(String email, String pseudo) throws DALException;
	void changerMotDePasse(String email, String mdp) throws DALException;
}
