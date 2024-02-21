package portale.web.tags;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import portale.backend.User;
import portale.web.Utils;

@Data
@EqualsAndHashCode(callSuper=false)
public class CheckUserTag extends TagSupport {
	private static final long serialVersionUID = -3904024210709049728L;
	private String var;
	private Boolean admin;

	@Override
	public int doEndTag() throws JspException {
		User u = null;
		try {
			u = Utils.checkUser((HttpServletRequest) pageContext.getRequest(), (HttpServletResponse) pageContext.getResponse(), admin == null ? false : admin);
			if (u == null)
				return SKIP_PAGE;
			if (u != null && !u.isAdmin()) {
				HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
				response.sendRedirect("home.jsp");
				return SKIP_PAGE;
			}
			pageContext.setAttribute(var, u);
			return EVAL_PAGE;
		} catch (IOException e) {
			throw new JspException(e);
		}
	}
}
