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
		
		if (pseudo == null || nom == null || prenom == null || email == null || telephone == null || rue == null || codePostal == null || ville == null || motDePasse == null)
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
			throw new BLLException("Numero de t�l�phone invalide ! il doit contenir que des chiffres ! 0008");
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
		if (codePostal.length() > 5)
			throw new BLLException("Code postal invalide ! 0015");
		if (ville.length() > 30)
			throw new BLLException("Nom de ville trop grand ! 0016");
		try {
			if (this.dao.pseudoOuEmailDejaPris(email, pseudo))
				throw new BLLException("Pseudo ou email d�ja utilis� !");
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
		Utilisateurs u = new Utilisateurs(pseudo, nom, email, telephone, rue, codePostal, ville, motDePasse, credit, false, prenom);
		try {
			u = this.dao.createUtilisateur(u);
		} catch (DALException e) {
			throw new BLLException(e);
		}
		return u;
	}
	
	
	public Utilisateurs modifierUtilisateur (String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) throws BLLException {
		
		if (pseudo == null || nom == null || prenom == null || email == null || telephone == null || rue == null || codePostal == null || ville == null || motDePasse == null)
			throw new BLLException("Un des champs est vide ! 0010");
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
			throw new BLLException("Numero de t�l�phone invalide ! il doit contenir que des chiffres ! 0008");
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
		if (codePostal.length() > 5)
			throw new BLLException("Code postal invalide ! 0015");
		if (ville.length() > 30)
			throw new BLLException("Nom de ville trop grand ! 0016");
		try {
			if (this.dao.pseudoOuEmailDejaPris(email, pseudo))
				throw new BLLException("Pseudo ou email d�ja utilis� !");
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
		Utilisateurs u = new Utilisateurs(pseudo, nom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur, prenom);
		try {
			u = this.dao.createUtilisateur(u);
		} catch (DALException e) {
			throw new BLLException(e);
		}
		return u; 
	}
}