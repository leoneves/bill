package br.org.bill.taglibs;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.apache.taglibs.standard.tag.common.core.ParamSupport;
import org.apache.taglibs.standard.tag.common.core.UrlSupport;

public class CSSBill extends UrlSupport {

	private static final long serialVersionUID = 7917395172132375769L;
	protected static final String ATTR_TEMPLATE = "%s='%s' ";
	private ParamSupport.ParamManager params;	 // added parameters
	private String urlBootStrap;

	
	@Override
	public int doStartTag() throws JspException {
		int port = pageContext.getRequest().getServerPort();
		String server = pageContext.getRequest().getServerName();
		urlBootStrap = "http://"+server+":"+port+pageContext.getServletContext().getContextPath()+"/stylesheets/bootstrap.min.css";
		
		JspWriter out = pageContext.getOut();
		this.value = "/js/bootstrap.min.js";
		try {
			//bootStrap
			out.print("<link ");
			out.print(criaAtributo("rel", "stylesheet"));
			out.print(criaAtributo("type", "text/css"));
			out.print(criaAtributo("href", urlBootStrap ));
			out.print("/>");
			
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
