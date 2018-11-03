package org.sun.Library.Controler.Factories.AbstractFactory;

import org.sun.Library.Controler.Interfaces.Report;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.System.ReserveBookView;
import org.sun.Library.System.ReserveBookSearch;

public class ReserveBookLibraryIntegratedFactory extends BookTransitionLibraryIntegratedFactory {
    @Override
    public View createView() {
        
        return new ReserveBookView();
    }

    @Override
    public Search createSearch() {
       return new ReserveBookSearch();
    }

    @Override
    public Report createReport() {
        // TODO Implement this method
        return null;
    }
}
