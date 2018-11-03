package org.sun.Library.System;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Factories.FactoryMethod.Factory;
import org.sun.Library.Controler.Interfaces.Modification;
import org.sun.Library.Controler.Member.Person;
import org.sun.Library.Controler.Types.Role;

public  abstract  class PersonModification<T>implements Modification<T> {
    private static  Message message;
    @Override
    public  Message modify(T t ) {
        Person person=(Person)t;
        message =update(person);
        return message;
    }
    public abstract Message update(Person person);

}
