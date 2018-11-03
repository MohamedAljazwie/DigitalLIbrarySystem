package org.sun.Library.System;

import java.io.PrintStream;
import java.io.PrintWriter;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.sun.Library.Bean.Access;
import org.sun.Library.Bean.BookSpec;
import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Factories.AbstractFactory.LibraryIntegratedFactory;
import org.sun.Library.Controler.Factories.FactoryMethod.Factory;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.DataBase.JdbcConnection;

public class System {
    private static Message message;
    private static Map<String, Object> returnDate;
    private static JdbcConnection jdbcConnection = JdbcConnection.getInstance();

    public System() {

    }
    public static Message check(Access access) {
        Message message = null;
        String tableName = "LMSLOGIN";
        String[] fieldes = { "*" };
        String[] fieldesCondition = { "USERNAME", "PASSWORD" };
        String[] attributs = { access.getUserName(), access.getPassword() };
        
        try {
            ResultSet resulte = jdbcConnection.check(tableName, fieldes, fieldesCondition, attributs);

            if (resulte.next()) {
                message = new Message(Message.Role, resulte.getString("ROLE"));
                resulte.close();
            } else
                message = null;
        } catch (SQLException e) {

            System.out().println("You Have An Error IN Check  Method   in Member Class  \n\n" +
                               "the Error Code  is     " + e.getErrorCode() + "\n\n" + "the Message   is     " +
                               e.getMessage() + "\n\n" + e.toString());
            return null;
        }
        return message;
    }
    public static Message search(String tableName, String by, String For) {

        try {
          
            String type = by(by);
            java.lang.System.out.println("Your Type Is  " + type);
            ResultSet resultSet = jdbcConnection.search(tableName, type, For);
            // ResultSet resultSet = jdbcConnection.check(tableName, fieldes, fildesCondition, attributes);
            if (resultSet != null) {
                message = new Message(Message.Search, resultSet);
            } else {
                java.lang.System.out.println("You not found any data");
                message = new Message(Message.Search, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An Error IN addCategory Method   in CategoryRegister \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, null);
        }

        return message;
    }

    public static Message search(String tableName, String[] by, Object[] For) {

        try {
        
            String[] type = new String[by.length];
            for (int i = 0; i < by.length; i++)
                type[i] = by(by[i]);
            java.lang.System.out.println("Your Type Is  " + type);
            ResultSet resultSet = jdbcConnection.search(tableName, type, For);
            // ResultSet resultSet = jdbcConnection.check(tableName, fieldes, fildesCondition, attributes);
            if (resultSet != null) {
                message = new Message(Message.Search, resultSet);
            } else {
                java.lang.System.out.println("You not found any data");
                message = new Message(Message.Search, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An Error IN addCategory Method   in CategoryRegister \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, null);
        }

        return message;
    }
public static PrintStream out() {
    return java.lang.System.out;
}
    private static  String by(String by) {
        String By = null;
        switch (by) {
        case "isbn":
            By = "BOOK_ISBN";
            break;
        case "title":
            By = "BOOK_TITLE";
            break;
        case "nationalID":
            By = "STUDENT_NATIONALID";
            break;
        }
        return By;
    }

    public static Message search(Role desc, Map attributs) {
        LibraryIntegratedFactory factory;
        factory = Factory.getFactory(desc);
        if (factory != null)
            message = factory.createSearch().search(attributs);

        return message;
    }

    public static Message viewAll(Role desc, Object data) {
        LibraryIntegratedFactory factory;
        factory = Factory.getFactory(desc);
        if (factory != null)
            message = factory.createView().displayAll(data);
        return message;
    }

    public static Map<String, Object> getDate(String dateType) {
        returnDate = new HashMap<>();
        dateType = dateType.toLowerCase().trim();
        
        switch (dateType) {
        case "daily":
            getDay();
            break;
        case "weekly":
            getWeek();
            break;
        case "monthly":
            getMonth();
            break;
        default:
            returnDate = null;
            break;
        }
        return returnDate;
    }

    private static void getDay() {

        Calendar now = Calendar.getInstance();
        Date date = now.getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
        java.lang.System.out.println("the current day is" + format.format(date));
        returnDate.put("fromDate",  format.format(date));
        returnDate.put("toDate",  format.format(date));

    }

    private static void getWeek() {

        Calendar now = Calendar.getInstance();
        //Date date=now.getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
        //    System.out.println("the current day is"+ format.format(date));
        String[] days = new String[7];
        int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 2; //add 2 if your week start on monday
        now.add(Calendar.DAY_OF_MONTH, delta);
        for (int i = 0; i < 7; i++) {
            days[i] = format.format(now.getTime());
            now.add(Calendar.DAY_OF_MONTH, 1);
        }
        java.lang.System.out.println(Arrays.toString(days));
        returnDate.put("fromDate", days[0]);
        returnDate.put("toDate", days[days.length - 1]);

    }

    private static void getMonth() {

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = 1;
        c.set(year, month, day);
        Date date = c.getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);

        int numOfDaysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        returnDate.put("fromDate", format.format(date).toUpperCase());
        java.lang.System.out.println("First Day of month: " + format.format(date));
        c.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth - 1);
        date = c.getTime();
        returnDate.put("toDate", format.format(date).toUpperCase());
        java.lang.System.out.println("Last Day of month: " + format.format(date));

    }

    public static Map<String, Object> getDate(String fromDate, String toDate) {
        returnDate=new HashMap<>();
        returnDate.put("fromDate", formatDate(fromDate));
        returnDate.put("toDate", formatDate(toDate));
        return returnDate;
    }

    private static String formatDate(String format) {
        Date date;
        DateFormat oldFormate = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat newFormat = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
        try {
            date = oldFormate.parse(format);
            format = newFormat.format(date);
        } catch (ParseException e) {
        }
        return format;
    }
}


