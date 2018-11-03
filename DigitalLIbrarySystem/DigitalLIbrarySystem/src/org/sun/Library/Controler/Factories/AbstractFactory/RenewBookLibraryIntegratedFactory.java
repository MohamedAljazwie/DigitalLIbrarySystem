package org.sun.Library.Controler.Factories.AbstractFactory;

import org.sun.Library.Controler.Interfaces.Report;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.System.RenewBookView;
import org.sun.Library.System.RenewBooksSearch;

public class RenewBookLibraryIntegratedFactory  extends  BookTransitionLibraryIntegratedFactory{
    @Override
    public View createView() {
        
        return new RenewBookView();
    }

    @Override
    public Search createSearch() {
      return new RenewBooksSearch();
    }

    @Override
    public Report createReport() {
        // TODO Implement this method
        return null;
    }
}
