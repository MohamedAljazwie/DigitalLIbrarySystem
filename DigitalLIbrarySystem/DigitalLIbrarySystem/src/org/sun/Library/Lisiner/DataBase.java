package org.sun.Library.Lisiner;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class DataBase implements HttpSessionListener {

    private HttpSession session = null;


    public void sessionCreated(HttpSessionEvent event) {
        session = event.getSession();
        try {
            //load driver
            if (session.isNew()) {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                System.out.println(" Deiver Access Laod");
                //Class.`forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection connection =
                    DriverManager.getConnection("" + "jdbc:oracle:thin:@localhost:1521:xe", "digitallibrary",
                                                "digitallibrary");
                //  mohamed_aljazwiee
                //con = DriverManager.getConnection("jdbc:odbc:"+data_Source_Name);
                System.out.println(" Conection Is Success");

                session.setAttribute("LMSConnection", connection);
            //    session.setAttribute("user", "Mohamed");
                System.out.println("Application  initialized");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        session = event.getSession();
        session.invalidate();
        session.removeAttribute("LMSConnection");
        System.out.println("Application  Closed");
    }
}
