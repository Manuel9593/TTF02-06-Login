package portale.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import portale.backend.ProductRepository;

import java.io.IOException;

import org.hibernate.HibernateException;

/**
 * Servlet implementation class AddProductServlet
 */
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 386275587591705898L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Utils.checkUser(request, response)==null)
			return;
		int id = Integer.parseInt(request.getParameter("product"));
		int q = Integer.parseInt(request.getParameter("q"));
		try {
			Utils.getCart(request).add(ProductRepository.getInstance().get(id), q);
		} catch (HibernateException sql) {
			throw new ServletException(sql);
		}
		response.sendRedirect("carrello.jsp");
	}

}
