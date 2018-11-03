package org.sun.Library.System;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Book.Book;
import org.sun.Library.Controler.Interfaces.Modification;
import org.sun.Library.Controler.Types.Role;

public class BookUpdate  implements  Modification{
  

    @Override
    public Message modify(Object t) {
     Book book=(Book)t;
        return modifyBook(book);
    }
    private Message modifyBook(Book book) {
        return null;
    }
}
