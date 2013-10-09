package br.org.bill.taglibs;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.apache.taglibs.standard.tag.common.core.ParamSupport;
import org.apache.taglibs.standard.tag.common.core.UrlSupport;

public class JavaScriptBill extends UrlSupport {

	private static final long serialVersionUID = -8167526195728873285L;
	protected static final String ATTR_TEMPLATE = "%s='%s' ";
	private ParamSupport.ParamManager params;	 // added parameters
	private String urlJquery;
	private String urlBootStrap;

	
	@Override
	public int doStartTag() throws JspException {
		int port = pageContext.getRequest().getServerPort();
		String server = pageContext.getRequest().getServerName();
		urlJquery = "http://"+server+":"+port+pageContext.getServletContext().getContextPath()+"/js/jquery.min.js";
		urlBootStrap = "http://"+server+":"+port+pageContext.getServletContext().getContextPath()+"/js/bootstrap.min.js";
		
		JspWriter out = pageContext.getOut();
		this.value = "/js/bootstrap.min.js";
		try {
			//jquery
			out.print("<script ");
			out.print(criaAtributo("type", "text/javascript"));
			out.print(criaAtributo("src", urlJquery ));
			out.print("></script>");
			//bootStrap
			out.print("<script ");
			out.print(criaAtributo("type", "text/javascript"));
			out.print(criaAtributo("src", urlBootStrap ));
			out.print("></script>");
			
		}catch (java.io.IOException ex) { throw new JspTagException(ex.toString(), ex);}
		return EVAL_BODY_BUFFERED;
	}
	
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	protected String criaAtributo(String atributo, String valor){
		return String.format(ATTR_TEMPLATE, atributo, valor);
	}

	public ParamSupport.ParamManager getParams() {
		return params;
	}

	
}
