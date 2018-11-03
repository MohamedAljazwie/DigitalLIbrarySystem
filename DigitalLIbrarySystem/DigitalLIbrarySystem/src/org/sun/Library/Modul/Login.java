package org.sun.Library.Modul;

import java.io.IOException;
import java.io.PrintWriter;


import java.lang.reflect.Type;

import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

import org.sun.Library.Bean.Access;
import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Member.Member;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.DataBase.JdbcConnection;

public class Login extends HttpServlet {
    private String url;
    private static final String CONTENT_TYPE = "text/html; charset=windows-1256";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
    
       Message<Access> message=(Message<Access>)request.getAttribute("message");
       Access access=message.getMessage();
       HttpSession session=request.getSession(true);
       Connection connection=(Connection)session.getAttribute("LMSConnection");
      JdbcConnection jdbcConnection=JdbcConnection.getInstance();
      jdbcConnection.addConnection(connection);
      Message role = Member.check(access);
      if(role!=null) {
          String roleAccess=(String)role.getMessage();
          switch(roleAccess) {
          case  "Admin"  :
              url="AdminHome.jsp";
              break;
          case  "Student"  :
              url="StudentHome.jsp";
              break;
          case  "User"   :
              url="UserHome.jsp";
              break;
          }
          session.setAttribute("userName", access.getUserName());
         session.setAttribute("roleAccess", Role.valueOf(roleAccess));
      }
      else
      url="Login.jsp";
       response.sendRedirect(url);
    }
}
