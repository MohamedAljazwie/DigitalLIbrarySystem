package org.sun.Library.Controler.Factories.AbstractFactory;

import org.sun.Library.Controler.Interfaces.Deletion;
import org.sun.Library.Controler.Interfaces.Modification;
import org.sun.Library.Controler.Interfaces.Registration;
import org.sun.Library.Controler.Interfaces.Report;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.System.AutherView;
import org.sun.Library.System.AuthorRegister;
import org.sun.Library.System.AuthorRemove;
import org.sun.Library.System.AuthorSearch;
import org.sun.Library.System.AuthorUpdate;

public class AuthorLibraryIntegratedFactory implements LibraryIntegratedFactory {
    @Override
    public Registration creatRegistration() {
      return new AuthorRegister();
    }

    @Override
    public Modification createModification() {
       return new AuthorUpdate();
    }

    @Override
    public Deletion createDeletion() {
    return new AuthorRemove();
    }

    @Override
    public View createView() {
       return new AutherView();
    }

    @Override
    public Search createSearch() {
    return new AuthorSearch();
    }

    @Override
    public Report createReport() {
        // TODO Implement this method
        return null;
    }
}
