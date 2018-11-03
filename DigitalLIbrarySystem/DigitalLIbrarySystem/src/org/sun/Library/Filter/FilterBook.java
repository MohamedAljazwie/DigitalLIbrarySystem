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
import org.sun.Library.Controler.Book.Book;
import org.sun.Library.Controler.Types.Role;

public class FilterBook implements Filter {
    private FilterConfig _filterConfig = null;
private         Book book;
private String url;
private String errors="";
    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
    }

    public void destroy() {
        _filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                                     ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        
        book = (Book) session.getAttribute("book");
        session.removeAttribute("book");
        StringBuffer buffer = new StringBuffer();
        buffer.append("ISBN  "+book.getBookSpec().getIsbn() )
            .append("\n").
            append("price  " +    book.getBookSpec().getPrice())
        .append("\n").
        append("Catgory  " +    book.getCategory().getName())
    .append("\n").
        append("Catgory id  " +    book.getCategory().getId()).
            append("\n").
            append("Copies   " +  book.getCopies())
            . append("\n").
            append("Title   " +  book.getBookSpec().getTitle())
        . append("\n").
        append("Date   " +  book.getBookSpec().getPublishDate())
          . append("\n").
            append("Subject   " +  book.getBookSpec().getSubject())
            .append("\n").append("Author Nmae  " +book.getBookSpec().getAuthor().getInfo().getName())
            .append("\n").append("Publisher Nmae  " +book.getBookSpec().getPublisher().getInfo().getName())

        .append("\n").append("Author id  " +book.getBookSpec().getAuthor().getInfo().getId())
        .append("\n").append("Publisher id  " +book.getBookSpec().getPublisher().getInfo().getId());
       System.out.println("\n "+buffer);
//     if(bookError()) {
//         
//     }
//     else
       sendDate(request, response, chain);
    }
    
    private boolean bookError() {
        boolean state=false;
        return state;
    }
    private void sendDate(ServletRequest request ,ServletResponse respons,FilterChain chain) throws IOException,
                                                                                                     ServletException {
        Message message=null;
        message=new Message(Role.Book.name(), book);
        request.setAttribute(Message.addBook, message);
        chain.doFilter(request, respons);
    }
}
