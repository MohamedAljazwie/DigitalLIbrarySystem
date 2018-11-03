package org.sun.Library.Controler.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Interfaces.BookTransition;
import org.sun.Library.DataBase.JdbcConnection;


public class IssueBookTransition implements BookTransition {
    private Message message;
    private Savepoint  errorIssueBook;
    private Date date;
    private DateFormat oldFormate = new SimpleDateFormat("MM/dd/yyyy");
    private DateFormat newFormat=new SimpleDateFormat("dd-MMMM-yyyy" ,Locale.ENGLISH);
    @Override
    public Message execute(Object t) {
        IssueBook issueBook = (IssueBook) t;
        return issue(issueBook);
    }

    private synchronized Message issue(IssueBook issue) {
        if (!borrowedMorThan3Books(issue)) {
            if (!borrowedBookPreviously(issue))
                issueBook(issue);
            else
                message =
                    new Message(Message.Error,
                                "Sorry Dear You Can not Issue This BooK Becouse  This Book was been Issued Previously");
        } else
            message =
                new Message(Message.Error,
                            "Sorry Dear You Can not Issue This BooK Please Return The Issued Book Firstly");


        return message;
    }

    private void issueBook(IssueBook issue) {
        try {

            String title;
            Object[] attribute = { issue.getBook().getId() };
            System.out.println(" ISBN    " + issue.getBook().getBookSpec().getIsbn() + "\n ID    " +
                               issue.getBook().getId());

            String table = "BOOK";
            String[] getFieldes = { "BOOK_TITLE", "QUANTITY", "AVAILABLE_BOOKS", "BORROWED_BOOKS" };
            String[] fieldesCondition = { "BOOK_ID" };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();
            ResultSet resultSet = jdbcConnection.check(table, getFieldes, fieldesCondition, attribute);
            if (resultSet != null && resultSet.next()) {
                title = resultSet.getString("BOOK_TITLE");
                Integer quantity = resultSet.getInt("QUANTITY");
                Integer avaliableBook = resultSet.getInt("AVAILABLE_BOOKS");
                Integer borrowedBook = resultSet.getInt("BORROWED_BOOKS");
                if (avaliableBook <= 1)
                    message =
                        new Message(Message.Error,
                                    "Sorry Dear You Can not Issue this Book to Student Becouse You Have Only ONE COPY");
                else {
                    resultSet.close();
                    errorIssueBook=jdbcConnection.getConnection().setSavepoint("errorIssueBook");
                    avaliableBook = avaliableBook - 1;
                    borrowedBook = borrowedBook + 1;
                    Object[] fieldesValues = { quantity, avaliableBook, borrowedBook };
                    String[] updateFieldes = { "QUANTITY", "AVAILABLE_BOOKS", "BORROWED_BOOKS" };
                    boolean state =
                        jdbcConnection.update(table, updateFieldes, fieldesValues, fieldesCondition, attribute);
                    if (state) {
//                        jdbcConnection.getConnection().commit();
                        date=oldFormate.parse(issue.getIssueDate());
                        issue.setIssueDate(newFormat.format(date));
                        date=oldFormate.parse(issue.getReturnDate());
                        issue.setReturnDate(newFormat.format(date));
                        Object[] attributes = {
                            issue.getStudent().getInfo().getId(), issue.getBook().getId(), issue.getIssueDate(),
                            issue.getReturnDate(), issue.getNots(), "issued"
                        };
                        String tableName = "ISSUES_BOOK";
                        String[] fieldes = { "STUDENT_ID", "BOOK_ID", "ISSUE_DATE", "RETURN_DATE", "NOTES", "STATUS" };


                        resultSet = jdbcConnection.Insert(tableName, fieldes, attributes);
                        if (resultSet != null && resultSet.next()) {
                            jdbcConnection.getConnection().commit();
                            message =
                                new Message(Message.IssueBook,
                                            "Congratulation You issued the " + title + " Book to the Student  " +
                                            issue.getStudent().getNationalID());
                            resultSet.close();
                        } else {
                            jdbcConnection.getConnection().rollback(errorIssueBook);
                            message = new Message(Message.Error, "Sorry No BooK wase Issued");
                        }
                    } else {
                        jdbcConnection.getConnection().rollback(errorIssueBook);
                        message = new Message(Message.Error, "Sorry No BooK wase Issued");
                    }
                }
            } else
                message = new Message(Message.Error, "Sorry No BooK wase Issued");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("You Have An Error  IN ResultSet Object In  issue Method   in IssueBookTransition \n\n" +
                               "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No BooK wase Issued");


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("You Have An Error IN issue Method   in IssueBookTransition \n\n" +
                               "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No BooK wase Issued");
        }
    }

    private boolean borrowedMorThan3Books(IssueBook issueBook) {

        boolean state = false;
        try {
            Object[] attribute = { issueBook.getStudent().getInfo().getId(), "issued" };

            String table = "ISSUES_BOOK";
            String[] getFieldes = { "COUNT(BOOK_ID)" };
            String[] fieldesCondition = { "STUDENT_ID", "STATUS" };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();
            ResultSet resultSet = jdbcConnection.check(table, getFieldes, fieldesCondition, attribute);
            if (resultSet != null && resultSet.next()) {
                int count = resultSet.getInt("COUNT(BOOK_ID)");
                System.out.println(" Count Issued  Book is   " + count);
                if (count >= 3)
                    state = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("You Have An Error  IN ResultSet Object In  borrowedMorThan3Books Method   in IssueBookTransition \n\n" +
                               "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No BooK wase Issued");


        }
        return state;
    }

    private boolean borrowedBookPreviously(IssueBook issueBook) {
        boolean state = false;
        try {
            Object[] attribute = { issueBook.getStudent().getInfo().getId(), "issued" };
            String bookID = issueBook.getBook().getId();
            String table = "ISSUES_BOOK";
            String[] getFieldes = { "BOOK_ID" };
            String[] fieldesCondition = { "STUDENT_ID", "STATUS" };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();
            ResultSet resultSet = jdbcConnection.check(table, getFieldes, fieldesCondition, attribute);
            if (resultSet != null && resultSet.next()) {
                String previousID = resultSet.getString("BOOK_ID");
                System.out.println(" previous  Issued  BookidID  is   " + previousID);
                if (previousID.equals(bookID))
                    state = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("You Have An Error  IN ResultSet Object In  borrowedMorThan3Books Method   in IssueBookTransition \n\n" +
                               "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No BooK wase Issued");


        }
        return state;
    }
}
