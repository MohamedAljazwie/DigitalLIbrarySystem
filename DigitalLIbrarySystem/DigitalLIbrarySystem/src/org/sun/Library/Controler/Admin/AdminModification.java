package org.sun.Library.Controler.Admin;

import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Book.Book;
import org.sun.Library.Controler.Book.Category;
import org.sun.Library.Controler.Factories.AbstractFactory.LibraryIntegratedFactory;
import org.sun.Library.Controler.Factories.FactoryMethod.Factory;
import org.sun.Library.Controler.Member.Person;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.System.BookUpdate;
import org.sun.Library.System.CategoryUpdate;
import org.sun.Library.System.PersonModification;

public class AdminModification<T>  extends AbstractAdmin<T>{
   // private     LibraryIntegratedFactory factory;
    public AdminModification() {
     //   message=new Message();
    }
   // private Message message;
    @Override
    public Message edit(T t, Role desc) {
//        if(t instanceof Person) {
//            Person person = (Person)t;
//               // message = PersonModification.modifyPerson(person, desc);
//        }
//        else if(t instanceof Book) {
//            Book book = (Book) t;
//            BookUpdate update=new BookUpdate();
//            message=update.modify(t,desc);
//        }
//        else if(t instanceof Category) {
//            Category category = (Category) t;
//            CategoryUpdate update=new CategoryUpdate();
//            message=update.modify(t,desc);
//        }
     return Factory.getFactory(desc).createModification().modify(t);
        
    }
    
}
