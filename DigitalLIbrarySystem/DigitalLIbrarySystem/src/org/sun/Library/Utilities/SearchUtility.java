package org.sun.Library.Utilities;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import org.sun.Library.Bean.BookSpec;
import org.sun.Library.Bean.Message;
import org.sun.Library.Bean.PersonInfo;
import org.sun.Library.Controler.Member.Student;

public class SearchUtility {
    private ResultSet resultSet;
    private Message message;

    private Map<Object, Object> resulte;

    public SearchUtility(Message message) {
        this.message = message;
        resulte = new HashMap<Object, Object>();
    }

    public Message getBooks() {
        try {
            StringBuffer buffer = new StringBuffer();
            resultSet = (ResultSet) this.message.getMessage();
            if (resultSet != null) {
                int count = 0;

                buffer.append("id ").append("\t").append("title").append("\n");
                while (resultSet.next()) {
                    count++;
                    java.lang.System.out.println("You  found  data counter  " + count);
                    BookSpec spec = new BookSpec();
                    spec.setIsbn(resultSet.getString("BOOK_ISBN"));
                    spec.setTitle(resultSet.getString("BOOK_TITLE"));
                    spec.setPrice(resultSet.getString("PRICE"));
                    spec.setPublishDate(resultSet.getString("PUBLISH_DATE"));
                    resulte.put(resultSet.getInt("BOOK_ID"), spec);
                    buffer.append(resultSet.getInt("BOOK_ID")).append("\t").append(spec.getTitle()).append("\n");
                }
                java.lang.System.out.println(buffer);
                this.message = new Message(Message.bookSearch, resulte);
               resultSet.close();
            } else {
                java.lang.System.out.println("You not found any data");
                this.message = new Message(Message.bookSearch, null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An Error  IN ResultSet Object In  getBooks Method   in SearchUtility \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            this.message = new Message(Message.Error, null);


        } catch (Exception e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An Error IN getBooks Method   in SearchUtility \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            this.message = new Message(Message.Error, null);
        }

        return this.message;

    }
    public Message getStudents() {
        try {
            StringBuffer buffer = new StringBuffer();
            resultSet = (ResultSet) this.message.getMessage();
            if (resultSet != null) {
                int count = 0;

                buffer.append("id ").append("\t").append("name").append("\n");
                while (resultSet.next()) {
                    count++;
                    java.lang.System.out.println("You  found  data counter  " + count);
                    Student student=new Student();
                    PersonInfo info=new PersonInfo(); 
                    info.setId(resultSet.getString("STUDENT_ID"));
                    info.setName(resultSet.getString("STUDENT_NAME"));
                    info.setEmail(resultSet.getString("STUDENT_EMAIL"));
                   student.setNationalID(resultSet.getString("STUDENT_NATIONALID"));
                    student.setInfo(info);
                    resulte.put(info.getId(), student);
                    buffer.append(info.getId()).append("\t").append(info.getName()).append("\n");
                }
                java.lang.System.out.println(buffer);
                this.message = new Message(Message.studentSearch, resulte);
                resultSet.close();
            } else {
                java.lang.System.out.println("You not found any data");
                this.message = new Message(Message.studentSearch, null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An Error  IN ResultSet Object In  getStudents Method   in SearchUtility \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            this.message = new Message(Message.Error, null);


        } catch (Exception e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An Error IN getStudents Method   in SearchUtility \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            this.message = new Message(Message.Error, null);
        }

        return this.message;

    }

}
