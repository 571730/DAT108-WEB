package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/registrering")
public class RegisteringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private DeltakerEAO dEAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/registrering.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Skjema skjema = new Skjema(request);
		
		//Sjekker om mobilnummer er tatt og alt annet er good med skjema
		if(!dEAO.finnesMobilnummer(skjema.getMobil()) && skjema.isAllInputGyldig()) {
			//Kan lage deltaker
			HttpSession sesjon = request.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}

			sesjon = request.getSession(true);
			//Henter tid til inactive fra init paramter i xml-fil
			//int tidInactive = Integer.parseInt(this.getInitParameter("Tid"));
			sesjon.setMaxInactiveInterval(1100);

			sesjon.setAttribute("loggedIn", skjema.getMobil());
			
			//Lager og legger til deltaker fra info i skjema
			//Trådsikker i synchronized
			Deltaker d = skjema.lagDeltaker();
			synchronized(d){
				dEAO.leggTilDeltaker(d);
			}
			
			
			//Setter passord til blank, slik at de trygt kan sendes med session
			skjema.gjemPassord();
			sesjon.setAttribute("skjema", skjema);

			response.sendRedirect("bekreftelse");
		}
		else {
			skjema.settOppFeilmeldinger();
			
			if(dEAO.finnesMobilnummer(skjema.getMobil())) {
				request.getSession().setAttribute("brukerTatt", "Dette mobilnummeret er allerede i bruk!");
				skjema.setMobil("");
			}
			
			request.getSession().setAttribute("skjema", skjema);
			response.sendRedirect("registrering");
		}
		
	}

}
