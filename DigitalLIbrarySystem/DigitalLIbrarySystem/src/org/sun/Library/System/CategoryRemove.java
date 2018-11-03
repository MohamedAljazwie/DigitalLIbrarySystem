package org.sun.Library.System;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Book.Category;
import org.sun.Library.Controler.Interfaces.Deletion;
import org.sun.Library.Controler.Types.Role;

public class CategoryRemove implements Deletion {
    @Override
    public Message remove(Object t) {
        Category Category=(Category)t;
        return deleteCategory(Category);
    }
    private Message deleteCategory(Category Category) {
        return null;
    }
}
