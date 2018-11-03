package org.sun.Library.Controler.Factories.AbstractFactory;

import org.sun.Library.Controler.Interfaces.Deletion;
import org.sun.Library.Controler.Interfaces.Modification;
import org.sun.Library.Controler.Interfaces.Registration;
import org.sun.Library.Controler.Interfaces.Report;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.System.BookRegister;
import org.sun.Library.System.BookRemove;
import org.sun.Library.System.BookSearch;
import org.sun.Library.System.BookUpdate;
import org.sun.Library.System.BookView;
import org.sun.Library.System.CategoryRegister;
import org.sun.Library.System.CategoryRemove;
import org.sun.Library.System.CategoryUpdate;
import org.sun.Library.System.DisplayCategories;

public class BookLibraryIntegratedFactory  implements  LibraryIntegratedFactory{
    @Override
    public Registration creatRegistration() {
        return new BookRegister();
    }

    @Override
    public Modification createModification() {
     return new BookUpdate();
    }

    @Override
    public Deletion createDeletion() {
        return new BookRemove();
    }

    @Override
    public View createView() {
       return new BookView();
    }

    @Override
    public Search createSearch() {
         return new BookSearch();
    }

    @Override
    public Report createReport() {
        return null;
    }
}
