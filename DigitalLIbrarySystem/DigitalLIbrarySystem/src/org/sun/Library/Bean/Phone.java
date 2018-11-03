package org.sun.Library.Bean;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;


public class Phone implements Serializable{
    private Set<String> number;
    public Phone() {
        number=new HashSet<String>();
    }

    public void addNumber(String number) {
       this.number.add(number);
    }

    public Set<String> getNumber() {
        return number;
    }
}
