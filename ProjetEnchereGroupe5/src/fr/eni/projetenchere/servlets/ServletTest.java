package fr.eni.projetenchere.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetenchere.bll.EnchereManager;
import fr.eni.projetenchere.bll.UtilisateursManager;
import fr.eni.projetenchere.bo.Encheres;
import fr.eni.projetenchere.bo.Utilisateurs;
import fr.eni.projetenchere.dal.EncheresDAO;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			EnchereManager bonjour = new EnchereManager();
			UtilisateursManager oui = new UtilisateursManager();
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
			try {
				List<Encheres> liste = bonjour.recupererMotCle("nomArticle");
				for (Encheres encheres : liste) {
					
					System.out.println(encheres);
				}
				request.setAttribute("listeEnchere", liste);
				rd.forward(request, response);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
