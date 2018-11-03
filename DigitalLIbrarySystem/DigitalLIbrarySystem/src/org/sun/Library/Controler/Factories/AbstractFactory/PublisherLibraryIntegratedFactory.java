package org.sun.Library.Controler.Factories.AbstractFactory;

import org.sun.Library.Controler.Interfaces.Deletion;
import org.sun.Library.Controler.Interfaces.Modification;
import org.sun.Library.Controler.Interfaces.Registration;
import org.sun.Library.Controler.Interfaces.Report;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.System.PublisherRegister;
import org.sun.Library.System.PublisherRemove;
import org.sun.Library.System.PublisherSearch;
import org.sun.Library.System.PublisherUpdate;
import org.sun.Library.System.PublisherView;

public class PublisherLibraryIntegratedFactory implements LibraryIntegratedFactory {
    @Override
    public Registration creatRegistration() {
        return new PublisherRegister();
    }

    @Override
    public Modification createModification() {
      return new PublisherUpdate();
    }

    @Override
    public Deletion createDeletion() {
       return new PublisherRemove();
    }

    @Override
    public View createView() {
       return new PublisherView();
    }

    @Override
    public Search createSearch() {
     return new PublisherSearch();
        
    }

    @Override
    public Report createReport() {
        // TODO Implement this method
        return null;
    }
}
