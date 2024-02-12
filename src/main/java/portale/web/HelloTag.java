package portale.web;

import java.io.IOException;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {
	private static final long serialVersionUID = 8219179355689955771L;
	private String msg = "";
	
	
	public int print(String msg) throws JspException {
		try {
			pageContext.getOut().println(msg);
			return EVAL_PAGE;
		} catch (IOException e) {
			throw new JspException(e);
		}
	}
	
	@Override
	public int doStartTag() throws JspException  {
		try {
			pageContext.getOut().println("<div>Inizio Tag</div>");
			return EVAL_BODY_INCLUDE;
		} catch (IOException e) {
			throw new JspException(e);
		}
	}
	
	@Override
	public int doAfterBody() throws JspException {
		try {
			pageContext.getOut().println("<div>FineTag</div>");
			return EVAL_PAGE;
		} catch (IOException e) {
			throw new JspException(e);
		}
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().println("<div>FineTag</div>");
			return EVAL_PAGE;
		} catch (IOException e) {
			throw new JspException(e);
		}
	}
}
