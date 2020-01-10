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

/**
 * Servlet implementation class ServletListesEncheresConnecter
 */
@WebServlet("/connecte")
public class ServletListesEncheresConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnchereManager enchereManager = new EnchereManager();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/listesencheresconnecter.jsp");
		try {
			List<Encheres> liste = enchereManager.recupererEnCours();
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