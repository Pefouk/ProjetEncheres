package fr.eni.projetenchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetenchere.bll.UtilisateursManager;
import fr.eni.projetenchere.bo.Utilisateurs;

/**
 * Servlet implementation class ServletSuppressionCompte
 */
@WebServlet("/supprimercompte")
public class ServletSuppressionCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/supprimerprofil.jsp");
		HttpSession session = request.getSession();

		if (session.getAttribute("utilisateur") == null)
			response.sendRedirect(request.getContextPath() + "/connexion");
		else {
			request.getSession().setAttribute("erreurSupp", null);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UtilisateursManager manager = new UtilisateursManager();
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/supprimerprofil.jsp");

		if (session.getAttribute("utilisateur") == null)
			response.sendRedirect(request.getContextPath() + "/connexion");
		session.setAttribute("erreurSupp", null);
		try {
			manager.supprimerUtilisateur((Utilisateurs) session.getAttribute("utilisateur"), request.getParameter("motDePasse"));
			session.setAttribute("utilisateur", null);
		} catch (Exception e) {
			session.setAttribute("erreurSupp", e.getMessage());
		}
		if (session.getAttribute("erreurSupp") != null)
			rd.forward(request, response);
		else {
			response.sendRedirect(request.getContextPath() + "/");
		}
	}
}
