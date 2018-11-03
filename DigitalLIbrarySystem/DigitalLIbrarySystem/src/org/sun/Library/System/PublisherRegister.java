package org.sun.Library.System;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Iterator;

import org.sun.Library.Bean.Message;
import org.sun.Library.Bean.PersonInfo;
import org.sun.Library.Controler.Member.Person;
import org.sun.Library.Controler.Member.Publisher;
import org.sun.Library.DataBase.JdbcConnection;
import java.lang.System;
public class PublisherRegister extends PersonRegistration {
    private Message message;
    private Publisher publisher;
    private PersonInfo info;
    public PublisherRegister() {
        
    }
    

    @Override
    public Message add(Person person) {
        try{
        publisher = (Publisher) person;
        info=publisher.getInfo();
        String[] attributes = { info.getName(), info.getEmail(), info.getAddress() };
        String tableName = "PUBLISHER";
        String[] fieldes = { "PUBLISHER_NAME", "PUBLISHER_EMAIL", "PUBLISHER_ADDRESS" };
        JdbcConnection jdbcConnection = JdbcConnection.getInstance();

        ResultSet insert = jdbcConnection.Insert(tableName, fieldes, attributes);
        if (insert!=null&& insert.next()) {
        
            int publisherID =(int)insert.getInt(1);
           System.out.println("publisher id is  " + insert.getInt(1));             
            boolean state1 = addPhone(publisherID);
            if (state1 )
                message = new Message(Message.addPerson, "Congratulation  The Author Add Succssfully");
            else
                message = new Message(Message.Error, "Sorry No Publisher Registered");
        } else
            message = new Message(Message.Error, "Sorry No Author Registered");
        }  catch(NumberFormatException e)
        {
            System.out.println("\tYou Have An NumberFormatException Error IN add Method   in PublisherRegister \n\n");
            e.printStackTrace();
            System.out.println("\n\n" + "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            
        }
        catch (Exception e) {
        System.out.println("\tYou Have An Error IN add Method   in PublisherRegister \n\n");
        e.printStackTrace();
        System.out.println("\n\n" + "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
        message = new Message(Message.Error, "Sorry No Publisher Registered");
        }
        
        return message;

        }

        private boolean addPhone(Integer id) {
        boolean state = false;
        int count =0;
        try {
        String tableName = "PUBLISHER_PHONE";
        String[] fieldes = { "PUBLISHER_ID", "PHONE_NUMBER" };
        JdbcConnection jdbcConnection = JdbcConnection.getInstance();
        Iterator<String> iterator =info.getPhone().getNumber().iterator();
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
                System.out.println("You Have An Error  IN ResultSet Object In  addPhone Method   in PublisherRegister \n\n" +
                                   "the Message   is     " + e.getMessage() + "\n\n" + e.toString());

            } //end catch
        } // end while
        } catch (Exception e) {
        System.out.println("\tYou Have An Error IN addPhone Method   in PublisherRegister \n\n");
        e.printStackTrace();
        System.out.println("\n\n" + "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
        message = new Message(Message.Error, "Sorry No Author Registered");
        }
      
            System.out.println("\n\n" + "the Count   is     "+count);
        return state;
        }

}
