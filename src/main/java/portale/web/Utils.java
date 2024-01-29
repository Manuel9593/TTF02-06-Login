package portale.web;

import java.io.IOException;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import portale.backend.User;

public class Utils {
	public static Cookie getCookie(HttpServletRequest request, User u) {
		for (Cookie c : request.getCookies())
			if(c.getName().equals("utente"))
				return c;
		return null;
	}
	
	public static User checkUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User u = (User) request.getSession().getAttribute("utente");
		if (u == null)
			response.sendRedirect(".?err");
		return u;
	}
	
	public static void setUser(HttpServletRequest request, User u) {
		request.getSession().setAttribute("utente", u);
	}
}