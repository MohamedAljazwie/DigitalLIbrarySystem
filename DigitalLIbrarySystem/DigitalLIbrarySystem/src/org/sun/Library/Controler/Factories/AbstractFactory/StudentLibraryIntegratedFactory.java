package org.sun.Library.Controler.Factories.AbstractFactory;

import org.sun.Library.Controler.Factories.FactoryMethod.Factory;
import org.sun.Library.Controler.Interfaces.Deletion;
import org.sun.Library.Controler.Interfaces.Modification;
import org.sun.Library.Controler.Interfaces.Registration;
import org.sun.Library.Controler.Interfaces.Report;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.System.StudentSearch;
import org.sun.Library.System.StudentView;
import org.sun.Library.System.StudientRegister;
import org.sun.Library.System.StudientRemove;
import org.sun.Library.System.StudientUpdate;

public class StudentLibraryIntegratedFactory implements  LibraryIntegratedFactory{
    @Override
    public Registration creatRegistration() {
        return new StudientRegister();
    }

    @Override
    public Modification createModification() {
        return new StudientUpdate();
    }

    @Override
    public Deletion createDeletion() {
        return new StudientRemove();
    }

    @Override
    public View createView() {
        return new StudentView();
    }

    @Override
    public Search createSearch() {
        return new StudentSearch();
    }

    @Override
    public Report createReport() {
        return null;
    }
}
