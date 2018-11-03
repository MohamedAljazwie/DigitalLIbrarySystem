package org.sun.Library.System;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Interfaces.Search;

public class ReturnsBooksSearch extends AbstractSearch {
    public ReturnsBooksSearch() {
        super();
    }
    @Override
    public Message search(Object t) {
        String[] fields=
           {   " RE.RETURN_ID                   AS \" RETURN ID \" "                       ,
               " ST.STUDENT_NATIONALID  AS  \" STUDENT NATIONALID \" "  ,
               " ST.STUDENT_NAME            AS  \" SYUDENT NAME\"  "            ,
               " B.BOOK_ISBN                     AS   \" BOOK ISSBN \" "                ,
               " B.BOOK_TITLE                   AS  \"  BOOK TITLE \"  "                ,
               " RE.ISSUE_DATE                 AS  \"  ISSUE DATE \"  "                 ,
               " RE.RETURN_DATE             AS \"   RETURN DATE \"  "              ,
                "RE.RETURNED_DATE        AS  \" RETURNED DATE \"  "           ,
               "RE.NOTES                         AS \" NOTES\"  "
          };
        String[] tables=
        { " STUDENT ST "          ,
          " RETURN_BOOK RE " ,
          " BOOK B "
        };
        String[]issuesJoin={"RE.STUDENT_ID","ST.STUDENT_ID","RE.BOOK_ID","B.BOOK_ID"};
        attributes = (Map<String, Object>) t;
        getResultes(tables, fields, issuesJoin, "");
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
