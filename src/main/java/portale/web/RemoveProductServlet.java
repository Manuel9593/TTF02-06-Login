package portale.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import portale.backend.ProductRepository;

import java.io.IOException;

import org.hibernate.HibernateException;

/**
 * Servlet implementation class RemoveProductServlet
 */

@Slf4j
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Utils.checkUser(request, response) == null)
			return;
		int id = request.getParameter("price") != null ? Integer.parseInt(request.getParameter("id")) : -1;
		if (id >= 0) {
			try {
				ProductRepository repo = ProductRepository.getInstance();
				repo.remove(repo.get(id));
				log.info("Prodotto rimosso {}", id);
			} catch (HibernateException ex) {
				throw new ServletException(ex);
			}
		}
		response.sendRedirect("products.jsp");
	}

}
