package fr.eni.projetenchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetenchere.bll.EnchereManager;
import fr.eni.projetenchere.bo.Encheres;
import fr.eni.projetenchere.bo.Utilisateurs;

/**
 * Servlet implementation class ServletCreerEnchere
 */
@WebServlet("/CreerEnchere")
public class ServletCreerEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EnchereManager manager = new EnchereManager();
		HttpSession session = request.getSession();
		Utilisateurs u = (Utilisateurs) session.getAttribute("utilisateur");
		Encheres e = new Encheres();
		
		try {
			e = manager.createEncheres(u.getNoUtilisateur(), request.getParameter("article"),
					request.getParameter("description"), request.getParameter("categorie"),
					request.getParameter("miseaprix"), request.getParameter("findate"), request.getParameter("rue"),
					request.getParameter("codePostal"), request.getParameter("ville"));
			response.sendRedirect(request.getContextPath() + "/AfficherEnchere?noArticle=" + e.getArticle().getNoArticle());
		} catch (Exception e2) {
			request.setAttribute("erreurCreerEnchere", e2.getMessage());
			RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/jsp/vendrearticle.jsp");
			rd1.forward(request, response);
		}
	}

}
