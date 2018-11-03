package org.sun.Library.Controler.Book;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private Object id;
    private String name;
    private List<Category> parentCategory=new ArrayList<>();
    public Category() {
        this(null);
    }
    public Category(String name) {
      this(null, name);
    }
    public Category(Object id,String name) {
        setId(id);
        setName(name);
    }

    public void setId(Object id) {
        this.id =  id;
    }

    public Object getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCategory(Category subCategory) {
        this.parentCategory.add(subCategory);
    }

    public List<Category> getParentCategory() {
        return parentCategory;
    }
}
