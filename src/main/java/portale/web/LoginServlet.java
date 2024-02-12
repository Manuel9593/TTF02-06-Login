package portale.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import portale.backend.User;
import portale.backend.UserRepository;

import java.io.IOException;


import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class LoginServlet
 */
@Slf4j
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String l = request.getParameter("login");
		String p = request.getParameter("password");
		User u = UserRepository.getInstance().get(l, p);
//		if(request.getCookies() != null)
//			for(Cookie c : request.getCookies())
//				log.info(c.toString());
			
		if (u != null) {
			log.info("mi sto loggando come utente {}", 1);
			Utils.setUser(request, u);
			response.sendRedirect("./home.jsp?user="+u.getLogin());
		} else
			response.sendRedirect(".?err");
	}

}
