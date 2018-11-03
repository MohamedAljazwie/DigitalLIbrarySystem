package org.sun.Library.Modul;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Admin.Admin;
import org.sun.Library.Controler.Admin.Admins;
import org.sun.Library.Controler.Admin.AdminRegistration;
import org.sun.Library.Controler.Book.Category;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.DataBase.JdbcConnection;

public class NewCategory extends HttpServlet {
    private String url;
    private static final String CONTENT_TYPE = "text/html; charset=windows-1256";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
   //   JdbcConnection jdbcConnection = JdbcConnection.getInstance();

    //   HttpSession session = request.getSession(false);
    // Connection connection = (Connection) session.getAttribute("LMSConnection");
        Message message = (Message) request.getAttribute("addCategory");
      //  jdbcConnection.addConnection(connection);
        Category category = (Category) message.getMessage();
     //   Admins<Category> admin = new AdminRegistration<Category>();
       Admin<Category> admin = Admin.getInstance();
        message = admin.add(category, Role.Category);
       url = "AdminHome.jsp?status=" + (String) message.getMessage();
        response.sendRedirect(url);

    }
}
