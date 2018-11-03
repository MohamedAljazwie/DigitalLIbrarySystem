package org.sun.Library.Modul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Admin.Admin;
import org.sun.Library.Controler.Book.FINE;

public class Fine extends HttpServlet {
    private Message message;
    private String url;
    private static final String CONTENT_TYPE = "text/html; charset=windows-1256";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        message = (Message) request.getAttribute(Message.Fine);
        HttpSession session = request.getSession(false);
        FINE fine =(FINE) message.getMessage();
        Admin admin = Admin.getInstance();
        message =admin.addFine(fine);
        url = "AdminHome.jsp?status="+(String)message.getMessage();
        } catch (NullPointerException e) {
            System.out.println(" \n\n You Have An Error IN message Get Attribute IN doPost  Method   in Fine Servlet  \n\n" +
                               "\n\n  the Message   is     " + e.getMessage() + "\n\n" + e.toString() +
                               "\n\n LocalizedMessage" + e.getLocalizedMessage() + "\n\n Cause" + e.getCause());

            e.printStackTrace();

        } catch (Exception e) {
            System.out.println(" \n\n You Have An Error IN doPost  Method   in Fine Servlet  \n\n" +
                               "\n\n  the Message   is     " + e.getMessage() + "\n\n" + e.toString() +
                               "\n\n LocalizedMessage" + e.getLocalizedMessage() + "\n\n Cause" + e.getCause());

            e.printStackTrace();

        }
        response.sendRedirect(url);
    }
}
