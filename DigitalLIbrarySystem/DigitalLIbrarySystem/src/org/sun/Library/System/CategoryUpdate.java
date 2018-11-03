package org.sun.Library.System;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Book.Category;
import org.sun.Library.Controler.Interfaces.Modification;
import org.sun.Library.Controler.Types.Role;

public class CategoryUpdate implements Modification {


    @Override
    public Message modify(Object t) {
        Category category=(Category)t;
        return modifyCategory(category);
    }
    private Message modifyCategory(Category category) {
        return null;
    }
  
}
