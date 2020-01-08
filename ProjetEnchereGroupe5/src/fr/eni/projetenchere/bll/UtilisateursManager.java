package fr.eni.projetenchere.bll;

import fr.eni.projetenchere.bo.Utilisateurs;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.DAOFactory;
import fr.eni.projetenchere.dal.UtilisateursDAO;

public class UtilisateursManager {
	private UtilisateursDAO dao;

	public UtilisateursManager() {
		this.dao = DAOFactory.getUtilisateursDAO();
	}

	public Utilisateurs connectionUtilisateur(String email, String motDePasse) throws BLLException {
		Utilisateurs u = new Utilisateurs();
		if (email == null || motDePasse == null)
			throw new BLLException("Un des champs est vide ! 0101");
		if (motDePasse.length() < 6)
			throw new BLLException("Le mot de passe doit contenir au moins 6 caracteres ! 0103");
		if (motDePasse.length() > 255)
			throw new BLLException("Le mot de passe est trop long ! 0105");
		if (email.length() > 50)
			throw new BLLException("L'email est trop long ! 0106");
		try {
			u = this.dao.connectUtilisateur(email, motDePasse);
		} catch (Exception e) {
			throw new BLLException(e);
		}
		return u;
	}

	public Utilisateurs inscriptionUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit) throws BLLException {

		if (pseudo == null || nom == null || prenom == null || email == null || telephone == null || rue == null
				|| codePostal == null || ville == null || motDePasse == null)
			throw new BLLException("Un des champs est vide ! 0001");
		if (credit < 0)
			throw new BLLException("Les credits ne peuvent pas �tre n�gatifs ! 0002");
		if (motDePasse.length() < 6)
			throw new BLLException("Le mot de passe doit contenir au moins 6 caracteres ! 0003");
		if (!(email.contains("@")) || !(email.contains(".")))
			throw new BLLException("Email invalide ! 0004");
		if (telephone.length() != 10)
			throw new BLLException("Telephone invalide ! 0005");
		if (codePostal.length() != 5)
			throw new BLLException("Code postal invalide ! 0006");
		try {
			Integer.getInteger(codePostal);
		} catch (Exception e) {
			throw new BLLException("Code postal invalide ! Il ne doit contenir que des chiffres ! 0007");
		}
		try {
			Long.getLong(telephone);
		} catch (Exception e) {
			throw new BLLException("Numero de téléphone invalide ! il doit contenir que des chiffres ! 0008");
		}
		if (pseudo.length() > 30)
			throw new BLLException("Pseudo trop long ! 0009");
		if (nom.length() > 30)
			throw new BLLException("Nom trop long ! 0010");
		if (prenom.length() > 30)
			throw new BLLException("Prenom trop long ! 0011");
		if (email.length() > 50)
			throw new BLLException("Email trop long ! 0012");
		if (telephone.length() > 15)
			throw new BLLException("Telephone trop long ! 0013");
		if (rue.length() > 30)
			throw new BLLException("Rue trop longue ! 0014");
		if (ville.length() > 30)
			throw new BLLException("Nom de ville trop grand ! 0016");
		try {
			if (this.dao.pseudoOuEmailDejaPris(email, pseudo))
				throw new BLLException("Pseudo ou email d�ja utilis� !");
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
		Utilisateurs u = new Utilisateurs(pseudo, nom, email, telephone, rue, codePostal, ville, motDePasse, credit,
				false, prenom);
		try {
			u = this.dao.createUtilisateur(u);
		} catch (DALException e) {
			throw new BLLException(e);
		}
		return u;
	}

	public Utilisateurs modifierUtilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email,
			String telephone, String rue, String codePostal, String ville, int credit, boolean administrateur,
			String motDePasse) throws BLLException {

		if (pseudo == null || nom == null || prenom == null || email == null || telephone == null || rue == null
				|| codePostal == null || ville == null || motDePasse == null)
			throw new BLLException("Un des champs est vide ! 0010");
		if (!(email.contains("@")) || !(email.contains(".")))
			throw new BLLException("Email invalide ! 0004");
		if (telephone.length() != 10)
			throw new BLLException("Telephone invalide ! 0005");
		if (codePostal.length() != 5)
			throw new BLLException("Code postal invalide ! 0006");
		try {
			Integer.getInteger(codePostal);
		} catch (Exception e) {
			throw new BLLException("Code postal invalide ! Il ne doit contenir que des chiffres ! 0007");
		}
		try {
			Long.getLong(telephone);
		} catch (Exception e) {
			throw new BLLException("Numero de téléphone invalide ! il doit contenir que des chiffres ! 0008");
		}
		if (pseudo.length() > 30)
			throw new BLLException("Pseudo trop long ! 0019");
		if (nom.length() > 30)
			throw new BLLException("Nom trop long ! 0110");
		if (prenom.length() > 30)
			throw new BLLException("Prenom trop long ! 0111");
		if (email.length() > 50)
			throw new BLLException("Email trop long ! 0112");
		if (telephone.length() > 15)
			throw new BLLException("Telephone trop long ! 0113");
		if (rue.length() > 30)
			throw new BLLException("Rue trop longue ! 0114");
		if (codePostal.length() > 5)
			throw new BLLException("Code postal invalide ! 0115");
		if (ville.length() > 30)
			throw new BLLException("Nom de ville trop grand ! 0116");
		try {
			if (this.dao.pseudoOuEmailDejaPris(email, pseudo))
				throw new BLLException("Pseudo ou email déja utilisé !");
			if (!this.dao.verifierCompte(noUtilisateur, motDePasse))
				throw new BLLException("Mot de passe invalide !");
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
		Utilisateurs u = new Utilisateurs(noUtilisateur, pseudo, nom, email, telephone, rue, codePostal, ville,
				motDePasse, credit, administrateur, prenom);
		try {
			u = this.dao.modifierUtilisateur(u);
		} catch (DALException e) {
			throw new BLLException(e);
		}
		return u;
	}

	public void supprimerUtilisateur(Utilisateurs u, String motDePasse) throws BLLException {
		try {
			if (!this.dao.verifierCompte(u.getNoUtilisateur(), motDePasse))
				throw new BLLException("Mot de passe incorect !");
			this.dao.supprimerCompte(u.getNoUtilisateur());
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}

	public boolean verifierCompte(String email, String pseudo) throws BLLException {
		if (email == null || pseudo == null)
			throw new BLLException("Un des champs est vide !");
		if (!(email.contains("@")) || !(email.contains(".")))
			throw new BLLException("Email invalide !");
		if (email.length() > 50)
			throw new BLLException("Email trop longue !");
		try {
			if (this.dao.motDePasseOublie(email, pseudo))
				return (true);
			else
				return (false);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}

	public void changerMotDePasse(String mdp, String mdpv, String email) throws BLLException {
		if (mdp.length() < 6)
			throw new BLLException("Le mot de passe doit contenir au moins 6 caracteres !");
		if (mdp.length() > 255)
			throw new BLLException("Le mot de passe est trop long !");
		if (!mdp.equals(mdpv))
			throw new BLLException("Les mots de passe ne correspondent pas !");
		try {
			this.dao.changerMotDePasse(email, mdp);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}
	
	public Utilisateurs recupererUtilisateur(int noUtilisateur) throws BLLException {
		Utilisateurs u = new Utilisateurs();
		
		if (noUtilisateur <= 0)
			throw new BLLException("Le numéro utilisateur ne peut pas être negatif !");
		try {
			u = this.dao.recupererVendeur(noUtilisateur);
			u.setMotDePasse(null);
			u.setCredit(0);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
		return u;
	}
}