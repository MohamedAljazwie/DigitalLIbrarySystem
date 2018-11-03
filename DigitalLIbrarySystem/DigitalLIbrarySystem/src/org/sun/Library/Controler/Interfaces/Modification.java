package org.sun.Library.Controler.Interfaces;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Types.Role;

public interface Modification<T> {
    public Message modify(T t);
}
