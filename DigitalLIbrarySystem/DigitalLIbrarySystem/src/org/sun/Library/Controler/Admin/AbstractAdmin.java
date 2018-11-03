package org.sun.Library.Controler.Admin;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Member.Person;
import org.sun.Library.Controler.Types.Role;

public abstract class AbstractAdmin<T> implements Admins<T> {


    @Override
    public Message add(T t, Role desc) {
        return new Message();
    }

    @Override
    public Message edit(T t, Role desc) {
        return new Message();
    }

   
    @Override
    public Message remove(T t, Role desc) {
        return new Message();
    }

    @Override
    public Message search(T t, Role desc) {
        return new Message();
    }

    @Override
    public Message view(Role desc) {
        return new Message();
    }
    @Override
    public Message viewAll(Role desc) {
        return new Message();
    }
    @Override
    public Message report() {
        return new Message();
    }
}
