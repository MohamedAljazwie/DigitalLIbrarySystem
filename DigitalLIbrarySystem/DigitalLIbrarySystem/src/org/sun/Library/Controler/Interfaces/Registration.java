package org.sun.Library.Controler.Interfaces;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Types.Role;

public interface Registration<T> {
    public Message register(T t);
}
