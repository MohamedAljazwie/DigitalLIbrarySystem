package org.sun.Library.Controler.Admin;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Factories.FactoryMethod.Factory;
import org.sun.Library.Controler.Types.Role;
import org.sun.Library.System.DisplayCategories;
import org.sun.Library.System.PersonView;

public class AdminView<T> extends AbstractAdmin<T> {
   // private Message message;

    public AdminView() {
    //    message = new Message();
    }

    @Override
    public Message view(Role desc) {
        switch (desc) {
        case Category:
            {
                DisplayCategories category = new DisplayCategories();
               // message = category.view();
                break;
            }
        case Author:
            {
                PersonView personView = (PersonView) Factory.getView(Role.Author);
               // message = personView.view();
                break;
            }
        case Student:
            {
                PersonView personView = (PersonView) Factory.getView(Role.Student);
             //   message = personView.view();
                break;
            }
        case Publisher:
            {
                PersonView personView = (PersonView) Factory.getView(Role.Publisher);
             //   message = personView.view();
                break;
            }
            case Book : {
                               
                }
        }
        return null;
    }
}
