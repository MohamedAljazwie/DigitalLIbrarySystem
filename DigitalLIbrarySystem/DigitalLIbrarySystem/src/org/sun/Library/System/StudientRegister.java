package org.sun.Library.System;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Iterator;

import org.sun.Library.Bean.Message;
import org.sun.Library.Bean.PersonInfo;

import java.lang.System;

import org.sun.Library.Controler.Member.Person;
import org.sun.Library.Controler.Member.Student;
import org.sun.Library.DataBase.JdbcConnection;

public class StudientRegister extends PersonRegistration {
    private Message message;
    private Student student;
    private PersonInfo info;

    public StudientRegister() {

    }

    private Message addStudient(Student studient) {
        return null;
    }

    @Override
    public Message add(Person person) {
        try {
            student = (Student) person;
            info = student.getInfo();
            Object[] attributes = {
                student.getNationalID(), info.getName(), info.getEmail(), info.getAddress(),
                student.getAccess().getUserName(), student.getAccess().getPassword(), student.getQuestion(),
                student.getAnswer()
            };
            String tableName = "STUDENT";
            String[] fieldes = {
                "STUDENT_NATIONALID", "STUDENT_NAME", "STUDENT_EMAIL", "STUDENT_ADDRESS", "USER_NAME", "PASSWORD",
                "QUESTION", "ANSWER"
            };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();

            ResultSet insert = jdbcConnection.Insert(tableName, fieldes, attributes);
            if (insert != null && insert.next()) {

                int authorID = (int) insert.getInt(1);
                System.out.println("author id is  " + insert.getInt(1));
                boolean state1 = addPhone(authorID);
                if (state1)
                    message = new Message(Message.addPerson, "Congratulation  The Student Add Succssfully");
                else
                    message = new Message(Message.Error, "Sorry No Student Registered");
            } else
                message = new Message(Message.Error, "Sorry No Student Registered");
        } catch (NumberFormatException e) {
            System.out.println("\tYou Have An NumberFormatException Error IN add Method   in StudientRegister \n\n");
            e.printStackTrace();
            System.out.println("\n\n" + "the Message   is     " + e.getMessage() + "\n\n" + e.toString());

        } catch (Exception e) {
            System.out.println("\tYou Have An Error IN add Method   in StudientRegister \n\n");
            e.printStackTrace();
            System.out.println("\n\n" + "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No Student Registered");
        }

        return message;

    }

    private boolean addPhone(Integer id) {
        boolean state = false;
        try {
            String tableName = "STUDENT_PHONE";
            String[] fieldes = { "STUDENT_ID", "PHONE_NUMBER" };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();
            Iterator<String> iterator = info.getPhone().getNumber().iterator();
            while (iterator.hasNext()) {
                Object[] attributes = { id, iterator.next() };
                ResultSet insert = jdbcConnection.Insert(tableName, fieldes, attributes);
                try {
                    if (insert.next())
                        state = true;
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
        return state;
    }

}
