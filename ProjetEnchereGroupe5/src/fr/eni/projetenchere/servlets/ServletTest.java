package fr.eni.projetenchere.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetenchere.bo.ArticlesVendus;
import fr.eni.projetenchere.bo.Categories;
import fr.eni.projetenchere.bo.Encheres;
import fr.eni.projetenchere.bo.Retraits;
import fr.eni.projetenchere.dal.DAOFactory;
import fr.eni.projetenchere.dal.EncheresDAO;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EncheresDAO dao = DAOFactory.getEncheresDAO();
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		Encheres e = new Encheres(date, 250, 1);
		ArticlesVendus a = new ArticlesVendus("Fauteuil", "Neuf 3 places", date, date, 150, 150, 1);
		Retraits r = new Retraits("Rue de la pinterie", "35000", "Rennes");
		Categories c = new Categories(2, "Ameublement");
		a.setCategorie(c);
		a.setNoRetrait(r);
		e.setArticle(a);
		try {
			e = dao.createEnchere(r, a, e, c);
			System.out.println(e.toString());
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
