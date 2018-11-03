package org.sun.Library.Tags;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.sun.Library.Bean.Message;
import org.sun.Library.System.System;

public class Search extends BodyTagSupport {
    protected Message message;
    protected String type;
    protected String[]types;
    protected Object[]values;
    protected String value;
    protected String table;
    @Override
    public int doStartTag() throws JspException {
        
        java.lang.System.out.println("Your type is   "+type
                                     +"\n your value is   "+value);
        message=System.search(table, type, value);
         return EVAL_BODY_INCLUDE;
    }


}
