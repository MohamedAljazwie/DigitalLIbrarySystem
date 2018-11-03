package org.sun.Library.System;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Interfaces.Search;

public class PublisherSearch extends AbstractSearch{
    private Map<String,Object> attributes;
    private Map<String,Object>dynamicAttributes;
    public PublisherSearch() {
        super();
        attributes=new HashMap<>();
        dynamicAttributes=new HashMap<>();
    }
    @Override
    public Message search(Object t) {
        attributes = (Map<String, Object>) t;
        String type = (String) attributes.get("type");
        Object value=attributes.get("value");
        
        String [] publishertables={" PUBLISHER PR "};
        //," PUBLISHER_PHONE PP"  ," PP.PHONE_NUMBER "
        String[] publisherfields={" PR.PUBLISH_ID "," PR.PUBLISHER_NAME ","  PR.PUBLISHER_EMAIL ","  PR.PUBLISHER_ADDRESS "};
        String[] publisherJoins={" PR.PUBLISH_ID ","PP.PUBLISHER_ID"};
        getResultes(publishertables, publisherfields,publisherJoins,"");
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
