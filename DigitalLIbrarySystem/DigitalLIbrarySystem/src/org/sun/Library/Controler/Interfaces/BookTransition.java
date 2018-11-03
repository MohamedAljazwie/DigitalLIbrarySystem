package org.sun.Library.Controler.Interfaces;

import org.sun.Library.Bean.Message;

public interface BookTransition<T> {
    public Message execute(T t);
}
