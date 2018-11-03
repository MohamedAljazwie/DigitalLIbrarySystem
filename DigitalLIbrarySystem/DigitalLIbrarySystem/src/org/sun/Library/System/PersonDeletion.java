package org.sun.Library.System;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Factories.FactoryMethod.Factory;
import org.sun.Library.Controler.Interfaces.Deletion;
import org.sun.Library.Controler.Member.Author;
import org.sun.Library.Controler.Member.Person;
import org.sun.Library.Controler.Member.Publisher;
import org.sun.Library.Controler.Member.Student;
import org.sun.Library.Controler.Types.Role;

public abstract class PersonDeletion<T> implements Deletion<T> {
    private static  Message message;
   
   @Override
    public Message remove(T t) {
        Person person=(Person)t;
        message = delet(person);
        return message;
    }
    public abstract Message delet(Person person);
}
