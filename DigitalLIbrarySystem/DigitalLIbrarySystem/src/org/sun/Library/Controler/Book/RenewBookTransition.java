package org.sun.Library.Controler.Book;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Interfaces.BookTransition;

public class RenewBookTransition implements BookTransition {
    @Override
    public Message execute(Object t) {
        RenewBook book=(RenewBook)t;
        return null;
    }
}
