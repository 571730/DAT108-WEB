package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Servlet implementation class Handleliste
 */
@WebServlet("/Handleliste")
public class Handleliste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjon = request.getSession();

		if (sesjon != null && request.getSession().getAttribute("loggedIn") != null) {
			HandlelisteObjekt liste = (HandlelisteObjekt) request.getSession().getAttribute("handleliste");

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
			out.println("<div class=\"container\">");
			out.println("<h3>Handleliste</h3>");
			out.println("<form action=\"Handleliste\" method=\"post\" class=\"form-inline\" style=\"width:100%\">");
			out.println("<input type=\"text\" class=\"form-control mb-2 mr-sm-2\" name=\"leggTilVare\""
					+ " placeholder=\"Legg til vare..\">");
			out.println("<button type=\"submit\" class=\"btn btn-primary mb-2\">Legg Til</button>");
			out.println("</form>");
			out.println("<ul class=\"list-group\" style=\"width:100%\">");
			if (liste.getHandlelisteObjekt().isEmpty()) {
				out.println("<br><h5>Handlelisten er tom</h5>");
			} else {
				for (String item : liste.getHandlelisteObjekt()) {
					out.println("<form action=\"Handleliste\" method=\"post\">"
							+ "<input class=\"form-control\" type=\"hidden\" name=\"slettLi\" value=" + item +">"
							+ "<li class=\"list-group-item\">" + item + "<span class=\"float-right button-group\">"
							+ "<button type=\"submit\" class=\"btn btn-danger form-control\"><span class=\"glyphicon glyphicon-remove\"></span>Slett</button>"
							+ "</li></form>");
				}
			}
			out.println("</ul>");
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		} else {
			response.sendRedirect("Innlogging" + "?notLoggedIn");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Passer paa at det ikke er html code
		String nyVare = StringEscapeUtils.escapeHtml(request.getParameter("leggTilVare"));
		//Fjerner mellomrom
		if(nyVare != null) {
			nyVare = nyVare.trim();
		}
		
		//Sjekker om bruker har session
		HttpSession sesjon = request.getSession(false);
		if (sesjon == null || sesjon.getAttribute("loggedIn") == null) {
			response.sendRedirect("Innlogging" + "?notLoggedIn");
		} else {
			//Bruker har godkjent session
			
			HandlelisteObjekt liste = (HandlelisteObjekt) sesjon.getAttribute("handleliste");
			
			//Sjekker om det skal legges til eller slettes vare
			if(request.getParameter("slettLi") == null) {
				if (nyVare != null && !nyVare.isEmpty() && liste != null) {
					liste.leggTil(nyVare);
				}
			} else { //Sletter om den ikke skal legge til
				if(!liste.getHandlelisteObjekt().isEmpty()) {
					String slettes = request.getParameter("slettLi");
					synchronized(liste){
						liste.fjernItem(slettes);
					}
					
				}
			}
			

			response.sendRedirect("Handleliste");
		}
	}

}
