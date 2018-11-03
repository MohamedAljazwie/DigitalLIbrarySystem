package org.sun.Library.System;

import org.sun.Library.Bean.Message;
import org.sun.Library.Bean.PersonInfo;
import org.sun.Library.Controler.Member.Author;
import org.sun.Library.Controler.Member.Person;
import org.sun.Library.DataBase.JdbcConnection;

import java.lang.System;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.Iterator;

public class AuthorRegister extends PersonRegistration {
    private Message message;
    private Author author;
    private PersonInfo info;

    public AuthorRegister() {

    }

    @Override
    public Message add(Person person) {
        try {
            author = (Author) person;
            info = author.getInfo();
            String[] attributes = { info.getName(), info.getEmail(), info.getAddress() };
            String tableName = "AUTHOR";
            String[] fieldes = { "AUTHOR_NAME", "AUTHOR_EMAIL", "AUTHOR_ADDRESS" };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();

            ResultSet insert = jdbcConnection.Insert(tableName, fieldes, attributes);
            if (insert!=null&& insert.next()) {
            
                int authorID =(int)insert.getInt(1);
               System.out.println("author id is  " + insert.getInt(1));             
                boolean state1 = addPhone(authorID);
                boolean state2 = addQulification(authorID);
                if (state1 && state2)
                    message = new Message(Message.addPerson, "Congratulation  The Author Add Succssfully");
                else
                    message = new Message(Message.Error, "Sorry No Author Registered");
            } else
                message = new Message(Message.Error, "Sorry No Author Registered");
        }  catch(NumberFormatException e)
            {
                System.out.println("\tYou Have An NumberFormatException Error IN add Method   in AuthorRegister \n\n");
                e.printStackTrace();
                System.out.println("\n\n" + "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
                
            }
         catch (Exception e) {
            System.out.println("\tYou Have An Error IN add Method   in AuthorRegister \n\n");
            e.printStackTrace();
            System.out.println("\n\n" + "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No Author Registered");
        }
        
        return message;

    }

    private boolean addPhone(Integer id) {
        boolean state = false;
        int count=0;
        try {
            String tableName = "AUTHOR_PHONE";
            String[] fieldes = { "AUTHOR_ID", "PHONE_NUMBER" };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();
            Iterator<String> iterator = info.getPhone().getNumber().iterator();
            while (iterator.hasNext()) {
                Object[] attributes = {id, iterator.next() };
                ResultSet insert = jdbcConnection.Insert(tableName, fieldes, attributes);
                try {
                    if (insert.next())
                    {
                     state=true;
                        count++;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("You Have An Error  IN ResultSet Object In  addPhone Method   in AuthorRegister \n\n" +
                                       "the Message   is     " + e.getMessage() + "\n\n" + e.toString());

                } //end catch
            } // end while
        } catch (Exception e) {
            System.out.println("\tYou Have An Error IN addPhone Method   in AuthorRegister \n\n");
            e.printStackTrace();
            System.out.println("\n\n" + "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No Author Registered");
        }
        
            System.out.println("\n\n" + "the Count   is     "+count);
        
        return state;
    }

    private boolean addQulification(Integer id) {
        boolean state = false;
        int count=0;
        try {
            String tableName = "QUALIFICATIONS";
            String[] fieldes = { "AUTHOR_ID", "QUALIFICATION" };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();
            Iterator<String> iterator = author.getQulefication().iterator();
            while (iterator.hasNext()) {
                Object[] attributes = { id, iterator.next() };
                ResultSet insert = jdbcConnection.Insert(tableName, fieldes, attributes);
                try {
                    if (insert.next())
                    {
                        state = true;
                    count++;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("You Have An Error  IN ResultSet Object In  addQulification Method   in AuthorRegister \n\n" +
                                       "the Message   is     " + e.getMessage() + "\n\n" + e.toString());

                } //end catch
            } // end while
        } catch (Exception e) {
            System.out.println("\tYou Have An Error IN addQulification Method   in AuthorRegister \n\n");
            e.printStackTrace();
            System.out.println("\n\n" + "the Message   is     " + e.getMessage() + "\n\n" + e.toString());

        }
      
            System.out.println("\n\n" + "the Count   is     "+count);
        
        return state;
    }
}
