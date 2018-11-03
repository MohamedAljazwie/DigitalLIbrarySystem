package org.sun.Library.Modul;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

import org.sun.Library.Bean.Access;
import org.sun.Library.Bean.Message;

public class ChangePassword extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1256";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>ChangePassword</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a GET. This is the reply.</p>");
        out.println("</body></html>");
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
    Message message = (Message) request.getAttribute("message");
        Map<String ,Access> mapAccess = (Map<String, Access>)message.getMessage();
        
    }
}
