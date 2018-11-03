package org.sun.Library.Controler.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import org.sun.Library.Bean.BookSpec;
import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Interfaces.BookTransition;
import org.sun.Library.DataBase.JdbcConnection;

public class ReturnBookTransition implements BookTransition {
    private Message message;
    private Savepoint errorReturnBook;
    private JdbcConnection jdbcConnection = JdbcConnection.getInstance();
    private Date date;
    private Date fromDate;
    private Date toDate;
    private DateFormat oldFormate = new SimpleDateFormat("MM/dd/yyyy");
    private DateFormat newFormat = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
    private String title;
    private String price;

    @Override
    public Message execute(Object t) {
        ReturnBook returnBook = (ReturnBook) t;
        return returnBook(returnBook);
    }

    public ReturnBookTransition() {

    }

    private Message returnBook(ReturnBook returnBook) {
        try {

            //            date = oldFormate.parse(returnBook.getIssueDate());
            //            returnBook.setIssueDate(newFormat.format(date));
            //            date = oldFormate.parse(returnBook.getReturnDate());
            //            returnBook.setReturnDate(newFormat.format(date));
            date = oldFormate.parse(returnBook.getReturnedDate());
            returnBook.setReturnedDate(newFormat.format(date));
            Object[] attributes = {
                returnBook.getStudent().getInfo().getId(), returnBook.getBook().getId(), returnBook.getIssueDate(),
                returnBook.getReturnDate(), returnBook.getReturnedDate(), returnBook.getNots()
            };
            String title = returnBook.getBook().getBookSpec().getTitle();
            String tableName = "RETURN_BOOK";
            String[] fieldes = { "STUDENT_ID", "BOOK_ID", "ISSUE_DATE", "RETURN_DATE", "RETURNED_DATE", "NOTES" };
            errorReturnBook = jdbcConnection.getConnection().setSavepoint("errorReturnBook");
            ResultSet resultSet = jdbcConnection.Insert(tableName, fieldes, attributes);
            if (resultSet != null && resultSet.next()) {
                //                jdbcConnection.getConnection().commit();

                if (changeIssueBookStatus(returnBook)) {
                    if (changeBookQuantities(returnBook)) {
                     String returnedID = String.valueOf(resultSet.getInt(1));
                        FINE fine = new FINE();
                         fine.setFineDate(returnBook.getReturnedDate());
                      String cost=calcolateFine(returnBook.getReturnDate(),returnBook.getReturnedDate())+"$";
                      returnBook.setReturnID(returnedID);
                        fine.setCost(cost);
                        fine.setReturnBook(returnBook);
                        BookSpec spec = new BookSpec();
                        
                        spec.setPrice(price);
                        spec.setTitle(title);
                        
                        String totalCost=getTotalCost(cost, price)+"$";
                        fine.setTotalCost(totalCost);
                        Map<String, Object> dataMessage = new HashMap<>();
                        dataMessage.put(Message.Fine,fine);
                        dataMessage.put( Message.Spec,spec);
                        Message fineMessage =
                            new Message("Congratulation You return the " + title + "  Book from the Student  " +
                                        returnBook.getStudent().getNationalID(),
                                        dataMessage);
                        message = new Message(Message.ReturnBook, fineMessage);
                    } else {
                        message = new Message(Message.Error, "Sorry No BooK wase Returned");
                    }
                } else {
                    message = new Message(Message.Error, "Sorry No BooK wase Returned");

                }
                resultSet.close();
            } else {
                jdbcConnection.getConnection().rollback(errorReturnBook);
                message = new Message(Message.Error, "Sorry No BooK wase Returned");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("You Have An Error  IN ResultSet Object In  returnBook Method   in ReturnBookTransition \n\n" +
                               "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No BooK wase Returned");
            try {
                jdbcConnection.getConnection().rollback(errorReturnBook);
            } catch (SQLException f) {
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("You Have An Error IN returnBook Method   in ReturnBookTransition \n\n" +
                               "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No BooK wase Returned");

            try {
                jdbcConnection.getConnection().rollback(errorReturnBook);
            } catch (SQLException f) {
            }
        }
        return message;
    }

    private boolean changeIssueBookStatus(ReturnBook returnBook) {
        boolean state = false;
        try {
            String table = "ISSUES_BOOK";
            String[] updateFieldes = { "STATUS" };
            Object[] fieldesValues = { "returned" };
            String[] fieldesCondition = { "STUDENT_ID", "BOOK_ID", "STATUS" };
            Object[] attribute = { returnBook.getStudent().getInfo().getId(), returnBook.getBook().getId(), "issued" };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();
            state = jdbcConnection.update(table, updateFieldes, fieldesValues, fieldesCondition, attribute);
            if (!state)
                jdbcConnection.getConnection().rollback(errorReturnBook);
            //                jdbcConnection.getConnection().commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("You Have An Error IN changeIssueBookStatus Method   in ReturnBookTransition \n\n" +
                               "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No BooK wase Returned");
        }
        return state;
    }

    private boolean changeBookQuantities(ReturnBook returnBook) {
        boolean state = false;
        try {

            Object[] attribute = { returnBook.getBook().getId() };
            String table = "BOOK";
            String[] getFieldes = { "PRICE", "BOOK_TITLE", "QUANTITY", "AVAILABLE_BOOKS", "BORROWED_BOOKS" };
            String[] fieldesCondition = { "BOOK_ID" };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();
            ResultSet resultSet = jdbcConnection.check(table, getFieldes, fieldesCondition, attribute);
            if (resultSet != null && resultSet.next()) {
                title = resultSet.getString("BOOK_TITLE");
                price = resultSet.getString("PRICE");
                Integer quantity = resultSet.getInt("QUANTITY");
                Integer avaliableBook = resultSet.getInt("AVAILABLE_BOOKS");
                Integer borrowedBook = resultSet.getInt("BORROWED_BOOKS");

                resultSet.close();
                avaliableBook = avaliableBook + 1;
                borrowedBook = borrowedBook - 1;
                Object[] fieldesValues = { quantity, avaliableBook, borrowedBook };
                String[] updateFieldes = { "QUANTITY", "AVAILABLE_BOOKS", "BORROWED_BOOKS" };
                state = jdbcConnection.update(table, updateFieldes, fieldesValues, fieldesCondition, attribute);
                if (state) {
                    jdbcConnection.getConnection().commit();
                    System.out.println(" Your Sate   is  " + state);
                } else
                    jdbcConnection.getConnection().rollback(errorReturnBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("You Have An Error  IN ResultSet Object In  changeBookQuantities Method   in ReturnBookTransition \n\n" +
                               "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No BooK wase Returned");


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("You Have An Error IN changeBookQuantities Method   in ReturnBookTransition \n\n" +
                               "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, "Sorry No BooK wase Returned");
        }
        return state;
    }

    private double calcolateFine(String fromdate, String todate) {
        double cost=00.00;
        try {

            String beforfromDateFormate = fromdate;
            //  date = oldformat.parse(returnDate);
            String afeterfromDateFormate = null;

            String befortoDateFormate = todate;
            // date = oldformat.parse(returnedDate);
            String afetertoDateFormate = null;
            StringBuffer buffer = new StringBuffer();
            date = newFormat.parse(befortoDateFormate);
            afetertoDateFormate = oldFormate.format(date);
            toDate = oldFormate.parse(afetertoDateFormate);

            date = newFormat.parse(beforfromDateFormate);
            afeterfromDateFormate = oldFormate.format(date);
            fromDate = oldFormate.parse(afeterfromDateFormate);
            //            buffer.append("The beforreturnDateFormate   is  " +
            //                          beforfromDateFormate).append("\n").append("The  afeterreturnDateFormate   is  " +
            //                                                                      afeterfromDateFormate).append("\n").append("The beforreturnedDateFormate   is  " +
            //                                                                                                                   befortoDateFormate).append("\n").append("The afeterreturnedDateFormate   is " +
            //                                                                                                                                                                 afetertoDateFormate).append("\n").append("The startDate  is" +
            long diff = toDate.getTime() - fromDate.getTime();

            int dayes = (int) (diff / (24 * 60 * 60 * 1000));
            if(dayes<=0)
                cost=00.00;
            else
            cost = dayes * 0.25 ;

            System.out.println("Number of days between the returned  Date : " + fromDate + " and return Date : " +
                               toDate + " is  ==> " + dayes);

        } catch (ParseException ex) {

            System.out.println("You Have An Error IN returnBook Method   in ReturnBookTransition \n\n" +
                               "the Message   is     " + ex.getMessage() + "\n\n" + ex.toString());
            ex.printStackTrace();
        } catch (Exception ex) {

            System.out.println("You Have An Error IN returnBook Method   in ReturnBookTransition \n\n" +
                               "the Message   is     " + ex.getMessage() + "\n\n" + ex.toString());
            ex.printStackTrace();

        }
        return cost;
    }
private double getTotalCost(String cost,String price) {
    StringBuffer bufferCost=new StringBuffer(cost);
              for(int i=0;i<bufferCost.length();i++)
              {
                  if(bufferCost.charAt(i)=='$')
                 bufferCost.deleteCharAt(i);
              }
      double Cost=Double.valueOf(String.valueOf(bufferCost));
                StringBuffer bufferPrice=new StringBuffer(price);
                   for(int i=0;i<bufferPrice.length();i++)
              {
                  if(bufferPrice.charAt(i)=='$')
                 bufferPrice.deleteCharAt(i);
              }
          double Price=Double.valueOf(String.valueOf(bufferPrice));
          double totlaCost=Price+Cost;
          System.out.println("  The Total Cost IS  "+ (Price-Cost));
          return  totlaCost;
}
}
