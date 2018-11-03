package org.sun.Library.System;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.System;
import java.util.HashMap;
import java.util.Map;

import org.sun.Library.Bean.Message;
import org.sun.Library.DataBase.JdbcConnection;

public class PublisherView extends PersonView {
    private Message message;
    private Map<Integer, String> publisher;  
    @Override
    public Message view() {
           StringBuffer buffer=new StringBuffer();
           String tableName = "PUBLISHER";
           String[] fieldes = { "*" };
           String[] fieldesCondition = { };
           String[] attributs = { };
           JdbcConnection jdbcConnection = JdbcConnection.getInstance();

           try {
               ResultSet resulte = jdbcConnection.check(tableName, fieldes, fieldesCondition, attributs);

               if (resulte != null) {
                   publisher = new HashMap<Integer, String>();
                   while (resulte.next()) {
                       publisher.put(resulte.getInt("PUBLISH_ID"), resulte.getString("PUBLISHER_NAME"));
                   buffer.append(resulte.getInt("PUBLISH_ID")+"\n");
                   }
                System.out.println(buffer);
                   message = new Message<Map<Integer,String>>(Message.publisherView, publisher);
                   resulte.close();

               } else
                   message = null;
           } catch (SQLException e) {

            System.out.println("You Have An Error IN view  Method   in PUBLISHView Class  \n\n" +
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
