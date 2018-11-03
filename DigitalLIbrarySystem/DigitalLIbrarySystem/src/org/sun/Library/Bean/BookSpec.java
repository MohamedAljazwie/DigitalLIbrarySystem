package org.sun.Library.Bean;

import java.io.Serializable;

import org.sun.Library.Controler.Member.Author;
import org.sun.Library.Controler.Member.Publisher;

public class BookSpec implements Serializable {
    private String title;
    private String isbn;
    private String subject;
    private String price;
    private Publisher publisher;
    private Author author;
    private String publishDate;

    public BookSpec() {
this(null, null, null,null, null, null, null);
    }

    public BookSpec(String title, String isbn,String subject, String price, Publisher publisher, Author author, String publishDate) {
        setAuthor(author);
        setIsbn(isbn);
        setSubject(subject);
        setPrice(price);
        setPublishDate(publishDate);
        setPublisher(publisher);
        setTitle(title);
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishDate() {
        return publishDate;
    }


}
