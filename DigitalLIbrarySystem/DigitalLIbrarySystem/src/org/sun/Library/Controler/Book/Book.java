package org.sun.Library.Controler.Book;

import org.sun.Library.Bean.BookSpec;

public class Book {
    private String id;
    private int copies;
    private BookSpec bookSpec;
    private Category category;
    public Book() {
        this("", null, null, 0);
    }
    public Book(String id,BookSpec bookSpec,Category category,int  copies) {
        setBookSpec(bookSpec);
        setId(id);
        setCategory(category);
        setCopies(copies);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getCopies() {
        return copies;
    }

    public void setBookSpec(BookSpec bookSpec) {
        this.bookSpec = bookSpec;
    }

    public BookSpec getBookSpec() {
        return bookSpec;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
