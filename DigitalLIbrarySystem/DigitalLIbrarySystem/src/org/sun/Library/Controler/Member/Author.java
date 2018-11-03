package org.sun.Library.Controler.Member;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sun.Library.Bean.PersonInfo;

public class Author implements Person {
    private PersonInfo info;
    private Set<String> qulefication;
    public Author() {
        this(null);
    }
    public Author(PersonInfo info ) {
       setInfo(info);
        this.qulefication=new HashSet<String>();
    }

    public void addQulefication(String qulefication) {
        this.qulefication.add(qulefication);
    }

    public Set<String> getQulefication() {
        return qulefication;
    }

    public void setInfo(PersonInfo info) {
        this.info = info;
    }

    public PersonInfo getInfo() {
        return info;
    }
    }

