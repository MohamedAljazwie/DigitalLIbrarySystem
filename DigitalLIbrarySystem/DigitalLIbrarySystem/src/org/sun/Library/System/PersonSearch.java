package org.sun.Library.System;

import java.util.List;
import java.sql.ResultSet;

import java.sql.ResultSetMetaData;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.sun.Library.Bean.Message;
import org.sun.Library.Bean.PersonInfo;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.DataBase.JdbcConnection;

public class PersonSearch extends AbstractSearch{
    private String [] tableNames={"PUBLISHER","AUTHOR","STUDENT"};
    private String[] personType={"Publisher","Author","Student"};

   public PersonSearch() {
     super();
       columnsNames.add(" Person ID ");
       columnsNames.add(" Person Name ");
       columnsNames.add(" Person Email ");
       columnsNames.add(" Person Address ");
//       columnsNames.add(" Person Phone ");
       columnsNames.add(" Person Type ");
     
       
   }
    @Override
    public Message search(Object t) {
      
        String [] tables={" STUDENT ST "};
        //," STUDENT_PHONE SP "   ," SP.PHONE_NUMBER "
        String[] fields={" ST.STUDENT_ID ", " ST.STUDENT_NAME "," ST.STUDENT_EMAIL ","   ST.STUDENT_ADDRESS "};
        String [] studentJoins={" ST.STUDENT_ID "," SP.STUDENT_ID "};
       getResultes(tables, fields,studentJoins, personType[2]);
        String [] authorstables={" AUTHOR AR"};
        //," AUTHOR_PHONE  AP"   ," AP.PHONE_NUMBER "
        String[] authorfields={" AR.AUTHOR_ID "," AR.AUTHOR_NAME "," AR.AUTHOR_EMAIL ","  AR.AUTHOR_ADDRESS "};
        String [] authorJoins={" AR.AUTHOR_ID "," AP.AUTHOR_ID "};
       getResultes(authorstables,authorfields,authorJoins, personType[1]);
        String [] publishertables={" PUBLISHER PR "};
        //," PUBLISHER_PHONE PP"  ," PP.PHONE_NUMBER "
        String[] publisherfields={" PR.PUBLISH_ID "," PR.PUBLISHER_NAME ","  PR.PUBLISHER_EMAIL ","  PR.PUBLISHER_ADDRESS "};
        String[] publisherJoins={" PR.PUBLISH_ID ","PP.PUBLISHER_ID"};
        getResultes(publishertables, publisherfields,publisherJoins, personType[0]);
        Map<String,Object> personResult=new HashMap<>();
        personResult.put("coulmnsNames", columnsNames);
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
    
    private void test() {
        try{
        jdbcConnection = JdbcConnection.getInstance();
            int type=0;
            for(String tableName : tableNames) {
        //                if(tableName.equals("STUDENT"))
        //                    columnsNames.add(1, "NATIONAL ID");
                  java.lang.System.out.println(" Table Name is   "+tableName);
                resultSet=jdbcConnection.search(tableName, null, "");
            if( resultSet!=null) {
                metaData=resultSet.getMetaData();
                while(resultSet.next())
                {
                    boolean state=true;
                   // data=new ArrayList();
                for(int i=1;i<=metaData.getColumnCount();i++) {
        //                    if(tableName.equals("STUDENT"))
        //                    {
        //                        if(i==2) {
        //                            i=3;
        //                            continue;
        //                        }
        //                    if(i>=6)
        //                    {
        //                        state=false;
        //                    break;
        //                    }
        //                    }
                  
                    data.add(resultSet.getObject(i));
                } // end for column count
                    if(state) {
                        data.add(personType[type]);
                       
                       coulmnsData.put(resultSet.getInt(1), data);
                        for(int i=0;i<data.size();i++)
                         java.lang.System.out.print(data.get(i)+" \t  ");
                        java.lang.System.out.println(" \n ");
                       data.clear();
                    }
                
                } // end while
               
                
            resultSet.close();
            } else {
                    java.lang.System.out.println("You not found any data");
                    message = new Message(Message.Search, null);
                }
                type++;
            } // end fo lop tables
            Map<String,Object> personResult=new HashMap<>();
            personResult.put("coulmnsNames", columnsNames);
            personResult.put("coulmnsData",coulmnsData);
            message=new Message(Message.personSearch, personResult);
        } catch(SQLException e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An SQLException IN search Method   in PrsonSearch \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, null);
        }
        catch (Exception e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An Error IN search Method   in PrsonSearch \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, null);
        }
    }
    
    private void getStudents() {
        try{
        String [] tables={" STUDENT "," STUDENT_PHONE "};
        String[] fields={" STUDENT_ID ", "STUDENT_NAME "," STUDENT_EMAIL ","	STUDENT_ADDRESS "," PHONE_NUMBER "};
        resultSet=jdbcConnection.search(tables, fields, null, null);
            if(resultSet!=null) {
                metaData=resultSet.getMetaData();
                while(resultSet.next()) {
                    for(int i=1;i<=metaData.getColumnCount();i++) {
                        data.add(resultSet.getObject(i));
                    }  // end for
                    data.add(personType[2]);
                    coulmnsData.put(resultSet.getInt(1), data);
                    java.lang.System.out.println(" \n ");
                    for(int i=0;i<data.size();i++)
                     java.lang.System.out.print(data.get(i)+" \t  ");
                    java.lang.System.out.println(" \n ");
                    data.clear();
                } // end while
            resultSet.close();
            } else {
                    java.lang.System.out.println("You not found any data");
                    message = new Message(Message.Search, null);
                }    
            
        } catch(SQLException e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An SQLException IN getStudents Method   in PrsonSearch \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            
        }
        catch (Exception e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An Error IN getStudents Method   in PrsonSearch \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            
        }
        
    }
    
    
    
    private void getAuthors() {
        try{
        String [] tables={" AUTHOR "," AUTHOR_PHONE "};
        String[] fields={" AUTHOR_ID "," AUTHOR_NAME "," AUTHOR_EMAIL ","  AUTHOR_ADDRESS "," PHONE_NUMBER "};
        resultSet=jdbcConnection.search(tables, fields, null, null);
            if(resultSet!=null) {
                metaData=resultSet.getMetaData();
                while(resultSet.next()) {
                    for(int i=1;i<=metaData.getColumnCount();i++) {
                        data.add(resultSet.getObject(i));
                    }
                    data.add(personType[1]);
                    coulmnsData.put(resultSet.getInt(1), data);
                    java.lang.System.out.println(" \n ");
                    for(int i=0;i<data.size();i++)
                     java.lang.System.out.print(data.get(i)+" \t  ");
                    java.lang.System.out.println(" \n ");
                    data.clear();
                }
            resultSet.close();
            } else {
                    java.lang.System.out.println("You not found any data");
                    message = new Message(Message.Search, null);
                }
        } catch(SQLException e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An SQLException IN getAuthors Method   in PrsonSearch \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            
        }
        catch (Exception e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An Error IN getAuthors Method   in PrsonSearch \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
     
        }
    }
    
    
    
    private void getPublishers() {
        try{
        String [] tables={" PUBLISHER "," PUBLISHER_PHONE "};
        String[] fields={" PUBLISH_ID "," PUBLISHER_NAME ","  PUBLISHER_EMAIL ","  PUBLISHER_ADDRESS "," PHONE_NUMBER "};
        resultSet=jdbcConnection.search(tables, fields, null, null);
            if(resultSet!=null) {
                metaData=resultSet.getMetaData();
                while(resultSet.next()) {
                    for(int i=1;i<=metaData.getColumnCount();i++) {
                        data.add(resultSet.getObject(i));
                    }
                    data.add(personType[0]);
                    coulmnsData.put(resultSet.getInt(1), data);
                    java.lang.System.out.println(" \n ");
                    for(int i=0;i<data.size();i++)
                     java.lang.System.out.print(data.get(i)+" \t  ");
                    java.lang.System.out.println(" \n ");
                    data.clear();
                }
            resultSet.close();
            } else {
                    java.lang.System.out.println("You not found any data");
                    message = new Message(Message.Search, null);
                }
        } catch(SQLException e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An SQLException IN getPublishers Method   in PrsonSearch \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            
        }
        catch (Exception e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An Error IN getPublishers Method   in PrsonSearch \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
     
        }
    }
    
    public static void main(String []a) {
        JdbcConnection jdbcConnection=JdbcConnection.getInstance();
        jdbcConnection.addConnection(jdbcConnection.connectToDataBase());
        PersonSearch personSearch=new PersonSearch();
        
        Message message=personSearch.search(null);
        Map<String,Object> results = (Map<String, Object>) message.getMessage();
        List<Object> coulmnNames = (List<Object>) results.get("coulmnsNames");
        java.lang.System.out.println(" \n ");
        for(int i=0;i<coulmnNames.size();i++)
        java.lang.System.out.print(coulmnNames.get(i)+" \t  ");
        java.lang.System.out.println(" \n ");
        Map<Integer,Object> coulmnsData = (Map<Integer, Object>) results.get("coulmnsData");
        Iterator iterator=coulmnsData.values().iterator();
        int whilecounter=0;
        while(iterator.hasNext()){
      whilecounter++;
            List<Object>data = (List<Object>)iterator.next();
          
            for(int i=0;i<data.size();i++)
             java.lang.System.out.print(data.get(i)+" \t  ");
            java.lang.System.out.println(" \n ");
            
        }
        java.lang.System.out.println(" \n whilecounter is "+whilecounter);
       
    }

}
   