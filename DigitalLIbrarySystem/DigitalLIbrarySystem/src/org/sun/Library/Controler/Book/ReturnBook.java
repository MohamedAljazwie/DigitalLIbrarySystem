package org.sun.Library.Controler.Book;

import java.io.Serializable;

import org.sun.Library.Controler.Member.Student;

public class ReturnBook implements Serializable {
    private String returnID;
    private Student student;
    private Book book;
    private String issueDate;
    private String returnDate;
    private String returnedDate;
    private String nots;
public ReturnBook() {
    
}
    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnID(String issueID) {
        this.returnID = issueID;
    }

    public String getReturnID() {
        return returnID;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setNots(String nots) {
        this.nots = nots;
    }

    public String getNots() {
        return nots;
    }
}
