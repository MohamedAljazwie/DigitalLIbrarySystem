package org.sun.Library.Tags;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.From;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import javax.servlet.jsp.tagext.DynamicAttributes;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.System.System;

public class ViewTag extends BodyTagSupport  implements DynamicAttributes {
    private String role ;
    private String reportDate ;
    private Map<String, Object> attributs;
    private Message message;
    private Map<String,Object> dynamicAttribute;
    private  Object iterate=0;
    @Override
    public int doStartTag() throws JspException {
        
//        if(iterate!=1)
//        {
        dynamicAttribute=new HashMap<>();
        try {
            if (reportDate.equals("Others")) {
                String fromDate = pageContext.getRequest().getParameter("fromDate");
                System.out().println("From Date" +fromDate);
                String toDate = pageContext.getRequest().getParameter("toDate");
                System.out().println("To Date" +toDate);
                attributs = System.getDate("09/01/2016", "09/10/2016");
            } else
            {
                if(reportDate.equals("")||reportDate==null)
                    reportDate="monthly";
                
                attributs = System.getDate(reportDate);
            }
        } catch (NullPointerException e) {

        }
        Role desc = Role.Nothing;       
        if (!role.equals("") && role != null)
            desc = Role.valueOf(role);
      System.out().println("Role is " + role);
        System.out().println(" Report Date is"+reportDate);
        message = System.viewAll(desc, attributs);
        if (message != null) {
            Map<String, Object> result = (Map<String, Object>) message.getMessage();
            List<Object> coulmnsNames = (List<Object>) result.get("coulmnsNames");
            int colspan = coulmnsNames.size();
            Map<Integer, Object> columnsData = (Map<Integer, Object>) result.get("coulmnsData");
            pageContext.setAttribute("row_count", columnsData.size(), pageContext.REQUEST_SCOPE);
            // pageContext.setAttribute("startIndex", 1);
            // pageContext.setAttribute("recordsPerPage", 10);
            pageContext.setAttribute("colspan", colspan, pageContext.SESSION_SCOPE);
            pageContext.setAttribute("coulmnsData", columnsData, pageContext.SESSION_SCOPE);
            pageContext.setAttribute("coulmnsNames", coulmnsNames, pageContext.SESSION_SCOPE);
        
       
        }
        return EVAL_BODY_INCLUDE;
    }
//    @Override
//    public int doAfterBody() throws JspException {
//        iterate= pageContext.getAttribute("firstIterate", pageContext.REQUEST_SCOPE);
//        if(iterate==1)
//        return EVAL_BODY_AGAIN;
//        else
//        return SKIP_BODY;
//    }
    @Override
    public void setDynamicAttribute(String string, String string2, Object object) throws JspException {
        try{
        dynamicAttribute.put(string2, object);
        }catch(NullPointerException e) {
            e.printStackTrace();
        }
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportDate() {
        return reportDate;
    }

}
