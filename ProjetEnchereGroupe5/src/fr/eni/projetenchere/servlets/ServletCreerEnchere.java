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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EnchereManager manager = new EnchereManager();
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailsEnchere.jsp");
		Utilisateurs u = (Utilisateurs) session.getAttribute("utilisateur");
		Encheres e = new Encheres();

		System.out.println(e.getNoUtilisateur());
		try {
			e = manager.createEncheres(2, request.getParameter("article"),
					request.getParameter("description"), "2",
					request.getParameter("miseaprix"), request.getParameter("findate"), request.getParameter("rue"),
					request.getParameter("codePostal"), request.getParameter("ville"));
			request.setAttribute("enchere", e);
		} catch (Exception e2) {
			e2.printStackTrace();
			request.setAttribute("erreurCreerEnchere", e2.getMessage());
			RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/jsp/vendrearticle.jsp");
			rd1.forward(request, response);
		}
		rd.forward(request, response);
	}

}
