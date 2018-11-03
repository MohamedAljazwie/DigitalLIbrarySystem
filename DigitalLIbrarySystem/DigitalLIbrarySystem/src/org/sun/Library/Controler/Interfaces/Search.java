package org.sun.Library.Controler.Interfaces;

import java.util.List;

import org.sun.Library.Bean.Message;

public interface Search<T> {
    public Message search(T t);
    public Message search(String by, Object For);
    public Message search (String by,List<Object>For);
    public Message search(String[]by,List<Object>For);
}
