package org.sun.Library.System;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

import org.sun.Library.Bean.BookSpec;
import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Book.Book;
import org.sun.Library.Controler.Book.Category;
import org.sun.Library.Controler.Interfaces.Registration;
import org.sun.Library.DataBase.JdbcConnection;

public class BookRegister implements  Registration{
    private Message message;
    private Date date;
    private DateFormat oldFormate = new SimpleDateFormat("MM/dd/YYYY");
    private DateFormat newFormat=new SimpleDateFormat("dd-MMMM-YYYY" ,Locale.ENGLISH);
    private Savepoint addBook;
    @Override
    public Message register(Object t) {
        Book book=(Book)t;
        return addBook(book);
    }
    private Message addBook(Book book) {
        try {
            BookSpec spec = book.getBookSpec();
            int authorID = (Integer)spec.getAuthor().getInfo().getId();
            int publisherid =(Integer) spec.getPublisher().getInfo().getId();
            Category category = book.getCategory();
            int available = book.getCopies();
            int borroedBook = book.getCopies() - available;
              date=oldFormate.parse(spec.getPublishDate());
            spec.setPublishDate(newFormat.format(date));
            Object[] attributes = {
                spec.getIsbn(), spec.getTitle(), spec.getSubject(), spec.getPrice(), category.getId(),
                spec.getPublishDate(), book.getCopies(), available, borroedBook
            };
            String tableName = "BOOK";
            String[] fieldes = {
                "BOOK_ISBN", "BOOK_TITLE", "SUBJECT", "PRICE", "CATEGORY_ID", "PUBLISH_DATE", "QUANTITY",
                "AVAILABLE_BOOKS", "BORROWED_BOOKS"
            };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();
            addBook=jdbcConnection.getConnection().setSavepoint("addBook");
            ResultSet insert = jdbcConnection.Insert(tableName, fieldes, attributes);
            if (insert != null && insert.next()) {

                int bookID = (int) insert.getInt(1);
                java.lang.System.out.println("book id is  " + insert.getInt(1));
                insert.close();
                boolean state1 = addAuthor(bookID, authorID);
                boolean state2 = addPublisher(bookID, publisherid);
                if (state1 && state2) {
                    jdbcConnection.getConnection().commit();
                    message = new Message(Message.addBook, "Congratulation your  Book Registered Successfully");
                } else {
                     jdbcConnection.getConnection().rollback(addBook);
                    message = new Message(Message.Error, "Sorry No Book Registered");
                }
            }
            else {
                                insert.close();
                                jdbcConnection.getConnection().rollback(addBook);
                                message = new Message(Message.Error, "Sorry No Book Registered");
                            }
        } catch (NumberFormatException e) {
            java.lang.System.out.println("\tYou Have An NumberFormatException Error IN add Method   in BookAuthorRegister \n\n");
            e.printStackTrace();
            java.lang.System.out.println("\n\n" + "the Message   is     " + e.getMessage() + "\n\n" + e.toString());

        } catch (Exception e) {
            java.lang.System.out.println("\tYou Have An Error IN add Method   in BookAuthorRegister \n\n");
            e.printStackTrace();
             java.lang.System.out.println("\n\n" + "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No Book Registered");
        }
        return message;
    }

    private boolean addAuthor(int bookID, int authorID) {
        boolean state = false;
        try {
            String tableName = "BOOK_AUTHOR";
            String[] fieldes = { "BOOK_ID", "AUTHOR_ID" };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();

            Object[] attributes = { bookID, authorID };
            ResultSet insert = jdbcConnection.Insert(tableName, fieldes, attributes);
            try {
                if (insert!=null && insert.next()) {
                    state = true;
                    insert.close();
                }
                else
                {
                    insert.close();
                jdbcConnection.getConnection().rollback(addBook);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                 java.lang.System.out.println("You Have An Error  IN ResultSet Object In  addAuthor Method   in BookRegister \n\n" +
                                   "the Message   is     " + e.getMessage() + "\n\n" + e.toString());

            } //end catch

        } catch (Exception e) {
             java.lang.System.out.println("\tYou Have An Error IN addAuthor Method   in BookRegister \n\n");
            e.printStackTrace();
             java.lang.System.out.println("\n\n" + "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No Book Registered");
        }
        return state;
    }

    private boolean addPublisher(int bookID, int publisherID) {
        boolean state = false;
        try {
            String tableName = "BOOK_PUBLISHER";
            String[] fieldes = { "BOOK_ID", "PUBLISHER_ID" };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();

            Object[] attributes = { bookID, publisherID };
            ResultSet insert = jdbcConnection.Insert(tableName, fieldes, attributes);
            try {
                if (insert!=null &&  insert.next()) {
                    state = true;
                    insert.close();
                }
                else 
                {
                    insert.close();
                jdbcConnection.getConnection().rollback(addBook);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                 java.lang.System.out.println("You Have An Error  IN ResultSet Object In  addPublisher Method   in BookRegister \n\n" +
                                   "the Message   is     " + e.getMessage() + "\n\n" + e.toString());

            } //end catch

        } catch (Exception e) {
             java.lang.System.out.println("\tYou Have An Error IN addPublisher Method   in BookRegister \n\n");
            e.printStackTrace();
             java.lang.System.out.println("\n\n" + "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No Book Registered");
        }
        return state;
    }

    
}
