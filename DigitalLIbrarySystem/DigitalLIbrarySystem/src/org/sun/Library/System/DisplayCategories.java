package org.sun.Library.System;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.lang.System;

import java.util.HashMap;
import java.util.Map;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.DataBase.JdbcConnection;

public class DisplayCategories  implements View {

    private Message message;
    private Map<Integer, String> category;

    public Message view() {
        StringBuffer buffer=new StringBuffer();
        String tableName = "CATEGORY";
        String[] fieldes = { "*" };
        String[] fieldesCondition = { };
        String[] attributs = { };
        JdbcConnection jdbcConnection = JdbcConnection.getInstance();

        try {
            ResultSet resulte = jdbcConnection.check(tableName, fieldes, fieldesCondition, attributs);

            if (resulte != null) {
                category = new HashMap<Integer, String>();
                while (resulte.next()) {
                    category.put(resulte.getInt("CATEGORY_ID"), resulte.getString("CATEGORY_NAME"));
                buffer.append(resulte.getInt("CATEGORY_ID")+"\n");
                }
                System.out.println(buffer);
                message = new Message<Map<Integer,String>>(Message.categoryView, category);
                resulte.close();

            } else
                message = null;
        } catch (SQLException e) {

            System.out.println("You Have An Error IN view  Method   in DisplayCategories Class  \n\n" +
                               "the Error Code  is     " + e.getErrorCode() + "\n\n" + "the Message   is     " +
                               e.getMessage() + "\n\n" + e.toString());
            return null;
        }
        return message;
    }
private  Message viewAll() {
    return null;
}
    @Override
    public Message display() {
     return view();
    }

    @Override
    public Message displayAll(Object desc) {
       return viewAll();
    }
}
