package org.sun.Library.Controler.Factories.FactoryMethod;

import org.sun.Library.Controler.Factories.AbstractFactory.AuthorLibraryIntegratedFactory;
import org.sun.Library.Controler.Factories.AbstractFactory.BookLibraryIntegratedFactory;
import org.sun.Library.Controler.Factories.AbstractFactory.CategoryLibraryIntegratedFactory;
import org.sun.Library.Controler.Factories.AbstractFactory.IssueBookLibraryIntegratedFactory;
import org.sun.Library.Controler.Factories.AbstractFactory.LibraryIntegratedFactory;
import org.sun.Library.Controler.Factories.AbstractFactory.PersonLibraryIntegratedFactory;
import org.sun.Library.Controler.Factories.AbstractFactory.PublisherLibraryIntegratedFactory;
import org.sun.Library.Controler.Factories.AbstractFactory.RenewBookLibraryIntegratedFactory;
import org.sun.Library.Controler.Factories.AbstractFactory.ReserveBookLibraryIntegratedFactory;
import org.sun.Library.Controler.Factories.AbstractFactory.ReturnBookLibraryIntegratedFactory;
import org.sun.Library.Controler.Factories.AbstractFactory.StudentLibraryIntegratedFactory;
import org.sun.Library.Controler.Interfaces.Deletion;
import org.sun.Library.Controler.Interfaces.Modification;
import org.sun.Library.Controler.Interfaces.Registration;
import org.sun.Library.Controler.Interfaces.Report;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.System.AutherView;
import org.sun.Library.System.AuthorRegister;
import org.sun.Library.System.AuthorRemove;
import org.sun.Library.System.AuthorUpdate;
import org.sun.Library.System.PublisherRegister;
import org.sun.Library.System.PublisherRemove;
import org.sun.Library.System.PublisherUpdate;
import org.sun.Library.System.PublisherView;
import org.sun.Library.System.StudentView;
import org.sun.Library.System.StudientRegister;
import org.sun.Library.System.StudientRemove;
import org.sun.Library.System.StudientUpdate;

public class Factory {
    public static Registration getRegister(Role desc) {
        Registration person=null;
        switch(desc) {
        case Author :
            person=new AuthorRegister();
            break;
        case Publisher :
            person=new PublisherRegister();
            break;
        case Student :
            person=new StudientRegister();
            break;
        default :
            person=null;
            break;
        }
        return person;
    }
    public static Modification getModify(Role desc) {
        Modification person=null;
        switch(desc) {
        case Author :
            person=new AuthorUpdate();
            break;
        case Publisher :
            person=new PublisherUpdate();
            break;
        case Student :
            person=new StudientUpdate();
            break;
        default :
            person=null;
            break;
        }
        return person;
    }
    public static View getView(Role desc) {
        View person=null;
        switch(desc) {
        case Author :
            person=new AutherView();
            break;
        case Publisher :
            person=new PublisherView();
            break;
        case Student :
            person=new StudentView();
            break;
        default :
            person=null;
            break;
        }
        return person;
    }
    public static Deletion getDelete(Role desc) {
        Deletion person=null;
        switch(desc) {
        case Author :
            person=new AuthorRemove();
            break;
        case Publisher :
            person=new PublisherRemove();
            break;
        case Student :
            person=new StudientRemove();
            break;
        default :
            person=null;
            break;
        }
        return person;
    }
    public static Report getReport(Role desc) {
        Report report=null;
        return report;
    }
    public static Search getSearch(Role desc) {
        Search search=null;
        return search;
    }

    public static LibraryIntegratedFactory getFactory(Role desc) {
        LibraryIntegratedFactory factory=null;
        switch (desc) {
        case Person :
        factory=new PersonLibraryIntegratedFactory();
        break;
        case Author:
            factory = new AuthorLibraryIntegratedFactory();
            break;
        case Book:
            factory = new BookLibraryIntegratedFactory();
            break;
        case Category:
            factory = new CategoryLibraryIntegratedFactory();
            break;
        case Student:
            factory = new StudentLibraryIntegratedFactory();
            break;
        case Publisher:
            factory = new PublisherLibraryIntegratedFactory();
            break;
        case IssuseBook:
                factory = new IssueBookLibraryIntegratedFactory();
                break;
        case ReturnBook:
                factory = new ReturnBookLibraryIntegratedFactory();
                break;
        case ReserveBook:
                factory = new ReserveBookLibraryIntegratedFactory();
                break;
        case RenewBook:
                factory = new RenewBookLibraryIntegratedFactory();
                break;
        default:
            factory = null;
            break;
        }
        return factory;
    }
}
