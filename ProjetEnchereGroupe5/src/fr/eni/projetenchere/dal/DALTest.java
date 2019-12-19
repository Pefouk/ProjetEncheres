package fr.eni.projetenchere.dal;

import fr.eni.projetenchere.bo.Utilisateurs;

public class DALTest {

	public static void main(String[] args) {
		UtilisateursDAO dao = DAOFactory.getUtilisateursDAO();
		Utilisateurs u = new Utilisateurs("BobBG", "Bob", "bob@orange.fr", "0637279880", "25 rue du bob", "3717", "Nantes", "XD", 0, false, "Eudes");
		
		try {
			u = dao.createUtilisateur(u);
			System.out.println(u.getMotDePasse());
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
}
