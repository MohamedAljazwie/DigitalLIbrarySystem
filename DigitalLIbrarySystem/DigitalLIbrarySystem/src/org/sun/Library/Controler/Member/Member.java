package org.sun.Library.Controler.Member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sun.Library.Bean.Access;
import org.sun.Library.Bean.Message;
import org.sun.Library.DataBase.JdbcConnection;

public abstract class Member implements Person {
    protected Access access;


    public void setAccess(Access access) {
        this.access = access;
    }

    public static Message check(Access access) {
        Message message = null;
        String tableName = "LMSLOGIN";
        String[] fieldes = { "*" };
        String[] fieldesCondition = { "USERNAME", "PASSWORD" };
        String[] attributs = { access.getUserName(), access.getPassword() };
        JdbcConnection jdbcConnection = JdbcConnection.getInstance();
        try {
            ResultSet resulte = jdbcConnection.check(tableName, fieldes, fieldesCondition, attributs);

            if (resulte.next()) {
                message = new Message(Message.Role, resulte.getString("ROLE"));
                resulte.close();
            } else
                message = null;
        } catch (SQLException e) {

            System.out.println("You Have An Error IN Check  Method   in Member Class  \n\n" +
                               "the Error Code  is     " + e.getErrorCode() + "\n\n" + "the Message   is     " +
                               e.getMessage() + "\n\n" + e.toString());
            return null;
        }
        return message;
    }

    public Access getAccess() {
        return access;
    }
}
