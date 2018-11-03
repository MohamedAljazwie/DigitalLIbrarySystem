package org.sun.Library.System;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.sun.Library.Bean.BookSpec;
import org.sun.Library.Bean.Message;
import org.sun.Library.Bean.PersonInfo;
import org.sun.Library.Controler.Book.Book;
import org.sun.Library.Controler.Book.IssueBook;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.Controler.Member.Student;
import org.sun.Library.DataBase.JdbcConnection;

public class IssuesBooksSearch extends AbstractSearch {
    private Message message;
    private Map<Object,Object> issue;
    public IssuesBooksSearch() {
        issue=new HashMap<>();
    }
    @Override
    public Message search(Object t) {
         String[] fields=
            {   " ISS.ISSUE_ID                        AS \" ISSUE ID \" "                       ,
                " ST.STUDENT_NATIONALID   AS  \" STUDENT NATIONALID \" "  ,
                " ST.STUDENT_NAME             AS  \" SYUDENT NAME\"  "            ,
                " B.BOOK_ISBN                      AS   \" BOOK ISSBN \" "                ,
                " B.BOOK_TITLE                    AS  \"  BOOK TITLE \"  "                ,
                " ISS.ISSUE_DATE                 AS  \"  ISSUE DATE \"  "                 ,
                " ISS.RETURN_DATE             AS \"   RETURN DATE \"  "              ,
                 "ISS.STATUS                        AS  \" STATUS \"  "                         ,
                "ISS.NOTES                           AS \" NOTES\"  "
           };
         String[] tables=
         { " STUDENT ST "          ,
           " ISSUES_BOOK ISS " ,
           " BOOK B "
        };
         String[]issuesJoin={"ISS.STUDENT_ID","ST.STUDENT_ID","ISS.BOOK_ID","B.BOOK_ID"};
        attributes = (Map<String, Object>) t;
        getResultes(tables, fields, issuesJoin, "");
        Map<String, Object> bookResult = new HashMap<>();
        try {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                columnsNames.add(metaData.getColumnName(i));
                java.lang.System.out.println(metaData.getColumnName(i));
            }
            bookResult.put("coulmnsNames", columnsNames);
        } catch (SQLException e) {
        }
        bookResult.put("coulmnsData", coulmnsData);
        message = new Message(Message.bookSearch, bookResult);


        return message;

    }

    @Override
    public Message search(String by, Object For) {
        // TODO Implement this method
        return null;
    }

    @Override
    public Message search(String by, List For) {
        // TODO Implement this method
        return null;
    }

    @Override
    public Message search(String[] by, List For) {
        StringBuffer buffer = new StringBuffer();
        try {
            JdbcConnection jdbcConnection = JdbcConnection.getInstance();
            String[] type=new String[by.length+1];
            int i;
            for(i=0;i<by.length;i++)
            type[i] = by(by[i]);
            type[i]=by("status");
//            Object[] values=new Objects[For.length+1];
//            int j;
//            for(j=0;j<For.length;j++)
//                values[j]=For[j];
//            values[j]="issued";
            For.add("issued");
//            List<Object> list=new ArrayList<>();
//            String[] val=new String[0];
            ResultSet resultSet = jdbcConnection.search(tables, fields, type, For);
            if (resultSet != null) {
                int count = 0;
                buffer.append("id ").append("\t").append("title").append("\n");
                while(resultSet.next()) {
                    count++;
                    java.lang.System.out.println("You  found  data counter  " + count);
                    PersonInfo info=new PersonInfo();
                    info.setId(resultSet.getInt("STUDENT_ID"));
                    info.setName(resultSet.getString("STUDENT_NAME"));
                    Student student=new Student();
                    student.setInfo(info);
                    student.setNationalID(resultSet.getString("STUDENT_NATIONALID"));
                    BookSpec spec=new BookSpec();
                    spec.setIsbn(resultSet.getString("BOOK_ISBN"));
                    spec.setTitle(resultSet.getString("BOOK_TITLE"));
                    Book book=new Book();
                    book.setBookSpec(spec);
                    book.setId(resultSet.getString("BOOK_ID"));
                    IssueBook issueBook=new IssueBook();
                    issueBook.setBook(book);
                    issueBook.setIssueID(resultSet.getString("ISSUE_ID"));
                    issueBook.setStudent(student);
                    issueBook.setIssueDate(resultSet.getString("ISSUE_DATE"));
                    issueBook.setReturnDate(resultSet.getString("RETURN_DATE"));
                    issue.put(issueBook.getIssueID(), issueBook);

                    buffer.append(resultSet.getInt("BOOK_ID")).append("\t").append(spec.getTitle()).append("\n");
                }
                message =  new Message(Message.Search, issue);
            } else {
                java.lang.System.out.println("You not found any data");
                message = new Message(Message.Search, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            java.lang.System.out.println("You Have An Error IN search Method   in IssuesBooksSearch \n\n" +
                                         "the Message   is     " + e.getMessage() + "\n\n" + e.toString());
            message = new Message(Message.Error, null);
        }

        return message;
    }
    private String[] fields=
        {   " ISS.ISSUE_ID "                       ,
            " STUDENT_ID "                        ,
            " ST.STUDENT_NATIONALID "  ,
            " ST.STUDENT_NAME "            ,
            " BOOK_ID "                             ,
            " B.BOOK_ISBN "                     ,
            " B.BOOK_TITLE "                    ,
            " ISS.ISSUE_DATE "                 ,
            " ISS.RETURN_DATE "
       };
  private String[] tables=
     { " STUDENT ST "          ,
       " ISSUES_BOOK ISS " ,
       " BOOK B "
    };
    private String by(String by) {
        String By = null;
        switch (by) {
        case "isbn":
            By = " B.BOOK_ISBN ";
            break;
        case "title":
            By = " B.BOOK_TITLE " ;
            break;
        case "nationalID":
            By= " ST.STUDENT_NATIONALID ";
            break;
        case "status":
            By=" ISS.STATUS ";
            break;
        }
        return By;
    }
    
}
