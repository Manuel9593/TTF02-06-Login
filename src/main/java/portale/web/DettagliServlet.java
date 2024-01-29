package portale.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import portale.backend.User;
import portale.backend.UserRepository;

import java.io.IOException;

/**
 * Servlet implementation class DettagliServlet
 */

public class DettagliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    private String print(User u) {
    	String s = "<html>"
    			+ "		<head>"
    			+ "			<title>Dettagli "+u.getLogin()+"</title>"
    			+ "		</head>"
    			+ "		<body>"
    			+ "			<div>%s</div>"
    			+ "			<div><a href=\"./login?user="+u.getLogin()+"\">Home</div>"
    			+ "			<div><a href=\".\">logout</div>"
    			+ "		</body>"
    			+ "</html";
    	return s.formatted("Pagina di dettagli per l'utente"+u.getFullName());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = UserRepository.getInstance().get(request.getParameter("user"));
		if (u != null) response.getWriter().println(print(u));
		else {
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies)
				if(c.getName().equals("login"))
					c.setMaxAge(-1);
			response.sendRedirect(".?err");
		}
	}

}
