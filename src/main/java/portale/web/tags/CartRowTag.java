package portale.web.tags;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import portale.backend.Cart;
import portale.backend.Product;

@Data
@EqualsAndHashCode(callSuper=false)
public class CartRowTag extends TagSupport{
	private static final long serialVersionUID = -8220166652999186215L;
	private String remove;
	private Product product;
	private void print(String msg) throws JspException {
		try {
			pageContext.getOut().println(msg);
		} catch (IOException e) {
			throw new JspException(e);
		}
	}
	
	@Override
	public int doStartTag() throws JspException {
		Cart cart = (Cart) pageContext.getAttribute("cart-view");
		print("							<tr>\r\n"
			+ "								<td><c:out value="+ product.getName() +"></c:out></td>\r\n"
			+ "								<td><c:out value="+ product.getPrice() +"></c:out></td>\r\n"
			+ "								<td><c:out value="+ cart.getQuantity(product) +"></c:out></td>\r\n"
			+ "								<td><c:out value="+ cart.getQuantity(product)*product.getPrice() +" €></c:out></td>\r\n"
			+ "								<td>\r\n"
			+ "									<a\r\n"
			+ "										href=\""+ remove + product.getId() +"\"\r\n"
			+ "										class=\"btn btn-danger\"\r\n"
			+ "										role=\"button\"\r\n"
			+ "									>\r\n"
			+ "										Rimuovi\r\n"
			+ "									</a>\r\n"
			+ "								</td>\r\n"
			+ "							</tr>");
		return SKIP_BODY;
	}
}
