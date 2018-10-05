package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Innlogging
 */
@WebServlet(name="Innlogging", urlPatterns="/Innlogging")
public class Innlogging extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Innlogging</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"jumbotron\" style=\"width:30%; margin-left:auto; margin-right:auto\">");
		if(request.getParameter("feil") != null ) {
			out.println("<p style=\"color:red\">Feil passord, prøv igjen!</p>");
		} else if (request.getParameter("notLoggedIn") != null) {
			out.println("<p style=\"color:red\">Du var ikke logget inn!</p>");
		}
		out.println("<h3>Innlogging</h3>");
		out.println("<form name=\"loginForm\" action=\"Innlogging\" method=\"post\">");
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"passord\">Passord</label>");
		out.println("<input type=\"password\" class=\"form-control\" name=\"passord\" placeholder=\"Skriv passord..\"><br><br>\r\n" 
				+ "<button type=\"submit\" class=\"btn btn-primary\">Logg inn</button>");
		out.println("</div>");
		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String innPass = request.getParameter("passord");
		String riktigPass = this.getInitParameter("Passord");
		if(innPass.equals(riktigPass)) {
			HttpSession sesjon = request.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}

			sesjon = request.getSession(true);
			//Henter tid til inactive fra init paramter i xml-fil
			int tidInactive = Integer.parseInt(this.getInitParameter("Tid"));
			sesjon.setMaxInactiveInterval(tidInactive);

			sesjon.setAttribute("loggedIn", "yes");
			// Inn noe kode her i forbindelse med oppretting av sesjonsdata?
			sesjon.setAttribute("handleliste", new HandlelisteObjekt());
			response.sendRedirect("Handleliste");
		} else {
			response.sendRedirect("Innlogging" + "?feil='ja'");
		}
	}

}
