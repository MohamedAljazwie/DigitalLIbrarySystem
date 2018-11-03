package org.sun.Library.Filter;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.sun.Library.Bean.Access;
import org.sun.Library.Bean.Message;

public class FilterChangePassword implements Filter {
    private FilterConfig _filterConfig = null;
    private String errors = "";
    private String url;
    private String userName = "";
    private String oldPassword = "";
    private String newPassword = "";

    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
    }

    public void destroy() {
        _filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                                     ServletException {
        if (error(request)) {
            errors = errors.substring(0, errors.length() - 1);
            url = "Changepassword.jsp?" + errors;
            ((HttpServletResponse) response).sendRedirect(url);
        } else
            send(request, response, chain);
    }

    private boolean error(ServletRequest request) {
        userName = request.getParameter("userName");
        oldPassword = request.getParameter("oldPassword");
        newPassword = request.getParameter("newPassword");
        request.setAttribute("userName", userName);
        request.setAttribute("oldPassword", oldPassword);
        request.setAttribute("newPassword", newPassword);
        String status = "status=May Be User Name Or Pawssword Is In Correct Check Them";
        errors = status + "&";
        boolean state = false;
        if (userName == null || userName.equals("")) {
            errors += "errorUserName=Please Write Your User Name&";
            state = true;
        }
        if (oldPassword == null || oldPassword.equals("")) {
            errors += "errorOldPassword=please write your Current Password&";
            state = true;
        }
        if (newPassword == null || newPassword.equals("")) {
            errors += "errorNewPassword=please write your New Password&";
            state = true;
        }
        return state;
    }

    private void send(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                                  ServletException {
        Access aldAccess = new Access(userName, oldPassword);
        Access newAccess = new Access(userName, newPassword);
        Map<String,Access> mapAccess=new HashMap<>();
        mapAccess.put("aldAccess", aldAccess);
        mapAccess.put("newAccess", newAccess);
        Message message = new Message<>(Message.Access, mapAccess);
        request.setAttribute("message", message);
        chain.doFilter(request, response);
    }
}
