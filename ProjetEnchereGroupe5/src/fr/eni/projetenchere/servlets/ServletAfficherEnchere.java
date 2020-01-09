package fr.eni.projetenchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetenchere.bll.EnchereManager;

/**
 * Servlet implementation class ServletAfficherEnchere
 */
@WebServlet("/AfficherEnchere")
public class ServletAfficherEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailsenchere.jsp");
		EnchereManager manager = new EnchereManager();

		if (request.getAttribute("enchere") == null) {
			try {
				request.setAttribute("enchere", manager.recupererenchere(Integer.valueOf(request.getParameter("noArticle"))));
			} catch (Exception e2) {
				request.setAttribute("erreurRecupererEnchere", e2.getMessage());
			}
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
