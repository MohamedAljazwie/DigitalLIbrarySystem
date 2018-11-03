package org.sun.Library.Modul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Admin.Admins;
import org.sun.Library.Controler.Admin.AdminRegistration;
import org.sun.Library.Controler.Member.Person;
import org.sun.Library.Controler.Types.Role;
import java.lang.System;

import org.sun.Library.Bean.PersonInfo;
import org.sun.Library.Controler.Admin.Admin;

public class addPerson extends HttpServlet {
    private String url;
    private static final String CONTENT_TYPE = "text/html; charset=windows-1256";
private Message message;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        try{
     message=(Message)request.getAttribute("message"); 
   
      Person person = (Person) message.getMessage();
     // Admins <Person>admin=new AdminRegistration<Person>();
        Admin<Person> admin = Admin.getInstance();
    System.out.println("title  is"+message.getTitle());
     message= admin.add(person, Role.valueOf(message.getTitle()));
        url = "AdminHome.jsp?status=" +message.getMessage();
         response.sendRedirect(url);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println(" \n\n You Have An Error IN message GETATTRIBUTE IN doPost  Method   in addPerson Servlet  \n\n" +
                               "\n\n  the Message   is     " + e.getMessage() + "\n\n" + e.toString() +
                               "\n\n LocalizedMessage" + e.getLocalizedMessage() + "\n\n Cause" + e.getCause());

        }
       catch (Exception e) {
            e.printStackTrace();
            System.out.println(" \n\n You Have An Error IN doPost  Method   in addPerson Servlet  \n\n" +
                               "\n\n  the Message   is     " + e.getMessage() + "\n\n" + e.toString() +
                               "\n\n LocalizedMessage" + e.getLocalizedMessage() + "\n\n Cause" + e.getCause());

        }
     
    }
}
