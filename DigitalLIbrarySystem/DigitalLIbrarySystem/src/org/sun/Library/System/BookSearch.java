package org.sun.Library.System;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Interfaces.Search;

public class BookSearch extends AbstractSearch {
    public BookSearch() {
        super();
    }
    @Override
    public Message search(Object t) {
        String[] tables = { " CATEGORY C ", " BOOK B " };
        String[] fields = {
            "B.BOOK_ID  AS \"BOOK ID\" "                        , 
            "B.BOOK_ISBN AS \"BOOK NAME\""                , 
            "B.BOOK_TITLE AS \"BOOK TITLE\""               ,
            "B.PRICE      AS \"  PRICE  \""                          ,
            "B.PUBLISH_DATE AS \"PUBLISH DATE\""        ,
            "C.CATEGORY_NAME AS \"CATEGORY  NAME\" "
        };
        String[] bookJoins = { "B.CATEGORY_ID", "C.CATEGORY_ID" };
        attributes = (Map<String, Object>) t;

        getResultes(tables, fields, bookJoins, "");
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
