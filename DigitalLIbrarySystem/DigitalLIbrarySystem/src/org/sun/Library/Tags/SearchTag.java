package org.sun.Library.Tags;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import javax.servlet.jsp.tagext.DynamicAttributes;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.System.System;

public class SearchTag  extends BodyTagSupport implements  DynamicAttributes{
    private Message message;
    private String role;
    private String type;
    private  Object value;
    private Map<String,Object> dynamicAttribute;
    private Map<String,Object> attributes;
    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public int doStartTag() throws JspException {
   
        dynamicAttribute=new HashMap<>();
        attributes=new HashMap<>();
       attributes.put("type", type);
        attributes.put("value", value);
        attributes.put("dynamicAttribute", dynamicAttribute);
        Role desc = Role.Nothing;;
        if(!role.equals("")&&role!=null)
          desc = Role.valueOf(role);
         java.lang.System.out.println("Role is "+role);
        java.lang.System.out.println("Type is "+type);
        java.lang.System.out.println("Value is "+value);
        message=System.search(desc, attributes);
        if(message!=null)
        {
        Map<String,Object> result = (Map<String, Object>) message.getMessage();
        List<Object> coulmnsNames = (List<Object>) result.get("coulmnsNames");
        int colspan=coulmnsNames.size();
        Map<Integer,Object> columnsData = (Map<Integer, Object>) result.get("coulmnsData");
        pageContext.setAttribute("row_count", columnsData.size(),pageContext.REQUEST_SCOPE);
       // pageContext.setAttribute("startIndex", 1);
       // pageContext.setAttribute("recordsPerPage", 10);
        pageContext.setAttribute("colspan", colspan,pageContext.SESSION_SCOPE);
        pageContext.setAttribute("coulmnsData", columnsData, pageContext.SESSION_SCOPE);
        pageContext.setAttribute("coulmnsNames", coulmnsNames, pageContext.SESSION_SCOPE);
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public void setDynamicAttribute(String string, String string2, Object object) throws JspException {
        dynamicAttribute.put(string2, object);

    }
}
