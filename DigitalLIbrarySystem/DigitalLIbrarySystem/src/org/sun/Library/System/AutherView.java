package org.sun.Library.System;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.System;
import java.util.HashMap;
import java.util.Map;

import org.sun.Library.Bean.Message;
import org.sun.Library.DataBase.JdbcConnection;

public class AutherView extends PersonView {
    private Message message;
    private Map<Integer, String> author;  
    @Override
    public Message view() {
        StringBuffer buffer=new StringBuffer();
        String tableName = "AUTHOR";
        String[] fieldes = { "*" };
        String[] fieldesCondition = { };
        Object[] attributs = { };
        JdbcConnection jdbcConnection = JdbcConnection.getInstance();

        try {
            ResultSet resulte = jdbcConnection.check(tableName, fieldes, fieldesCondition, attributs);

            if (resulte != null) {
                author = new HashMap<Integer, String>();
                while (resulte.next()) {
                    author.put(resulte.getInt("AUTHOR_ID"), resulte.getString("AUTHOR_NAME"));
                buffer.append(resulte.getInt("AUTHOR_ID")+"\n");
                }
                System.out.println(buffer);
                message = new Message<Map<Integer,String>>(Message.authorView, author);
                resulte.close();

            } else
                message = null;
        } catch (SQLException e) {

            System.out.println("You Have An Error IN view  Method   in AUTHORView Class  \n\n" +
                               "the Error Code  is     " + e.getErrorCode() + "\n\n" + "the Message   is     " +
                               e.getMessage() + "\n\n" + e.toString()+"\n\n");
            e.printStackTrace();
            return null;
        }
        return message;
    }

    @Override
    public Message viewAll(Object desc) {
        // TODO Implement this method
        return null;
    }
}
