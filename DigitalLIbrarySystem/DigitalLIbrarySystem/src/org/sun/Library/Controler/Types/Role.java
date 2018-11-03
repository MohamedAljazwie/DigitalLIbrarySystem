package org.sun.Library.Controler.Types;

import org.sun.Library.Controler.Member.Author;
import org.sun.Library.Controler.Member.Publisher;


public enum Role {
   Nothing,
    Book,
    Category,
    IssuseBook,
    ReturnBook,
    RenewBook,
    ReserveBook,


    Registration,
    Modification,
    Deletion,
    Search,
    Report,

    Author,
    Student,
    Publisher,
    Admin,
    Person,
    
    
    Fine;

    public enum d {

    }

    @Override
    public String toString() {
        String type = null;
        switch (this) {
        case  Nothing:
        type="Nothing";
        break;
        case Person :
        type="Person";
        break;
        case Admin:
            type = "Admin";
            break;
        case Author:
            type = "Author";
            break;
        case Publisher:
            type = "Publisher";
            break;
        case Student:
            type = "Student";
            break;
        case Book:
            type = "Book";
            break;
        case Category:
            type = "Category";
            break;
        case IssuseBook:
            type = "IssuseBook";
            break;
        case ReturnBook:
            type = "ReturnBook";
            break;
        case RenewBook:
            type = "RenewBook";
            break;
        case ReserveBook:
            type = "ReserveBook";
            break;
        case Fine :
            type="Fine";
         break;
        default:
            type = null;
            break;
        }
        return type;
    }

}
