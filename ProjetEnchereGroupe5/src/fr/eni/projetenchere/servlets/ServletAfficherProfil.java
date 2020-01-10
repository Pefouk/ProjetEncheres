package fr.eni.projetenchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetenchere.bll.UtilisateursManager;
import fr.eni.projetenchere.bo.Utilisateurs;

/**
 * Servlet implementation class ServletAfficherProfil
 */
@WebServlet("/AfficherProfil")
public class ServletAfficherProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateursManager manager = new UtilisateursManager();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/afficherprofil.jsp");
		Utilisateurs u = new Utilisateurs();

		try {
			u = manager.recupererUtilisateur(Integer.valueOf(request.getParameter("noUtilisateur")));
			if (u != null)
				request.setAttribute("profil", u);
			else
				request.setAttribute("erreurAfficherProfil", "Profil inexistant");
		} catch (Exception e) {
			request.setAttribute("erreurAfficherProfil", e.getMessage());
		}
		rd.forward(request, response);
	}

}
