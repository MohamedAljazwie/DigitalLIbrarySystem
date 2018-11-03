package org.sun.Library.System;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sun.Library.Bean.Message;
import org.sun.Library.DataBase.JdbcConnection;

public class StudentView extends PersonView {
    private Message message;
    private Map<Integer, String> category;  
    @Override
    public Message view() {
        StringBuffer buffer=new StringBuffer();
        String tableName = "STUDENT";
        String[] fieldes = { "*" };
        String[] fieldesCondition = { };
        String[] attributs = { };
        JdbcConnection jdbcConnection = JdbcConnection.getInstance();

        try {
            ResultSet resulte = jdbcConnection.check(tableName, fieldes, fieldesCondition, attributs);

            if (resulte != null) {
                category = new HashMap<Integer, String>();
                while (resulte.next()) {
                    category.put(resulte.getInt("STUDENT_NATIONALID"), resulte.getString("STUDENT_NAME"));
                buffer.append(resulte.getInt("STUDENT_NAME")+"\n");
                }
                System.out.println(buffer);
                message = new Message<Map<Integer,String>>(Message.studentView, category);
                resulte.close();

            } else
                message = null;
        } catch (SQLException e) {

            System.out.println("You Have An Error IN view  Method   in PUBLISHView Class  \n\n" +
                               "the Error Code  is     " + e.getErrorCode() + "\n\n" + "the Message   is     " +
                               e.getMessage() + "\n\n" + e.toString());
            return null;
        }
        return message;
    }

    @Override
    public Message viewAll(Object desc) {
        Map<String,Object>data = (Map<String, Object>) desc;
        Map<String,Object>attributes=new HashMap<>();
        List<Object>forValues=new ArrayList<>();
        String fromDate = (String) data.get("fromDate");
        String toDate = (String) data.get("toDate");
        forValues.add(fromDate);
        forValues.add(toDate);
        attributes.put("foValues", forValues);
        List<String>byConditions=new ArrayList<>();
        byConditions.add(" F.FINE_DATE ");
        byConditions.add("");
        attributes.put("byConditions", byConditions);
        List<String>operators=new ArrayList<>();
        operators.add(" BETWEEN ");
        operators.add("");
        List<String>seperators=new ArrayList<>();
        seperators.add(" AND ");
        seperators.add("");
        attributes.put("operators", operators);
        attributes.put("seperators", seperators);
        return new StudentSearch().showFines(attributes);
    }
}
