package org.sun.Library.System;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Factories.FactoryMethod.Factory;
import org.sun.Library.Controler.Interfaces.Registration;
import org.sun.Library.Controler.Member.Person;
import org.sun.Library.Controler.Types.Role;

public abstract  class PersonRegistration<T> implements Registration<T> {
    private static  Message message;

    public PersonRegistration() {

    }

public abstract Message add(Person person);

    @Override
    public Message register(T t) {
        Person person=(Person)t;
        message = add(person);
        return message;
    }
}
