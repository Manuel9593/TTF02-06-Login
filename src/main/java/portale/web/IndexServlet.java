package portale.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Servlet implementation class IndexServlet
 */
@Slf4j
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String err = request.getParameter("err");
		String html = "<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "		<meta charset=\"ISO-8859-1\">\r\n"
				+ "		<title>Portale admins</title>\r\n"
				+ "		<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "		<div class=\"d-flex flex-column h-100 justify-content-strech align-content-center\">\r\n"
				+ "			<form action=\"login\" method=\"post\">\r\n"
				+ "				<div class=\"m-1\">"
				+ "					<label for=\"login\" class=\"form-label\">Nome utente</label>"
				+ "					<input type=\"text\" id=\"login\" class=\"form-control\" name=\"login\" required>"
				+ "				</div>\r\n"
				+ "				<div class=\"m-1\">"
				+ "					<label for=\"password\" class=\"form-label\">Password</label>"
				+ "					<input type=\"password\" id=\"login\" class=\"form-control\" name=\"password\" required></div>\r\n"
				+ "				<div class=\"m-1\">"
				+ "				<input type=\"submit\" class=\"btn btn-primary m-1\" name=\"submit\" value=\"Login\"></div>\r\n"
				+ "			</form>\r\n"
				+ "		<div>"+(err!=null ? "ERRORE" : "")+"<div>"
				+ "	</div>\r\n"
				+ "	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		response.getWriter().append(html);
	}
}
