package org.sun.Library.Controler.Factories.AbstractFactory;

import org.sun.Library.Controler.Interfaces.Deletion;
import org.sun.Library.Controler.Interfaces.Modification;
import org.sun.Library.Controler.Interfaces.Registration;
import org.sun.Library.Controler.Interfaces.Report;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.Controler.Types.Role;

public interface LibraryIntegratedFactory {
    public Registration creatRegistration();

    public Modification createModification();

    public Deletion createDeletion();

    public View createView();

    public Search createSearch();

    public Report createReport();
}
