package portale.web;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;
import portale.backend.User;

public class CheckUserTag extends TagSupport {
	private static final long serialVersionUID = -5375545348395273510L;
	private String var;

	public int doEndTag() throws JspException {
		User u = null;
		try {
			u = Utils.checkUser((HttpServletRequest) pageContext.getRequest(), 
					(HttpServletResponse) pageContext.getResponse());
		} catch (IOException e) {
			throw new JspException(e);
		}
		if (u == null)
			return SKIP_PAGE;
		pageContext.setAttribute(var, u);
		return EVAL_PAGE;
	}
}
