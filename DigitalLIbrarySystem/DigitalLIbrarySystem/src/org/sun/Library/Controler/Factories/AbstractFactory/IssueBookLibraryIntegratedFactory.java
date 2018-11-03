package org.sun.Library.Controler.Factories.AbstractFactory;

import org.sun.Library.Controler.Interfaces.Report;
import org.sun.Library.Controler.Interfaces.Search;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.System.IssuesBookView;
import org.sun.Library.System.IssuesBooksSearch;

public class IssueBookLibraryIntegratedFactory  extends  BookTransitionLibraryIntegratedFactory{
    @Override
    public View createView() {
     return new IssuesBookView();
    }

    @Override
    public Search createSearch() {
        return new IssuesBooksSearch();
    }

    @Override
    public Report createReport() {
        // TODO Implement this method
        return null;
    }
}
