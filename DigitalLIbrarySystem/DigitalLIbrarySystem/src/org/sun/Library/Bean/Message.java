package org.sun.Library.Bean;

import java.io.Serializable;

public class Message<T> implements Serializable {
    public static final String Role="Role";
    public static final String Access="Access";
    public static final String Error="ErrorRegister";
    public static final String addCategory="addCategory";
    public static final String publisherView="publisherView";
    public static final String authorView="authorView";
    public static final String categoryView="categoryView";
    public static final String studentView="studentView";
    public static final String studentSearch="studentSearch";
   public static final String addPerson="addPerson"; 
    public static final String addBook="addBook"; 
    public static final String bookSearch="bookSearch"; 
    public static final String personSearch="personSearch"; 
    public static final String Search="Search"; 
    public static final String IssueBook="IssueBook"; 
    public static final String ReturnBook="ReturnBook"; 
    public static final String Fine="Fine"; 
    public static final String Spec="Spec"; 
    private String title;
    private T message;
    public Message() {
      
        this("", null);
    }
    public Message(String title,T message) {
        setMessage(message);
        setTitle(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public T getMessage() {
        return message;
    }
}
