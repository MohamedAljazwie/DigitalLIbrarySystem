package org.sun.Library.Controler.Admin;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Types.Role;

public interface Admins<T> {
    public Message add(T t,Role desc);
    public Message edit(T t,Role desc);
    public Message remove(T t,Role desc);
    public Message search(T t ,Role desc);
    public Message view(Role desc);
    public Message viewAll(Role desc);
    public Message report();
}
