package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConverterServlet
 */
@WebServlet("/convert")
public class ConverterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sTemp = request.getParameter("temp");
		String cToF = request.getParameter("cToF");
		String resultat = "";
		
		String fToC = request.getParameter("fToC");
		Boolean okInput = true;
		//Sjekker om input er riktig
		if(sTemp == null)
			okInput = false;
		
		
		double iTemp = Double.parseDouble(sTemp);
		if(cToF.equals("on")) {
			double tempInFar = iTemp * 9/5 + 32;
			resultat = String.format("%.1f &#8457 = %.1f &#8451", tempInFar, iTemp);
		} else if (fToC.equals("on")) {
			double tempInCel = (iTemp - 32) * (5/9);
			resultat = String.format("%.1f &#8451 = %.1f &#8457", tempInCel, iTemp);
		} else {
			resultat = "Du valgte ingen konvertering!!!";
		}
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Lab1_Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Temperaturomregnings resultat</h1>");
		out.println("<h1>" + resultat + "</h1>");
		out.println("<a href=\"index.html\">En gang til</a>");
		out.println("</body>");
		out.println("</html>");
		doGet(request, response);
	}

}
