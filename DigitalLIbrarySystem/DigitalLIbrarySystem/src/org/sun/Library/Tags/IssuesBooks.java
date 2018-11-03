package org.sun.Library.Tags;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Admin.Admin;
import org.sun.Library.Controler.Types.Role;

public class IssuesBooks  extends BodyTagSupport{
    private Message message;
    private Map<Object, Object> books;
    private List<Object> For;
    private String isbn;
    private String nationalID;
    @Override
    public int doStartTag() throws JspException {
      Admin admin = Admin.getInstance();
      For=new ArrayList<>();
      String[] by={"isbn","nationalID"};
      For.add(isbn);
      For.add(nationalID);
      message=admin.search(by, For, Role.IssuseBook);

        books = (Map<Object, Object>) message.getMessage();
        pageContext.setAttribute("books", books);
      return EVAL_BODY_INCLUDE;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getNationalID() {
        return nationalID;
    }
}
