package org.sun.Library.System;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Factories.FactoryMethod.Factory;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.Controler.Types.Role;

public abstract  class PersonView<T> implements View {
    private Message message;
    public abstract Message view();
    public abstract Message viewAll(Object object);

    @Override
    public Message display() {
       message =view();
        return message;
    }

    @Override
    public Message displayAll(Object desc) {
        message = viewAll(desc);
        return message;
    }
}
