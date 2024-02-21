package portale.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import portale.backend.User;
import portale.backend.UserRepository;

import java.io.IOException;
import java.lang.Exception;

/**
 * Servlet implementation class UpdatePassword
 */
public class UpdatePasswordServlet extends HttpServlet {
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
		if(old == null || newAuth == null || reconfAuth == null)
			return;
		else {
			if(old.equals(u.getPassword())) {
				if (newAuth.equals(reconfAuth) && !newAuth.equals(old)) {
					try {
						u.setPassword(newAuth);
						UserRepository.getInstance().update(u);
						response.sendRedirect("dettagli.jsp?update-auth=ok");						
					} catch (Exception sql) {
						throw new ServletException(sql);
					}
				} else if (!newAuth.equals(reconfAuth))
					response.sendRedirect("dettagli.jsp?update-auth=reconf");
				else
					response.sendRedirect("dettagli.jsp?update-auth=newAuth");
			} else
				response.sendRedirect("dettagli.jsp?update-auth=pass");			
		}
	}

}
