package org.sun.Library.Tags;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.sun.Library.Utilities.SearchUtility;

public class Students extends Search {
    private Map<Object, Object> student;
    
    @Override
    public int doStartTag() throws JspException {
        this.setTable("STUDENT");
    
        super.doStartTag();
        message=new SearchUtility(message).getStudents();
        student = (Map<Object, Object>) message.getMessage();
        pageContext.setAttribute("students", student);
    return EVAL_BODY_INCLUDE;
    }
    public void setTable(String table) {
        this.table=table;
    }
    public String getTable() {
        return this.table;
    }
        public void setType(String type) {
            this.type = type;
        }
    
        public String getType() {
            return type;
        }
    
        public void setValue(String value) {
            this.value = value;
        }
    
        public String getValue() {
            return value;
        }
}
