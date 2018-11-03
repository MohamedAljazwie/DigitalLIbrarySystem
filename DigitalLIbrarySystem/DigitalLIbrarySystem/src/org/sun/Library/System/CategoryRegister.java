package org.sun.Library.System;


import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Book.Category;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.DataBase.JdbcConnection;

import java.lang.System;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.sun.Library.Controler.Interfaces.Registration;

public class CategoryRegister implements Registration {
    private Message message;

    @Override
    public Message register(Object t) {
        Category category=(Category)t;
        return addCategory(category);
    }
    private Message addCategory(Category category) {
            try {
        Object[] attributes = { category.getName(), category.getId() };
        String tableName = "CATEGORY";
        String[] fieldes = { "CATEGORY_NAME", "SUPER_CATEGORY" };
        JdbcConnection jdbcConnection = JdbcConnection.getInstance();
        
            ResultSet insert = jdbcConnection.Insert(tableName, fieldes, attributes);
        
            if (insert.next()) {
                message = new Message(Message.addCategory, "Congratulation  The Category Add Succssfully");
            } else
                message = new Message(Message.Error, "Sorry No Category Registered");
        } catch (SQLException e) {
            e.printStackTrace();
                System.out.println("You Have An Error  IN ResultSet Object In  addCategory Method   in CategoryRegister \n\n" +
                                   "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
                message = new Message(Message.Error, "Sorry No Category Registered");
            
                
        }catch (Exception e) {
        e.printStackTrace();
            System.out.println("You Have An Error IN addCategory Method   in CategoryRegister \n\n" +
                               "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No Category Registered");
        }
        return message;
    }

}
