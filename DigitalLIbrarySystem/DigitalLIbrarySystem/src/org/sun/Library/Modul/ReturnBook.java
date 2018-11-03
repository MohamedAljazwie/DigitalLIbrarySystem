package org.sun.Library.Modul;

import java.io.IOException;

import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sun.Library.Bean.BookSpec;
import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Admin.Admin;
import org.sun.Library.Controler.Book.FINE;

public class ReturnBook extends HttpServlet {
    private Message message;
    private String url;
    private static final String CONTENT_TYPE = "text/html; charset=windows-1256";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                                                                                           IOException {
        try {
            message = (Message) request.getAttribute(Message.ReturnBook);
            HttpSession session = request.getSession(false);
            org.sun.Library.Controler.Book.ReturnBook returnBook =
                (org.sun.Library.Controler.Book.ReturnBook) message.getMessage();
            Admin admin = Admin.getInstance();
            message = admin.returnBook(returnBook);
            System.out.println(" Title is  "+message.getTitle());
            switch (message.getTitle()) {
            case Message.Error:
                url = "AdminHome.jsp?status=" + (String) message.getMessage();
                break;
            case Message.ReturnBook:
                {
                message = (Message) message.getMessage();
                Map<String, Object> dataMessage = (Map<String, Object>) message.getMessage();
                FINE fine = (FINE) dataMessage.get(Message.Fine);
                BookSpec spec = (BookSpec) dataMessage.get(Message.Spec);
                session.setAttribute("FINE", fine);
                session.setAttribute("spec", spec);
                    System.out.println(" Title is  "+message.getTitle());
                url = "Fine.jsp?status="+message.getTitle();
                }
                break;
            default :
                url = "AdminHome.jsp";
                break;
                
            }

          
        } catch (NullPointerException e) {
            System.out.println(" \n\n You Have An Error IN message Get Attribute IN doPost  Method   in IssueBook Servlet  \n\n" +
                               "\n\n  the Message   is     " + e.getMessage() + "\n\n" + e.toString() +
                               "\n\n LocalizedMessage" + e.getLocalizedMessage() + "\n\n Cause" + e.getCause());

            e.printStackTrace();

        } catch (Exception e) {
            System.out.println(" \n\n You Have An Error IN doPost  Method   in IssueBook Servlet  \n\n" +
                               "\n\n  the Message   is     " + e.getMessage() + "\n\n" + e.toString() +
                               "\n\n LocalizedMessage" + e.getLocalizedMessage() + "\n\n Cause" + e.getCause());

            e.printStackTrace();

        }
        response.sendRedirect(url);
    }
}
