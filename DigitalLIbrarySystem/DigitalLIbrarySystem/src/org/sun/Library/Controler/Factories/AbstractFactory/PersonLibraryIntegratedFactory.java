package org.sun.Library.Controler.Factories.AbstractFactory;

import org.sun.Library.Controler.Interfaces.Deletion;
import org.sun.Library.Controler.Interfaces.Modification;
import org.sun.Library.Controler.Interfaces.Registration;
import org.sun.Library.Controler.Interfaces.Report;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.System.PersonSearch;

public class PersonLibraryIntegratedFactory implements LibraryIntegratedFactory {
    @Override
    public Registration creatRegistration() {
        // TODO Implement this method
        return null;
    }

    @Override
    public Modification createModification() {
        // TODO Implement this method
        return null;
    }

    @Override
    public Deletion createDeletion() {
        // TODO Implement this method
        return null;
    }

    @Override
    public View createView() {
        // TODO Implement this method
        return null;
    }

    @Override
    public Search createSearch() {
      return new PersonSearch();
    }

    @Override
    public Report createReport() {
        // TODO Implement this method
        return null;
    }
}
