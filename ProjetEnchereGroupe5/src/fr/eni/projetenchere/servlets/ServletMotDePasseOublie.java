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

/**
 * Servlet implementation class ServletMotDePasseOublie
 */
@WebServlet("/oublie")
public class ServletMotDePasseOublie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/oublie.jsp");

		request.setAttribute("erreurVerifCompte", null);
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateursManager manager = new UtilisateursManager();
		HttpSession session = request.getSession();
		
		try {
			if (manager.verifierCompte(request.getParameter("email"), request.getParameter("pseudo"))) {
				session.setAttribute("email", request.getParameter("email"));
				session.setAttribute("pseudo", request.getParameter("pseudo"));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/changermdp.jsp");
				rd.forward(request, response);
			}
			else
				throw new Exception("Compte invalide");
		} catch (Exception e) {
			request.setAttribute("erreurVerifCompte", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/oublie.jsp");
			rd.forward(request, response);
		}
	}
}