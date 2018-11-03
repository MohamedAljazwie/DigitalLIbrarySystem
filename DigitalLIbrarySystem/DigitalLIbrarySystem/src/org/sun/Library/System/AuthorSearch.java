package org.sun.Library.System;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Interfaces.Search;

public class AuthorSearch extends  AbstractSearch{
    @Override
    public Message search(Object t) {
        
        String [] authorstables={"QUALIFICATIONS QS"," AUTHOR AR"};
     //," AUTHOR_PHONE  AP"
        String[] authorfields={" AR.AUTHOR_ID "," AR.AUTHOR_NAME "," AR.AUTHOR_EMAIL ","  AR.AUTHOR_ADDRESS ","QS.QUALIFICATION "};
        String [] authorJoins={" QS.AUTHOR_ID "," AR.AUTHOR_ID "};
        getResultes(authorstables,authorfields,authorJoins, "");
        Map<String,Object> personResult=new HashMap<>();
        try {
            for (int i = 1; i <= metaData.getColumnCount(); i++)
            {
                columnsNames.add(metaData.getColumnName(i));
            java.lang.System.out.println(metaData.getColumnName(i));
            }
                personResult.put("coulmnsNames", columnsNames);
        } catch (SQLException e) {
        }
        personResult.put("coulmnsData",coulmnsData);
        message=new Message(Message.personSearch, personResult);

        
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
