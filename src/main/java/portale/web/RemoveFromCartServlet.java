package portale.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import portale.backend.ProductRepository;

import java.io.IOException;

import org.hibernate.HibernateException;

/**
 * Servlet implementation class RemoveProductServlet
 */
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Utils.checkUser(request, response)==null)
			return;
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Utils.getCart(request).remove(ProductRepository.getInstance().get(id));
		} catch (HibernateException e) {
			throw new ServletException(e);
		}
		response.sendRedirect("carrello.jsp");
	}

}
