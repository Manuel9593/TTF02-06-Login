package portale.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import portale.web.Utils;

import java.io.IOException;

/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Utils.checkUser(request, response)==null)
			return;
		int id = Integer.parseInt(request.getParameter("product"));
		int q = Integer.parseInt(request.getParameter("q"));
		Utils.getCart(request).add(ProductRepository.getInstance().get(id), q);
		response.sendRedirect("carrello.jsp");
	}

}
