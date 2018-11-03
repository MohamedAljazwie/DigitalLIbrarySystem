package org.sun.Library.Controler.Factories.AbstractFactory;

import org.sun.Library.Controler.Interfaces.Deletion;
import org.sun.Library.Controler.Interfaces.Modification;
import org.sun.Library.Controler.Interfaces.Registration;
import org.sun.Library.Controler.Interfaces.Report;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.System.CategoryRegister;
import org.sun.Library.System.CategoryRemove;
import org.sun.Library.System.CategoryUpdate;
import org.sun.Library.System.DisplayCategories;

public class CategoryLibraryIntegratedFactory implements LibraryIntegratedFactory {
    @Override
    public Registration creatRegistration() {
        return new CategoryRegister();
    }

    @Override
    public Modification createModification() {
     return new CategoryUpdate();
    }

    @Override
    public Deletion createDeletion() {
        return new CategoryRemove();
    }

    @Override
    public View createView() {
       return new DisplayCategories();
    }

    @Override
    public Search createSearch() {
         return null;
    }

    @Override
    public Report createReport() {
        return null;
    }
}
