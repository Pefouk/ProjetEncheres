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
 * Servlet implementation class ServletChangerMdp
 */
@WebServlet("/changerMdp")
public class ServletChangerMdp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/changermdp.jsp");

		if (session.getAttribute("email") == null || session.getAttribute("pseudo") == null || session.getAttribute("utilisateur") == null)
			request.setAttribute("erreurChangeMdp", "Vous n'êtes pas connécté ou n'avez pas essayer de changer de mot de passe !");
		else
			request.setAttribute("erreurChangeMdp", null);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateursManager manager = new UtilisateursManager();
		HttpSession session = request.getSession();
		String email;
		Utilisateurs u = new Utilisateurs();
		RequestDispatcher rd;

		try {
			if (session.getAttribute("email") == null) {
				u = (Utilisateurs) session.getAttribute("utilisateur");
				email = u.getEmail();
			} else 
				email = (String) session.getAttribute("email");
			manager.changerMotDePasse(request.getParameter("motdepasse"), request.getParameter("motdepasseverif"), email);
			rd = request.getRequestDispatcher("/WEB-INF/jsp/mdpmodifie.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("erreurChangeMdp", e.getMessage());
			rd = request.getRequestDispatcher("/WEB-INF/jsp/changermdp.jsp");
			rd.forward(request, response);
		}
	}

}
