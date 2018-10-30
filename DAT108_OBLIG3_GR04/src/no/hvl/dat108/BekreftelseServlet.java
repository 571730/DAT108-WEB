package no.hvl.dat108;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BekreftelseServlet
 */
@WebServlet("/bekreftelse")
public class BekreftelseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession();
		
		if(sesjon != null && request.getSession().getAttribute("loggedIn") != null) {
			request.getRequestDispatcher("WEB-INF/bekreftelse.jsp")
			.forward(request, response);
		} else {
			response.sendRedirect("logginn?notLoggedIn");
		}		
	}
}
