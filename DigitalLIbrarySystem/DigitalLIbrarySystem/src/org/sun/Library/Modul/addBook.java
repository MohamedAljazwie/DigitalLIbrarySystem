package org.sun.Library.Modul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Admin.Admin;
import org.sun.Library.Controler.Admin.Admins;
import org.sun.Library.Controler.Admin.AdminRegistration;
import org.sun.Library.Controler.Book.Book;
import org.sun.Library.Controler.Member.Person;
import org.sun.Library.Controler.Types.Role;

public class addBook extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1256";
    private Message message;
    private String url;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

@Override
    protected void doGet(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse) throws ServletException, IOException {
 doPost(httpServletRequest, httpServletResponse);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        try {
            message = (Message) request.getAttribute(Message.addBook);
            Book book = (Book) message.getMessage();
         //   Admins<Book> admin = new AdminRegistration<Book>();
            Admin<Book> admin = Admin.getInstance();
            message = admin.add(book, Role.valueOf(message.getTitle()));
            url = "AdminHome.jsp?status=" + message.getMessage();
            response.sendRedirect(url);
        } catch (NullPointerException e) {
                  System.out.println(" \n\n You Have An Error IN message GETATTRIBUTE IN doPost  Method   in addBook Servlet  \n\n" +
                               "\n\n  the Message   is     " + e.getMessage() + "\n\n" + e.toString() +
                               "\n\n LocalizedMessage" + e.getLocalizedMessage() + "\n\n Cause" + e.getCause());

          e.printStackTrace();
     
        } catch (Exception e) {
            System.out.println(" \n\n You Have An Error IN doPost  Method   in addBook Servlet  \n\n" +
                               "\n\n  the Message   is     " + e.getMessage() + "\n\n" + e.toString() +
                               "\n\n LocalizedMessage" + e.getLocalizedMessage() + "\n\n Cause" + e.getCause());

            e.printStackTrace();
         
        }

    }
}
