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
 * Servlet implementation class ServletConnection
 */
@WebServlet("/connexion")
public class ServletConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/connection.jsp");
		HttpSession session = request.getSession();

		session.setAttribute("erreurConnexion", null);
		if (session.getAttribute("utilisateur") != null)
			response.sendRedirect(request.getContextPath() + "/connecte");
		else 
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UtilisateursManager manager = new UtilisateursManager();
		Utilisateurs u = new Utilisateurs();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/connection.jsp");

		request.setAttribute("erreurConnexion", null);
		try {
			u = manager.connectionUtilisateur(request.getParameter("email"), request.getParameter("motDePasse"));
			if (u != null)
				session.setAttribute("utilisateur", u);
			else {
				session.setAttribute("erreurConnexion", "Echec de la connexion, login ou mot de passe invalide");
			}
		} catch (Exception e) {
			session.setAttribute("erreurConnexion", "Echec de la connexion, login ou mot de passe invalide");
		}
		if (session.getAttribute("utilisateur") != null) {
			request.setAttribute("erreurConnexion", null);
			response.sendRedirect(request.getContextPath() + "/connecte");
		}
		else
			rd.forward(request, response);
	}
}
