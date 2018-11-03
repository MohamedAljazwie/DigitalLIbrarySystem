package org.sun.Library.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Book.FINE;

public class FilterFine implements Filter {
    private FilterConfig _filterConfig = null;
    private HttpSession session;
    private FINE fine;
    private String url;

    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
    }

    public void destroy() {
        _filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                                     ServletException {
      session=((HttpServletRequest)request).getSession(false);
        fine=(FINE)session.getAttribute("FINE");
      if(session.isNew()||session==null||fine==null)
      {
      url="Login.jsp";
      ((HttpServletResponse)response).sendRedirect(url);
      }
      else {
          
         // fine.setModeOfPay(request.getParameter("modeOfPay"));
          //fine.setRemark(request.getParameter("remark"));
          String bookLost=(String)session.getAttribute("bookLost");
          if(bookLost==null||bookLost.equals(""))
          fine.setTotalCost(fine.getCost());
          session.removeAttribute("bookLost");
          session.removeAttribute("FINE");
          session.removeAttribute("spec");
          System.out.println("Fine   "+fine);
                  StringBuffer buffer = new StringBuffer();
                 buffer.append("Fine Date   "+fine.getFineDate())
                    .append("\n") 
                   .append("\n").
                    append("Naitionsl ID   " +  fine.getReturnBook(). getStudent().getNationalID())
                   .append("\n").
                     append("Student id  " +    fine.getReturnBook().getStudent().getInfo().getId()).
                      append("\n"). append("\n")
                  . append("\n");
                  System.out.println("\n "+buffer);
          sendDate(request, response, chain);
          
      }
    }
    private void sendDate(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,
                                                                                                      ServletException {
        Message message=null;
    message=new Message(Message.Fine, fine);
    request.setAttribute(message.Fine, message);
    chain.doFilter(request, response);
    }
}
