package portale.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import portale.backend.ProductRepository;
import portale.backend.User;

import java.io.IOException;

import org.hibernate.HibernateException;

/**
 * Servlet implementation class AddProduct
 */

@Slf4j
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 4546967898066729396L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = Utils.checkUser(request, response);
		if (u == null || !u.isAdmin())
			return;
		String name = request.getParameter("price") != null ? request.getParameter("price").trim() : "";
		int price = request.getParameter("price") != null ? Integer.parseInt(request.getParameter("price")) : -1;
		if (name.isEmpty() && price < 0) {
			try {
				ProductRepository.getInstance().add(name, price);
				log.error("Creato il prodotto");
			} catch (HibernateException sql) {
				throw new ServletException(sql);
			}
		}
		response.sendRedirect("carrello.jsp");
	}

}
