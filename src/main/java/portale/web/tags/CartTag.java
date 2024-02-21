package portale.web.tags;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import portale.backend.Cart;
import portale.backend.User;

@Data
@EqualsAndHashCode(callSuper=false)
public class CartTag extends TagSupport {
	private static final long serialVersionUID = 2834967346098310333L;
	private String add, product;
	private Cart cart;
	private User user;
	private int index = 0;
	
	private void print(String msg) throws JspException {
		try {
			pageContext.getOut().println(msg);
		} catch (IOException e) {
			throw new JspException(e);
		}
	}
	
	private void setProduct() {
		if (index < cart.getProducts().size())
			pageContext.setAttribute(product, cart.getProducts().get(index));
	}
	
	@Override
	public int doStartTag() throws JspException {
		index = 0;
		pageContext.setAttribute("cart-view", cart);
		print("			<div class=\"h1\">CARRELLO PER "+user.getFullName()+"</div>\r\n"
			+ "				<table class=\"table table-primary table-striped align-middle\">\r\n"
			+ "					<thead>\r\n"
			+ "						<tr>\r\n"
			+ "							<th scope=\"col\">PRODOTTO</th>\r\n"
			+ "							<th scope=\"col\">PREZZO UNTIARIO</th>\r\n"
			+ "							<th scope=\"col\">QTY</th>\r\n"
			+ "							<th scope=\"col\">TOT</th>\r\n"
			+ "							<th></th>\r\n"
			+ "						</tr>\r\n"
			+ "					</thead>\r\n"
			+ "					<tbody>");
		setProduct();
		return cart.getProducts().isEmpty() ? SKIP_BODY : EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		index++;
		setProduct();
		return cart.getProducts().size() > index ? EVAL_BODY_AGAIN : SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		print("						<tr><td colspan=\"3\"></td><td>"+cart.getTotal()+"</td></tr>"
			+ "					</tbody>"
			+ "				</table>\r\n"
			+ "				<a href=\""+ add +"\">ADD</a>");
		return EVAL_PAGE;
	
	}
}
