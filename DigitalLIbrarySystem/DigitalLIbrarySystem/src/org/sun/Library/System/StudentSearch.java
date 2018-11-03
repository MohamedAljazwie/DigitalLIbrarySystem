package org.sun.Library.System;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.sun.Library.Bean.Message;

public class StudentSearch extends AbstractSearch {
 //  private Map<String, Object> attributes;
  //  private Map<String, Object> dynamicAttributes;

    public StudentSearch() {
        super();
      
    }

    @Override
    public Message search(Object t) {
        attributes = (Map<String, Object>) t;
        String type = (String) attributes.get("type");
        Object value = attributes.get("value");

        String[] publishertables = { " STUDENT ST " };
        //," PUBLISHER_PHONE PP"  ," PP.PHONE_NUMBER "
        String[] publisherfields = {
            " ST.STUDENT_ID                  AS \"STUDENT ID\"  ",
            " ST.STUDENT_NATIONALID  AS \" STUDENT NATIONALID \"   ",
            "  ST.STUDENT_NAME           AS \" STUDENT  NAME \"  ",
            "  ST.STUDENT_EMAIL          AS  \" STUDENT  EMAIL \"          ",
            "ST.STUDENT_ADDRESS       AS  \" STUDENT  ADDRESS \" "
        };
        String[] publisherJoins = { " ST.STUDENT_ID  " };
        getResultes(publishertables, publisherfields, publisherJoins, "");
        Map<String, Object> personResult = new HashMap<>();
        try {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                columnsNames.add(metaData.getColumnName(i));
                java.lang.System.out.println(metaData.getColumnName(i));
            }
            personResult.put("coulmnsNames", columnsNames);
        } catch (SQLException e) {
        }
        personResult.put("coulmnsData", coulmnsData);
        message = new Message(Message.personSearch, personResult);


        return message;
    }

    public  Message showFines(Object t) {
        String[] fields = {
            "\n"+" F.FINE_ID                                AS \"FINE  ID\"                           , \n" +
            "        ST.STUDENT_NAME             AS\"STUDENT NAME\"              , \n" +
            "        ST.STUDENT_NATIONALID  AS \"STUDENT NATIONALID\"   ,\n" +
            "        B.BOOK_ISBN                        AS \"BOOK ISBN\"                       ,\n" +
            "        B.BOOK_TITLE                      AS \"BOOK TITLE\"                    ,  \n" +
            "        B.PUBLISH_DATE                 AS \"PUBLISH DATE\"                 ,\n" +
            "        RB.ISSUE_DATE                   AS  \"BOOK ISSUE DATE \"        ,\n" +
            "        RB.RETURN_DATE              AS  \"BOOK RETURN DATE \"    ,\n" +
            "        RB.RETURNED_DATE        AS \"RETURNED DATE\"             ,\n" +
            "        F.FINE_DATE                      AS  \"FINE DATE\"                         ,\n" +
            "        F.TOTAL_COST                 AS  \"FINE COST\"                         ,\n" +
            "        F.MODE_OF_PAY             AS  \"MODE OF PAY\"                        "
        };
        String []tables ={"BOOK B" ,"RETURN_BOOK RB","STUDENT ST","FINE F"};
        String [] showFinesJoins={ "RB.BOOK_ID"      ,
                                                   "B.BOOK_ID"         ,
                                                   "RB.STUDENT_ID",
                                                    "ST.STUDENT_ID",
                                                    "F.RETURN_ID"     ,
                                                    "RB.RETURN_ID"};
        attributes = (Map<String, Object>) t;
        getResultes(tables, fields, showFinesJoins, "");
        Map<String, Object> bookResult = new HashMap<>();
        try {
           for (int i = 1; i <= metaData.getColumnCount(); i++) {
               columnsNames.add(metaData.getColumnName(i));
               java.lang.System.out.println(metaData.getColumnName(i));
           }
           bookResult.put("coulmnsNames", columnsNames);
        } catch (SQLException e) {
        }
        bookResult.put("coulmnsData", coulmnsData);
        message = new Message(Message.bookSearch, bookResult);


        return message;
    }

    @Override
    public Message search(String by, Object For) {
        // TODO Implement this method
        return null;
    }


    @Override
    public Message search(String by, List For) {
        // TODO Implement this method
        return null;
    }

    @Override
    public Message search(String[] by, List For) {
        // TODO Implement this method
        return null;
    }
}
