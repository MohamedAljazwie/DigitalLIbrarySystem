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

public class Category implements Filter {
    private String name;
    private String errors = "";
    private String url;

    private FilterConfig _filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
    }

    public void destroy() {
        _filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                                     ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if (session == null||session.isNew()) {
            url = "Login.jsp";
            ((HttpServletResponse) response).sendRedirect(url);
        } else {
            String user=(String)session.getAttribute("userName");
            System.out.println("user  "+user);
            if (error(request)) {
                errors = errors.substring(0, errors.length() - 1);
                url = "NewCategory.jsp?" + errors;
                errors="";
                ((HttpServletResponse) response).sendRedirect(url);
            } else
                send(request, response, chain);
        }
    }

    private boolean error(ServletRequest request) {
        name = request.getParameter("name");
        boolean state = false;
        if (name == null | name.equals("")) {
            errors += "name=You Must Write a Category Name &";
            state = true;
        }
        return state;
    }

    private void send(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                                  ServletException {
        org.sun.Library.Controler.Book.Category category = new org.sun.Library.Controler.Book.Category(name);
        Message message = new Message(Message.addCategory, category);
        request.setAttribute("addCategory", message);
        chain.doFilter(request, response);
    }
}
