package br.org.bill.taglibs;

/** leonardoneves Date: 04/10/2013 */

import java.io.IOException;

import javax.servlet.jsp.JspException;

public class AjaxButton extends SpringSuportedTag {

	private String value;
    private String fragment;
    private String url;
   
    public void makeTag() throws JspException, IOException {
    	//Perform substr operation on string.
        out.print("<input ");
		out.print(criaAtributo("type", "button"));
		out.print(criaAtributo("value", value));
		out.print(criaAtributo("onclick", "jQuery.ajax({type:\"POST\",data:jQuery(this).parents(\"form:first\").serialize"
						+"(),url:\""+url+"\",success:function(data,textStatus){jQuery(\"#"+fragment+"\").html"
						+"(data);},error:function(XMLHttpRequest,textStatus,errorThrown){}});return false;"));
		out.print("></input>");
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFragment() {
		return fragment;
	}

	public void setFragment(String fragment) {
		this.fragment = fragment;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
