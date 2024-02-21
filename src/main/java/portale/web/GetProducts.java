package portale.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import portale.backend.Product;
import portale.backend.ProductRepository;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetProducts
 */

public class GetProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Product> res = ProductRepository.getInstance().getProducts();
			response.getWriter().print(new Gson().toJson(res));
		} catch (HibernateException ex) {
			throw new ServletException(ex);
		}
	}
}
