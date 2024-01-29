package portale.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import portale.backend.User;

import java.io.IOException;

/**
 * Servlet implementation class UpdatePassword
 */
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = Utils.checkUser(request, response);
		if(u == null)
			return;
		String old = request.getParameter("old");
		String newAuth = request.getParameter("newAuth");
		String reconfAuth = request.getParameter("reconfAuth");
		if(old.equals(u.getPassword())) {
			if (newAuth.equals(reconfAuth) && !newAuth.equals(old))
				response.sendRedirect("dettagli.jsp?update-auth=ok");
			else if (!newAuth.equals(reconfAuth))
				response.sendRedirect("dettagli.jsp?err=reconf");
			else
				response.sendRedirect("dettagli.jsp?err=newAuth");
		}
		response.sendRedirect("dettagli.jsp");
	}

}
