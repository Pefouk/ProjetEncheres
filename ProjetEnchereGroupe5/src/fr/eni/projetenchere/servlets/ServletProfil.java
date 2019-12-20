package fr.eni.projetenchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bll.UtilisateursManager;
import fr.eni.projetenchere.bo.Utilisateurs;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.DAOFactory;
import fr.eni.projetenchere.dal.UtilisateursDAO;

/**
 * Servlet implementation class ServletProfil
 */
@WebServlet("/Profil")
public class ServletProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/profil.jsp");
		
		session.setAttribute("erreurModif", null);
		if (session.getAttribute("utilisateur") == null)
			response.sendRedirect(request.getContextPath() + "/connexion");
		else
			rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UtilisateursManager manager = new UtilisateursManager();
		Utilisateurs u = (Utilisateurs) session.getAttribute("utilisateur");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/profil.jsp");
		RequestDispatcher rdNoError = request.getRequestDispatcher("WEB-INF/jsp/modifierProfil.jsp");

		session.setAttribute("erreurModif", null);
		try {
			u = manager.modifierUtilisateur(u.getNoUtilisateur(), request.getParameter("pseudo"),
					request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("email"),
					request.getParameter("telephone"), request.getParameter("rue"), request.getParameter("codePostal"),
					request.getParameter("ville"), request.getParameter("newMotDePasse"),
					request.getParameter("confirmMotDePasse"), u.getCredit(), u.getAdministrateur(),
					request.getParameter("motDePasse"));
			session.setAttribute("utilisateur", u);
		} catch (Exception e) {
			session.setAttribute("erreurModif", e.getMessage());
		}
		
		if (session.getAttribute("utilisateur") == null)
			response.sendRedirect(request.getContextPath() + "/connexion");
		else if (session.getAttribute("erreurModif") == null)
			rd.forward(request, response);
		else {
			rdNoError.forward(request, response);
		}
	}
}