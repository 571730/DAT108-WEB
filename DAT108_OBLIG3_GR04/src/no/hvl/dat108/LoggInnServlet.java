package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoggInnServlet
 */
@WebServlet("/logginn")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private DeltakerEAO dEAO;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("notLoggedIn") != null) {
			request.getSession().setAttribute("notLoggedIn", "Det er kun registrerte deltagere som får se deltagerlisten.");
		}
		request.getRequestDispatcher("WEB-INF/logginn.jsp")
		.forward(request, response);
	}
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoggInnSkjema skjemaLogg = new LoggInnSkjema(request);
		
		if(skjemaLogg.sjekkInnlogging(dEAO)) {
			HttpSession sesjon = request.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}

			sesjon = request.getSession(true);
			
			sesjon.setMaxInactiveInterval(1000);
			sesjon.setAttribute("loggedIn", skjemaLogg.getMobil());
			response.sendRedirect("deltakerliste");
		}
		else {
			skjemaLogg.feilMelding();
			request.getSession().setAttribute("skjemaLogg", skjemaLogg);
			response.sendRedirect("logginn");
		}
		
	}

}
