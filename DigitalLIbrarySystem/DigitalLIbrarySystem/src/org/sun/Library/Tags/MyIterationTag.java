package org.sun.Library.Tags;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Iterator;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;

import org.sun.Library.Bean.Employee;

/**
 *
 * @author Mohamed_Aljazwiee
 */
public class MyIterationTag extends TagSupport  implements DynamicAttributes{

    private List<Employee> employeeList;
    JspWriter out;
    private Iterator<Employee> iterator;

    public MyIterationTag() {
    }

    public void setEmployeeList(List<Employee> EmployeeList) {
        this.employeeList = EmployeeList;
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    @Override
    public int doStartTag() throws JspException {
        out = pageContext.getOut();
        try {
           
                Employee employee_2=new Employee("mohamed", "mal", "2000");
                pageContext.setAttribute("Employee", employee_2);
                return EVAL_BODY_INCLUDE;
          
        } catch (NullPointerException ex) {
            return     SKIP_BODY;
        }

    }

    @Override
    public int doAfterBody() throws JspException {
        
            Employee employee_2=new Employee("mohamed", "mal", "2000");
            pageContext.setAttribute("Employee", employee_2);
         
   
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    @Override
    public void release() {
        super.release();
    }

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
