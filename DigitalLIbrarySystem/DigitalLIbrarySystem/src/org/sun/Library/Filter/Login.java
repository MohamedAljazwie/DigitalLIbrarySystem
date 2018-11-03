package org.sun.Library.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sun.Library.Bean.Access;
import org.sun.Library.Bean.Message;

public class Login implements Filter {
    private FilterConfig _filterConfig = null;
    private  String errors="";
    private String url; 
    private String userName="";
    private String password="";
    

    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
    }

    public void destroy() {
        _filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                                     ServletException {
        if(error(request)) {
            errors=errors.substring(0, errors.length()-1);
            url="Login.jsp?"+errors;
            ((HttpServletResponse)response).sendRedirect(url);
        }
        else
        send(request, response, chain);
    }
    private boolean error(ServletRequest request) {
  userName=request.getParameter("userName");
   password=request.getParameter("password");
   request.setAttribute("userName", userName);
   String status="status=May Be User Name Or Pawssword Is In Correct Check Them";
   errors=status+"&";
   boolean state=false;
   if(userName==null||userName.equals("")) {
       errors+="erroruserName=Please Write Your User Name&";
       state=true;
   }
   if(password==null||password.equals("")) {
       errors+="errorPassword=please write your Password&";
       state=true;
   }
   return state;
    }
    private void send(ServletRequest request ,ServletResponse response,FilterChain chain) throws IOException,
                                                                                                  ServletException {
        Access access=new Access(userName, password);
        Message<Access> message=new Message<Access>(Message.Access, access);
        request.setAttribute("message", message);
        chain.doFilter(request, response);
    }
}
