package org.sun.Library.System;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Book.Book;
import org.sun.Library.Controler.Interfaces.Deletion;
import org.sun.Library.Controler.Types.Role;

public class BookRemove implements Deletion {
 

    @Override
    public Message remove(Object t) {
        Book book=(Book)t;
        return deletBook(book);
    }
    private Message deletBook(Book book) {
        return null;
    }
}
