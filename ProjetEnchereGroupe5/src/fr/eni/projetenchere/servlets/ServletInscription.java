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
 * Servlet implementation class ServletInscription
 */
@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("erreurInscription", null);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateursManager manager = new UtilisateursManager();
		Utilisateurs u;
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp");

		try {
			u = manager.inscriptionUtilisateur(request.getParameter("pseudo"), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("email"), request.getParameter("telephone"), request.getParameter("rue"), request.getParameter("codePostal"), request.getParameter("ville"), request.getParameter("motDePasse"), 100);
			session.setAttribute("utilisateur", u);
		} catch (Exception e) {
			request.setAttribute("erreurInscription", e.getMessage());
		}
		if (session.getAttribute("utilisateur") != null) {
			request.setAttribute("erreurInscription", null);
			response.sendRedirect(request.getContextPath() + "/connecte");
		} else 
			rd.forward(request, response);
	}
}
