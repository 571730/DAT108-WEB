package no.hvl.dat108;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeltakerListeServlet
 */
@WebServlet("/deltakerliste")
public class DeltakerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private DeltakerEAO dEAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession();
		
		if(sesjon != null && request.getSession().getAttribute("loggedIn") != null) {
			List<Deltaker> liste = dEAO.hentDeltakere();
			Collections.sort(liste);
			sesjon.setAttribute("deltakere", liste);
			sesjon.setAttribute("aktiv", sesjon.getAttribute("loggedIn"));
			request.getRequestDispatcher("WEB-INF/deltakerliste.jsp")
			.forward(request, response);
		} else {
			response.sendRedirect("logginn?notLoggedIn");
		}
		
	}

}
