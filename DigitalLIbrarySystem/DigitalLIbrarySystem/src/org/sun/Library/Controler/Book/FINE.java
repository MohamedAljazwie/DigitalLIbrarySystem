package org.sun.Library.Controler.Book;

import java.io.Serializable;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Savepoint;

import java.util.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.joda.time.LocalDate;
import org.joda.time.Days;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Member.Student;
import org.sun.Library.DataBase.JdbcConnection;

public class FINE implements Serializable {
    private Message message;
    private String fineID;
    private ReturnBook returnBook;
    private String fineDate;
    private String cost;
    private String totalCost;
    private String modeOfPay;
    private String remark;

    private Date date;
    //    private DateFormat oldFormate = new SimpleDateFormat("MM/dd/yyyy");
    //    private DateFormat newFormat = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);


    public FINE(ReturnBook returnBook, String fineDate, String cost, String modePay, String remark) {
        setCost(cost);
        setFineDate(fineDate);
        setModeOfPay(modePay);
        setRemark(remark);
        setReturnBook(returnBook);
    }

    public FINE() {
        this(null, null, null, null, null);
    }

    public void setFineID(String fineID) {
        this.fineID = fineID;
    }

    public String getFineID() {
        return fineID;
    }

    public void setReturnBook(ReturnBook returnBook) {
        this.returnBook = returnBook;
    }

    public ReturnBook getReturnBook() {
        return returnBook;
    }

    public void setFineDate(String fineDate) {
        this.fineDate = fineDate;
    }

    public String getFineDate() {
        return fineDate;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCost() {
        return cost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setModeOfPay(String modePay) {
        this.modeOfPay = modePay;
    }

    public String getModeOfPay() {
        return modeOfPay;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public Message addFine() {
        try {
            String table = "FINE";
            Object[] attributes = { returnBook.getReturnID(), fineDate, cost, totalCost, modeOfPay, remark };
            String[] fields = { "RETURN_ID", "FINE_DATE", "COST", "TOTAL_COST", "MODE_OF_PAY", "REMARK" };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();
            Savepoint errorFine = jdbcConnection.getConnection().setSavepoint("fine");
            ResultSet resultSet = jdbcConnection.Insert(table, fields, attributes);
            if (resultSet != null && resultSet.next()) {
                jdbcConnection.getConnection().commit();
                message = new Message(Message.Fine, "The Data  Successfully Confirmed");
            } else {
                jdbcConnection.getConnection().rollback(errorFine);
                message = new Message(Message.Error, "The Data Not Confirmed");
            }
        } catch (SQLException e) {
            System.out.println(" \n\n You Have An Error IN addFine  Method   in FINE   \n\n" +
                               "\n\n  the Message   is     " + e.getMessage() + "\n\n" + e.toString() +
                               "\n\n LocalizedMessage" + e.getLocalizedMessage() + "\n\n Cause" + e.getCause());

            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(" \n\n You Have An Error IN addFine  Method   in FINE Servlet  \n\n" +
                               "\n\n  the Message   is     " + e.getMessage() + "\n\n" + e.toString() +
                               "\n\n LocalizedMessage" + e.getLocalizedMessage() + "\n\n Cause" + e.getCause());

            e.printStackTrace();

        }
        return message;
    }

    public String calcolauteFine(Integer returnID) {
        try {
            String tableName = "RETURN_BOOK";
            Object[] attributs = { returnID };
            String[] fields = {
                "TO_DATE(RETURNED_DATE,'dd-MONTH-YYYY')-TO_DATE(RETURN_DATE,'dd-MONTH-YYYY') AS DAYES" };
            String[] fieldsConditions = { "RETURN_ID" };
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();
            ResultSet resultSet = jdbcConnection.check(tableName, fields, fieldsConditions, attributs);
            if (resultSet.next()) {
                int dayes = resultSet.getInt("DAYES");
                cost = dayes * 0.25 + "$";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("You Have An Error  IN ResultSet Object In  calcolauteFine Method   in FINE \n\n" +
                               "the Message   is     " + e.getMessage() + "\n\n" + e.toString());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("You Have An Error IN calcolauteFine Method   in FINE \n\n" + "the Message   is     " +
                               e.getMessage() + "\n\n" + e.toString());

        }
        return cost;
    }

    public String calcolateFine(String returnDate, String returnedDate) {
        try {

            String beforreturnDateFormate = returnDate;
            String beforreturnedDateFormate = returnedDate;
            Date date = null;
            DateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat oldFormat = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
            date = oldFormat.parse(beforreturnedDateFormate);
            System.out.println("Date    is" + date);
            String afeterreturnedDateFormate = newFormat.format(date);
            System.out.println("afeterreturnedDateFormate   is" + afeterreturnedDateFormate);
            LocalDate endDate = LocalDate.parse(afeterreturnedDateFormate);
            date = oldFormat.parse(beforreturnDateFormate);
            String afeterreturnDateFormate = newFormat.format(date);
            LocalDate startDate = LocalDate.parse(afeterreturnDateFormate);
            StringBuffer buffer = new StringBuffer();
            buffer.append("The beforreturnDateFormate   is  " +
                          beforreturnDateFormate).append("\n").append("The  afeterreturnDateFormate   is  " +
                                                                      afeterreturnDateFormate).append("\n").append("The beforreturnedDateFormate   is  " +
                                                                                                                   beforreturnedDateFormate).append("\n").append("The afeterreturnedDateFormate   is " +
                                                                                                                                                                 afeterreturnedDateFormate).append("\n").append(" The endDate   is" +
                                                                                                                                                                                                                endDate).append("\n").append("The startDate  is" +
                                                                                                                                                                                                                                             startDate).append("\n");
            int dayes = Days.daysBetween(startDate, endDate).getDays();
            cost = dayes * 0.25 + "$";
            System.out.println(buffer);
            System.out.println("Number of days between the returned  Date : " + endDate + " and return Date : " +
                               startDate + " is  ==> " + dayes);
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

    public static void main(String[] a) {
        FINE fINE = new FINE();
        fINE.setCost(fINE.calcolateFine("10-july-2016", "27-JULY-2016"));
        System.out.println("Cost  is" + fINE.getCost());
    }
}
