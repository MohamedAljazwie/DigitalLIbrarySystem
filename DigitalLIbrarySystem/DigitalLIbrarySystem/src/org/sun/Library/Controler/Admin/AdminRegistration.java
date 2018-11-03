package org.sun.Library.Controler.Admin;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Factories.FactoryMethod.Factory;
import org.sun.Library.Controler.Types.Role;


public class AdminRegistration<T> extends AbstractAdmin<T> {
 //   private LibraryIntegratedFactory factory;

    public AdminRegistration() {
        //message = new Message();
    }

    @Override
    public Message add(T t, Role desc) {
        //       if(t instanceof Person) {
        //           Person person = (Person) t;
        //    //message = PersonRegistration.register(person, desc);
        //      }
        //       else if(t instanceof Book) {
        //           Book book = (Book) t;
        //           BookRegister register=new BookRegister();
        //           message=register.register(book,desc);
        //       }
        //       else if(t instanceof Category) {
        //           Category category = (Category) t;
        //      CategoryRegister register=new CategoryRegister();
        //      message=register.register(t,desc);
        //       }
      return Factory.getFactory(desc).creatRegistration().register(t);
       
    }
}
