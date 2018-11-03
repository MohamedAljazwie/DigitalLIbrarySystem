package org.sun.Library.Tags;

import java.util.Map;

import javax.servlet.jsp.JspException;

import org.sun.Library.Utilities.SearchUtility;


public class Books  extends Search{
    private Map<Object, Object> books;
    @Override
    public int doStartTag() throws JspException {
        this.setTable("BOOK");
        super.doStartTag();
        message=new SearchUtility(message).getBooks();
        books = (Map<Object, Object>) message.getMessage();
        pageContext.setAttribute("books", books);
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
