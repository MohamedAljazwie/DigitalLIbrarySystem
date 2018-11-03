package org.sun.Library.Controler.Admin;

import java.util.List;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Book.FINE;
import org.sun.Library.Controler.Book.IssueBook;
import org.sun.Library.Controler.Book.IssueBookTransition;
import org.sun.Library.Controler.Book.RenewBook;
import org.sun.Library.Controler.Book.RenewBookTransition;
import org.sun.Library.Controler.Book.ReturnBook;
import org.sun.Library.Controler.Book.ReturnBookTransition;
import org.sun.Library.Controler.Factories.AbstractFactory.LibraryIntegratedFactory;
import org.sun.Library.Controler.Factories.FactoryMethod.Factory;
import org.sun.Library.Controler.Interfaces.BookTransition;
import org.sun.Library.Controler.Types.Role;

public class Admin<T> {
    private static Admin admin;
    private LibraryIntegratedFactory factory;
    private BookTransition bookTransition;
    private Message message;
    private Admin() {
        message=new Message();
    }

    public static synchronized Admin getInstance() {
        if (admin == null) {
            synchronized (Admin.class) {
                if (admin == null)
                    admin = new Admin();
            }
        }
        return admin;
    }
    public Message add(T t,Role desc) {
        factory = Factory.getFactory(desc);
        message=factory.creatRegistration().register(t);
        return message;
    }
    public Message edit(T t,Role desc) {
        factory = Factory.getFactory(desc);
        message=factory.createModification().modify(t);
        return message;
    }
    public Message remove(T t,Role desc) {
        factory = Factory.getFactory(desc);
        message=factory.createDeletion().remove(t);
        return message;
    }
    public Message search(T t ,Role desc) {
        factory = Factory.getFactory(desc);
        message=factory.createSearch().search(t);
        return message;
    }
    public Message search(String by,Object For,Role desc) {
        factory = Factory.getFactory(desc);
        message=factory.createSearch().search(by, For);
        return message;
    }
    public Message search(String by,Object[] For,Role desc) {
        factory = Factory.getFactory(desc);
        message=factory.createSearch().search(by, For);
        return message;
    }
    public Message search(String[] by,List<Object> For,Role desc) {
        factory = Factory.getFactory(desc);
       message=factory.createSearch().search(by, For);
        return message;
    }
    public Message view(Role desc) {
        factory = Factory.getFactory(desc);
        message=factory.createView().display();
        return message;
    }
    public Message issueBook(IssueBook book) {
        bookTransition=new IssueBookTransition();
        message=bookTransition.execute(book);
        return message;
    }
    public Message returnBook(ReturnBook  book) {
        bookTransition=new ReturnBookTransition();
        message=bookTransition.execute(book);
        return message;
    }
    public Message renewBook(RenewBook book) {
        bookTransition=new RenewBookTransition();
        message=bookTransition.execute(book);
        return message;
    }
   public Message addFine(FINE fine) {
       return  fine.addFine();
   }
    
  
    public Message report() {
        return message;
    }
}
