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
import fr.eni.projetenchere.bo.Encheres;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/AfficherMotCle")
public class ServletAfficherMotCle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			EnchereManager enchereManager = new EnchereManager();
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
			try {
				List<Encheres> listeMotCle = enchereManager.recupererMotCle("%"+request.getParameter("filtres")+"%");
				request.setAttribute("listeEnchere", listeMotCle);
				rd.forward(request, response);
				
			}catch (Exception e) {
				request.setAttribute("erreurListe", e.getMessage());
				rd.forward(request, response);
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}