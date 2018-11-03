package org.sun.Library.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sun.Library.Bean.Message;

public class FilterIssueBook implements Filter {
    private FilterConfig _filterConfig = null;
    private HttpSession session; 
    private  org.sun.Library.Controler.Book.IssueBook issueBook;

    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
    }

    public void destroy() {
        _filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                                     ServletException {
        session=((HttpServletRequest)request).getSession(false);
       issueBook =(org.sun.Library.Controler.Book.IssueBook)session.getAttribute("issue");
      session.removeAttribute("issue");
     System.out.println("IssueBook  "+issueBook);
        StringBuffer buffer = new StringBuffer();
       buffer.append("ISBN  "+issueBook.getBook().getBookSpec().getIsbn() )
          .append("\n") 
         .append("\n").
          append("Book ID  " +    issueBook.getBook().getId())
         .append("\n").
           append("Student id  " +    issueBook.getStudent().getInfo().getId()).
            append("\n").
            append("Student NationalID   " +  issueBook.getStudent().getNationalID())
            . append("\n").
            append("Issue  Date   " + issueBook.getIssueDate())
        . append("\n");
        System.out.println("\n "+buffer);
        sendDate(request, response, chain);
        
       
    }
    private void sendDate(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,
                                                                                                      ServletException {
        Message message=null;
      
        message=new Message(Message.IssueBook, issueBook);
        request.setAttribute(Message.IssueBook, message);
        chain.doFilter(request, response);
    }
}
