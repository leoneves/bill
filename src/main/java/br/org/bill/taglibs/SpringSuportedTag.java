package br.org.bill.taglibs;

/** leonardoneves Date: 04/10/2013 */

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public abstract class SpringSuportedTag  extends SimpleTagSupport {
	
	protected static final String ATTR_TEMPLATE = "%s='%s' ";
	protected JspWriter out;
	
	
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
	  //Get the writer object for output.
        this.out = pageContext.getOut();
        makeTag();
	}


	abstract void makeTag() throws JspException, IOException;
	
	
	protected String criaAtributo(String atributo, String valor){
		return String.format(ATTR_TEMPLATE, atributo, valor);
	}


	public JspWriter getOut() {
		return out;
	}


	public void setOut(JspWriter out) {
		this.out = out;
	}

}
