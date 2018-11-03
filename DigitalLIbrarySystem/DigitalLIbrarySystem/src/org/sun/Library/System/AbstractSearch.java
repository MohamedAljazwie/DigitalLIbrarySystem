package org.sun.Library.System;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sun.Library.Bean.Message;
import org.sun.Library.Bean.PersonInfo;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.DataBase.JdbcConnection;

public abstract class AbstractSearch implements Search {
    protected JdbcConnection jdbcConnection;
    protected List<Object> columnsNames;
    protected Map<Integer, Object> coulmnsData;
    protected List<Object> data;
    protected PersonInfo personInfo;
    protected ResultSet resultSet;
    protected ResultSetMetaData metaData;
    protected Message message;
    protected Map<String, Object> attributes;
    protected String[] by;
    protected List<Object> For;
    protected String[] op;
    protected String[] sep;

    protected AbstractSearch() {
        by = new String[] { };
        For = new ArrayList<>();
        op = new String[] { };
        sep = new String[] { };
        columnsNames = new ArrayList<>();
        data = new ArrayList<>();
        coulmnsData = new HashMap<>();
        attributes = new HashMap<>();
        jdbcConnection = JdbcConnection.getInstance();
        personInfo = new PersonInfo();
    }

    protected void getResultes(String[] tables, String[] fields, String[] joinCondition, String type) {
        try {
            int whileCounter = 0;
            int forLoop = 0;
            int totalloop = 0;
            operationCondtions();
            resultSet = jdbcConnection.search(tables, fields, joinCondition, by, For, op, sep);
            returnResulte(resultSet, type);
        } catch (Exception e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An Error IN getResultes Method   in AbstractSearch \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());

        }

    }


    protected void getResultes(String[] tables, String[] fields, String[] joinCondition1, String[] joinCondition2,
                               String type) {
        try {
            int whileCounter = 0;
            int forLoop = 0;
            int totalloop = 0;
            operationCondtions();
            resultSet = jdbcConnection.search(tables, fields, joinCondition1, joinCondition2, null, null);
            returnResulte(resultSet, type);

        } catch (Exception e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An Error IN getResultes Method   in AbstractSearch \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());

        }

    }

    private void operationCondtions() {
        List<String> byCondition = ((List<String>) attributes.get("byConditions"));
        if (byCondition != null && byCondition.size() > 0) {
            by = new String[byCondition.size()];
            for (int i = 0; i < byCondition.size(); i++)
                by[i] = byCondition.get(i);
        }
        List<Object> forValues = ((List<Object>) attributes.get("foValues"));
        if (forValues != null && forValues.size() > 0) {
            for (int i = 0; i < forValues.size(); i++)
                For.add(forValues.get(i));
        }
        List<String> operators = ((List<String>) attributes.get("operators"));
        if (operators != null && operators.size() > 0) {
            op = new String[operators.size()];
            for (int i = 0; i < operators.size(); i++)
                op[i] = operators.get(i);
        }
        List<String> seperators = ((List<String>) attributes.get("seperators"));
        if (seperators != null && seperators.size() > 0) {
            sep = new String[seperators.size()];
            for (int i = 0; i < seperators.size(); i++)
                sep[i] = seperators.get(i);
        }
    }

    private void returnResulte(ResultSet resultSet, String type) {
        try {
            int whileCounter = 0;
            int forLoop = 0;
            int totalloop = 0;
            if (resultSet != null) {
                metaData = resultSet.getMetaData();
                while (resultSet.next()) {
                    data = new ArrayList<>();
                                    whileCounter++;
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        data.add(resultSet.getObject(i));
                                            forLoop++;
                                            totalloop++;
                    } // end for
                     java.lang.System.out.println("  \n forLoop  is   "+forLoop);
                    //  forLoop=0;
                    if (type != null && !type.equals(""))
                        data.add(type);
                    coulmnsData.put(resultSet.getInt(1), data);
                                                java.lang.System.out.println(" \n ");
                                                for(int i=0;i<data.size();i++)
                                                 java.lang.System.out.print(data.get(i)+" \t  ");
                                                java.lang.System.out.println(" \n ");
                     //data.clear();
                } // end while
                   java.lang.System.out.println("  \n totalloop  is   "+totalloop);
                java.lang.System.out.println("  \n whileCounter  is   "+whileCounter);
                // resultSet.close();
            } else {
                java.lang.System.out.println("You not found any data");
                message = new Message(Message.Search, null);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An SQLException IN returnResulte Method   in AbstractSearch \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());

        } catch (Exception e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An Error IN returnResulte Method   in AbstractSearch \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());

        }

    }
}
