package fr.eni.projetenchere.dal;

import fr.eni.projetenchere.dal.jdbc.UtilisateursDAOJDBCIMPL;

public abstract class DAOFactory {

	public static UtilisateursDAO getUtilisateursDAO() {
		return (new UtilisateursDAOJDBCIMPL());
	}
}
