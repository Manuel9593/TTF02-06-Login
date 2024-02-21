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
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = Utils.checkUser(request, response);
		if(u == null)
			return;
		String nameParam = request.getParameter("name");
		String surnameParam = request.getParameter("surname");
		if (nameParam != null && surnameParam != null) {
			if(!nameParam.trim().isEmpty() && !surnameParam.trim().isEmpty()) {
				u.setName(nameParam);
				u.setSurname(surnameParam);
				try {
					UserRepository.getInstance().update(u);
				} catch (Exception e) {
					throw new ServletException(e);
				}
				response.sendRedirect("dettagli.jsp?update-user=ok");
			} else if (nameParam.trim().isEmpty())
				response.sendRedirect("dettagli.jsp?update-user=name");
			else
				response.sendRedirect("dettagli.jsp?update-user=surname");
		} else if (nameParam == null)
			response.sendRedirect("dettagli.jsp?update-user=name");
		else
			response.sendRedirect("dettagli.jsp?update-user=surname");
		
	}

}
