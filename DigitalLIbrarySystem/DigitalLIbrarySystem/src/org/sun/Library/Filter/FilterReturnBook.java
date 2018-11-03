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
import org.sun.Library.Controler.Book.ReturnBook;

public class FilterReturnBook implements Filter {
    private FilterConfig _filterConfig = null;

    private HttpSession session; 
    private  ReturnBook returnBook;

    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
    }

    public void destroy() {
        _filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                                     ServletException {
        session=((HttpServletRequest)request).getSession(false);
        returnBook =(ReturnBook)session.getAttribute("returnBook");
        session.removeAttribute("returnBook");
        System.out.println("IssueBook  "+returnBook);
        StringBuffer buffer = new StringBuffer();
        buffer . append("Book ID  " +    returnBook.getBook().getId())
         .append("\n").
         append("Student id  " +    returnBook.getStudent().getInfo().getId()).
             append("\n").
             append("Student NationalID   " +  returnBook.getStudent().getNationalID())
             . append("\n").
             append("Issue  Date   " + returnBook.getIssueDate()).
            append("\n").
            append("ISBN  "+returnBook.getBook().getBookSpec().getIsbn() )
         . append("\n");
         System.out.println("\n "+buffer);
         sendDate(request, response, chain);
         
        
        }
        private void sendDate(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,
                                                                                                       ServletException {
         Message message=null;
        
         message=new Message(Message.ReturnBook, returnBook);
         request.setAttribute(Message.ReturnBook, message);
         chain.doFilter(request, response);
        }
}
