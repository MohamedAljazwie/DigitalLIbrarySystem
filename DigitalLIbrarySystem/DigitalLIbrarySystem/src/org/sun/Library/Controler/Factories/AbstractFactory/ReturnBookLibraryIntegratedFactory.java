package org.sun.Library.Controler.Factories.AbstractFactory;

import org.sun.Library.Controler.Interfaces.Report;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.System.ReturnBookView;
import org.sun.Library.System.ReturnsBooksSearch;

public class ReturnBookLibraryIntegratedFactory  extends BookTransitionLibraryIntegratedFactory{
    @Override
    public View createView() {
        
        return new ReturnBookView();
    }

    @Override
    public Search createSearch() {
       return new ReturnsBooksSearch();
    }

    @Override
    public Report createReport() {
        // TODO Implement this method
        return null;
    }
}
